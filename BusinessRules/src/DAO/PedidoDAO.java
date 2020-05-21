/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Config;
import Objects.Pedido;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author 082170019
 */
public class PedidoDAO {

    public void SalvarPedido(Pedido ped) {

        try {

            FileWriter arq = new FileWriter(Config.getInstance().GetArquivo(ped), true);
            BufferedWriter gravarArq = new BufferedWriter(arq);
            gravarArq.write(ped.GetDescricao() + ";" + ped.GetQuantidade());
            gravarArq.newLine();
            gravarArq.flush();

            arq.close();

            System.out.println("Pedido Cadastrado com sucesso !");
        } catch (IOException e) {
            System.err.printf("Erro ao salvar o Pedido: %s.\n",
                    e.getMessage());
        }

    }

    public void Imprimir(Pedido ped) {

        try {
            String nome = System.getProperty("user.dir") + "/src/BancoTxt/Imprimir.txt";
            String path = nome.replace("Desafio/", "BusinessRules/");
            FileWriter arq = new FileWriter(path, true);
            BufferedWriter gravarArq = new BufferedWriter(arq);
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date data = new Date(System.currentTimeMillis());
            data.getTime();
            String formatDate = formato.format(data);
            gravarArq.write(ped.GetDescricao() + ";" + ped.GetQuantidade() + ";" + formatDate + "; 0");
            gravarArq.newLine();
            gravarArq.flush();

            arq.close();

            System.out.println("Pedido Cadastrado com sucesso !");
        } catch (IOException e) {
            System.err.printf("Erro ao salvar o Pedido: %s.\n",
                    e.getMessage());
        }

    }

}
