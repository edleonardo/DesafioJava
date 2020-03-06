/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;

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
        estado = EnumEstadoConsole.LOGIN.getEstadoMaquina();
        Boolean saida = false;
        while(!saida) {
            saida = estado.Executa();
        }
    }
}
