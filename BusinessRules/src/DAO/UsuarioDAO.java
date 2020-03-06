/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Objects.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author 082170019
 */
public class UsuarioDAO {
    
    public int ValidaUsuario(Usuario user ){
           int retorno = 3;
                 try {
                   String nome = "Z:\\DesafioJava\\DesafioJava\\Usuario.txt";
                  FileReader arq = new FileReader(nome);
                  BufferedReader lerArq = new BufferedReader(arq);

                  String linha = lerArq.readLine();
                  while (linha != null) {
                 
                   
                    linha = lerArq.readLine(); // lê da segunda até a última linha
                    String[] usuario = linha.split("|");
                  
                    if(usuario[0] == user.GetUsuario() && usuario[1] ==user.GetSenha()){
                        return Integer.parseInt(usuario[2]);
                    }
                  }
                  arq.close();
                  return retorno;
                } catch (IOException e) {
                    System.err.printf("Erro na abertura do arquivo: %s.\n",
                      e.getMessage());
                }
         return retorno;
    }
    
}
