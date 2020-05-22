/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ThreadAuditoria extends Thread {
    @Override
    public void run(){
        
        try  {
            while(Config.getInstance().GetFlagAuditoria()){
                for(int x = 0; x< Config.getInstance().GetMsgAuditoria().size() ;x++){
                        String MsgGravar = (String)Config.getInstance().GetMsgAuditoria().get(x);
                        String nome = System.getProperty("user.dir") + "/src/BancoTxt/Log.txt";
                        String path = nome.replace("Desafio/", "BusinessRules/");
                        FileWriter arq = new FileWriter(path, true);
                        BufferedWriter gravarArq = new BufferedWriter(arq);
                        gravarArq.write(MsgGravar);
                        gravarArq.newLine();
                        gravarArq.flush();

                        arq.close();
                        Config.getInstance().GetMsgAuditoria().remove(x);    
                }
                
                Thread.sleep(1000);
                

           
            }
            
        } 
        catch (IOException e) {
            System.err.printf("Erro ao salvar log: %s.\n", e.getMessage());
        
        }catch (InterruptedException ex) {
                 Logger.getLogger(ThreadAuditoria.class.getName()).log(Level.SEVERE, null, ex);
             }
        
    }            
}
