/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbeiro;

/**
 *
 * @author Gustavo
 */
public class cliente implements Runnable {
    static int i = 0, o = 0, p = 0; 
    
    
    
    synchronized void chega(barbearia b){
        try{

            if(b.cadeiras.tryAcquire()){
                
                b.semNinguem.release();

                if(b.dormindo.tryAcquire()) b.dormindo.release();
                else b.dormindo.release(2);
                
                b.eperaSentar.release();
                b.cortando.acquire();
                System.out.println("Tomei uma picada " + o++);
                b.cadeiras.release();

                b.semNinguem.acquire();
            }
            else{
                //b.cadeiras.release(); 
                System.out.println("ta chei fui embora " + p++);
            }
        }

        catch(Exception e)
        {}

        
    }
            
    
    
    @Override
    public void run(){
      chega(barbeiro.b);  
    }
    void verificarCadeira(){
        
    }
    
    
}
