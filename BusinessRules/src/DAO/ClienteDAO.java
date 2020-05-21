/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Config;
import Objects.Cliente;
import Objects.Usuario;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author 082170019
 */
public class ClienteDAO {

    public void SalvarCliente(Cliente cli) {

        try {
           
            FileWriter arq = new FileWriter(Config.getInstance().GetArquivo(cli), true);
            BufferedWriter gravarArq = new BufferedWriter(arq);
            gravarArq.write(cli.GetNome() + ";" + cli.GetSobreNome() + ";"
                    + cli.GetSexo());
            gravarArq.newLine();
            gravarArq.flush();
            arq.close();
            System.out.println("Cleinte Cadastrado com sucesso !");
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

    }
}
