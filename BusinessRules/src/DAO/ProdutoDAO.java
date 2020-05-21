/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Config;
import Objects.Produto;
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

            FileWriter arq = new FileWriter(Config.getInstance().GetArquivo(prod), true);
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

            FileReader arq = new FileReader(Config.getInstance().GetArquivo(new Produto()));
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

}
