/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

<<<<<<< HEAD
import Objects.Auditoria;
=======
>>>>>>> 98d2a0ff72c2c2072c2b2d72ea91940d67d53b9a
import Objects.Comum;
import Objects.Usuario;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
<<<<<<< HEAD
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
=======
import java.util.Date;
>>>>>>> 98d2a0ff72c2c2072c2b2d72ea91940d67d53b9a

/**
 *
 * @author 082170006
 * @param <E>
 */
public class Config<E extends Comum> {

    private static Config uniqueInstance;
    private static Usuario usuario;
<<<<<<< HEAD
    private List<Auditoria> MsgAuditoria  = new ArrayList<Auditoria>();
    private static boolean FlagAuditoria;
    ThreadAuditoria Thread  = new ThreadAuditoria();
=======
>>>>>>> 98d2a0ff72c2c2072c2b2d72ea91940d67d53b9a

    private Config() {

    }

    public static synchronized Config getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Config();
<<<<<<< HEAD
            
        }
        return uniqueInstance;
    }
    public void StartThreadAuditoria (){
        FlagAuditoria = true;
        Thread.start();
    }
    public void StopThreadAuditoria() throws InterruptedException{
    
        FlagAuditoria = false;
        Thread.join();
    }
    public void SetFlagAuditoria(boolean bol){
        FlagAuditoria = bol;
    
    }
    public boolean GetFlagAuditoria(){
        return FlagAuditoria;
    }
    public void SetMsgAuditoria(String Cadastrado, String Value){
        Auditoria aut = new Auditoria();
        aut.SetMsgAuditoria("Foi realizado o cadastro do " + Cadastrado + ": " + Value + " -- Pelo usuario: " + Config.getInstance().GetUsuario().GetUsuario() + " Na hora: " + new Date(System.currentTimeMillis()));
        aut.SetFlagGravado(false);
        MsgAuditoria.add(aut);
    
    }
    public void AlterarFlagAuditoria(int index){
        MsgAuditoria.get(index).SetFlagGravado(true);
    
    }
    public List<Auditoria> GetMsgAuditoria(){
        return MsgAuditoria;
    
    }
   
            
=======
        }

        return uniqueInstance;
    }
>>>>>>> 98d2a0ff72c2c2072c2b2d72ea91940d67d53b9a

    public void SetUsuario(Usuario user) {
        usuario = user;
    }

    public Usuario GetUsuario() {
        return usuario;
    }

    public String GetArquivo(E obj) {
        String nome = System.getProperty("user.dir") + "/src/BancoTxt/" + obj.GetNomeArquivo();
        String path = nome.replace("Desafio/", "BusinessRules/");
        return path;
    }

<<<<<<< HEAD
    public void SalvarLog() {
        
=======
    public void SalvarLog(String Cadastrado, String Value) {
        try {
            String nome = System.getProperty("user.dir") + "/src/BancoTxt/Log.txt";
            String path = nome.replace("Desafio/", "BusinessRules/");
            FileWriter arq = new FileWriter(path, true);

            BufferedWriter gravarArq = new BufferedWriter(arq);
            gravarArq.write("Foi realizado o cadastro do " + Cadastrado + ": " + Value + " -- Pelo usuario: " + Config.getInstance().GetUsuario().GetUsuario() + " Na hora: " + new Date(System.currentTimeMillis()));
            gravarArq.newLine();
            gravarArq.flush();

            arq.close();

            System.out.println("Log salvo com sucesso !");
        } catch (IOException e) {
            System.err.printf("Erro ao salvar log: %s.\n", e.getMessage());
        }
>>>>>>> 98d2a0ff72c2c2072c2b2d72ea91940d67d53b9a

    }

}
