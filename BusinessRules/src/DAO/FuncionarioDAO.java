/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Config;
import Objects.Funcionario;
import Objects.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author 082170019
 */
public class FuncionarioDAO {

    public void SalvarFuncionario(Funcionario fun) throws Exception {

        FileReader arq3 = new FileReader(Config.getInstance().GetArquivo(new Usuario()));
        BufferedReader lerArq3 = new BufferedReader(arq3);

        String linha = linha = lerArq3.readLine();;
        while (linha != null) {

            // lê da segunda até a última linha
            String[] usuario = linha.split(";");

            if (usuario[0].equals(fun.GetUsuario())) {
                throw new Exception("Login de funcionario ja cadastrado!");
            }
            linha = lerArq3.readLine();
        }
        arq3.close();

        FileWriter arq = new FileWriter(Config.getInstance().GetArquivo(fun), true);
        BufferedWriter gravarArq = new BufferedWriter(arq);
        gravarArq.write(fun.GetNome() + ";" + fun.GetSobreNome() + ";" + fun.GetFuncao());
        gravarArq.newLine();
        gravarArq.flush();

        FileWriter arq2 = new FileWriter(Config.getInstance().GetArquivo(new Usuario()), true);
        BufferedWriter gravarArq2 = new BufferedWriter(arq2);
        gravarArq2.write(fun.GetUsuario() + ";" + fun.GetSenha() + ";" + fun.GetFlag());
        gravarArq2.newLine();
        gravarArq2.flush();

        arq.close();
        arq2.close();
        System.out.println("Funcionario Cadastrado com sucesso !");

    }

}
