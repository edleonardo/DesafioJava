/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import Objects.Auditoria;
import Objects.Comum;
import Objects.Usuario;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 082170006
 * @param <E>
 */
public class Config<E extends Comum> {

    private static Config uniqueInstance;
    private static Usuario usuario;
    private List<Auditoria> MsgAuditoria  = new ArrayList<Auditoria>();
    private static boolean FlagAuditoria;
    ThreadAuditoria Thread  = new ThreadAuditoria();

    private Config() {

    }

    public static synchronized Config getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Config();
            
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

    public void SalvarLog() {
        

    }

}
