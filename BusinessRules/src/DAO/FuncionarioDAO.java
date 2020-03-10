/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Objects.Funcionario;
import Objects.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author 082170019
 */
public class FuncionarioDAO {

    public void SalvarFuncionario(Funcionario fun) {

        try {
            String nome = "/home/atomic/Cursos/DesafioJava/Funcionario.txt";
            FileWriter arq = new FileWriter(nome, true);
            BufferedWriter gravarArq = new BufferedWriter(arq);
            gravarArq.write(fun.GetNome() + ";" + fun.GetSobreNome() + ";" + fun.GetFuncao());
            gravarArq.newLine();
            gravarArq.flush();

            String nome2 = "/home/atomic/Cursos/DesafioJava/Usuario.txt";
            FileWriter arq2 = new FileWriter(nome2, true);
            BufferedWriter gravarArq2 = new BufferedWriter(arq2);
            gravarArq2.write(fun.GetUsuario() + ";" + fun.GetSenha() + ";" + fun.GetFlag());
            gravarArq2.newLine();
            gravarArq2.flush();

            arq.close();
            arq2.close();
            System.out.println("Funcionario Cadastrado com sucesso !");
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

    }

    public void SalvaLog(Funcionario fun) {
        try {
            String nome = "/home/atomic/Cursos/DesafioJava/Log.txt";
            FileWriter arq = new FileWriter(nome, true);
            
            BufferedWriter gravarArq = new BufferedWriter(arq);
            gravarArq.write("Foi realizado o cadastro do " + fun.GetFuncao() + " " + fun.GetNome());
            gravarArq.newLine();
            gravarArq.flush();

            arq.close();

            System.out.println("Log salvo com sucesso !");
        } catch (IOException e) {
            System.err.printf("Erro ao salvar log: %s.\n",
                    e.getMessage());
        }
    }

}
