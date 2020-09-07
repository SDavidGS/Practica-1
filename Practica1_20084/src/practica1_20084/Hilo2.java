package practica1_20084;
import javax.swing.JTextArea;

public class Hilo2 extends Thread{
    private JTextArea area;
    private boolean pausado = false;
    private boolean corriendo = true;
    
    public Hilo2(JTextArea area){
        this.area=area;
    }
    @Override
    public void run(){
        try{
            int i = 0;
            while(true){
                area.append(i + "\n");
                i++;
                sleep(1500);
                synchronized(this){
                    if(pausado)
                        wait();
                    if(!corriendo)
                        join();
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }    
    }
    
    public void pausar(){
        this.pausado = true;
    }
    
    public void continuar(){
        synchronized(this){
            pausado = false;
            notifyAll();
        }
    }
    
    public void parar(){
        this.corriendo = false;
    }
    
}
