/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

/**
 *
 * @author 082170006
 */
public class Config {
    private static Config uniqueInstance;
    
    private Config() {
    
    }
    
    public static synchronized Config getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Config();
        
        return uniqueInstance;
    }
    
    
}
