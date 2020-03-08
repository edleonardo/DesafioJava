/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import Objects.Usuario;

/**
 *
 * @author 082170006
 */
public class Config {
    private static Config uniqueInstance;
    private static Usuario usuario;
    
    private Config() {
    
    }
    
    public static synchronized Config getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Config();
        
        return uniqueInstance;
    }
   
        
    
    public void SetUsuario(Usuario user){
           usuario = user;
    }
    
   public  Usuario GetUsuario(Usuario user){
          return usuario ;
    }
    
}
