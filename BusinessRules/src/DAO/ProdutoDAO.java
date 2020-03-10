/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Objects.Produto;
import Objects.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author 082170019
 */
public class ProdutoDAO {

    public void SalvarProduto(Produto prod) {
        try {
            String nome = "Z:\\DesafioJava\\DesafioJava\\Produto.txt";
            FileWriter arq = new FileWriter(nome, true);
            BufferedWriter gravarArq = new BufferedWriter(arq);
            gravarArq.write(prod.GetDescricao() + ";" + prod.GetPreco());
            gravarArq.newLine();
            gravarArq.flush();

            arq.close();

            System.out.println("Produto Cadastrado com sucesso !");
        } catch (IOException e) {
            System.err.printf("Erro ao salvar o produto: %s.\n",
                    e.getMessage());
        }
    }

    public ArrayList<Produto> ListaProdutos() {
        ArrayList<Produto> Lista = new ArrayList<Produto>();
        try {
            String nome = "Z:\\DesafioJava\\DesafioJava\\Produto.txt";
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = linha = lerArq.readLine();;
            while (linha != null) {

                // lê da segunda até a última linha
                String[] produto = linha.split(";");
                Produto prod = new Produto();
                prod.SetDescricao(produto[0]);
                prod.SetPreco(Double.parseDouble(produto[1]));
                Lista.add(prod);

                linha = lerArq.readLine();
            }
            arq.close();
            return Lista;
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        return Lista;
    }

    public void SalvaLog(Produto prod) {
        try {
            String nome = "/home/atomic/Cursos/DesafioJava/Log.txt";
            FileWriter arq = new FileWriter(nome, true);

            BufferedWriter gravarArq = new BufferedWriter(arq);
            gravarArq.write("Foi realizado o cadastro do produto" + prod.GetDescricao());
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
