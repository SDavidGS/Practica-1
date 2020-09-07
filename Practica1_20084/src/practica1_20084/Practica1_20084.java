package practica1_20084;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *Nombre de Practica: Competenecias
 */
public class Practica1_20084 extends JFrame{
    private JButton bRun,bPausa,bDetener;
    private JLabel etiHilo1,etiHilo2;
    private JTextArea areaHilo1,areaHilo2;
    private JScrollPane jsHilo1,jsHilo2;
    public Practica1_20084(){
        setSize(400,400);
        setTitle("Condiciones de competencias");
        MisComponentes();
    }
    private void MisComponentes(){
        bRun = new JButton("Run");
        bPausa = new JButton("Pausar");
        bDetener = new JButton("Detener");
        areaHilo1= new JTextArea();
        areaHilo2 = new JTextArea();
        jsHilo1 = new JScrollPane(areaHilo1);
        jsHilo2 = new JScrollPane(areaHilo2);
        etiHilo1 = new JLabel("Hilo 1");
        etiHilo2= new JLabel("Hilo 2");
        
        setLayout(null);
        bRun.setBounds(20,100,100,25);
        bPausa.setBounds(20,150,100,25);
        bDetener.setBounds(20,200,100,25);
        add(bRun);
        add(bPausa);
        add(bDetener);
       
        etiHilo1.setBounds(150+30,20,100,25);
        etiHilo2.setBounds(250+30,20,100,25);
        add(etiHilo1);
        add(etiHilo2);
        
        jsHilo1.setBounds(150,40,90,300);
        jsHilo2.setBounds(250,40,90,300);
        add(jsHilo1);
        add(jsHilo2);
        
        Hilo1 t1 = new Hilo1(areaHilo1);
        Hilo2 t2 = new Hilo2(areaHilo2);
        
        bRun.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               
               t1.start();
               t2.start();
           } 
        });
        
        bPausa.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               if(bPausa.getText().equals("Pausar")){
                    bPausa.setText("Continuar");
                    t1.pausar();
                    t2.pausar();
                }else{
                    bPausa.setText("Pausar");
                    t1.continuar();
                    t2.continuar();
                }
           } 
        });
        
        bDetener.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
                t1.parar();
                t2.parar();
                bRun.setEnabled(true);
           } 
        });
    }
    public static void main(String[] args) {
       Practica1_20084 fr = new Practica1_20084();
       fr.setVisible(true);
       fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
