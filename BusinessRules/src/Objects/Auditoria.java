/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Usuario
 */
public class Auditoria {
    private String MsgAuditoria;
    private boolean FlagGravado;
    
    
    public void SetMsgAuditoria(String msg){
        MsgAuditoria = msg;
    }
    public String GetMsgAuditoria(){
       return MsgAuditoria ;
    }
     public void SetFlagGravado(boolean bol){
        FlagGravado = bol;
    }
    public boolean GetFlagGravado(){
       return FlagGravado ;
    }
}
