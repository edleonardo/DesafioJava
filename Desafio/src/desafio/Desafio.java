/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;

<<<<<<< HEAD
import Config.Config;
=======
>>>>>>> 98d2a0ff72c2c2072c2b2d72ea91940d67d53b9a
import Estado.EnumEstadoConsole;
import Estado.MaquinaEstado;

/**
 *
 * @author 082170006
 */
public class Desafio {
    public static MaquinaEstado estado;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
<<<<<<< HEAD
         Config.getInstance().StartThreadAuditoria();
=======
>>>>>>> 98d2a0ff72c2c2072c2b2d72ea91940d67d53b9a
        estado = EnumEstadoConsole.LOGIN.getEstadoMaquina();
        Boolean saida = false;
        while(!saida) {
            saida = estado.Executa();
        }
    }
}
