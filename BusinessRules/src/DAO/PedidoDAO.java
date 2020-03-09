/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Objects.Pedido;
import Objects.Produto;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import javafx.scene.chart.PieChart;

/**
 *
 * @author 082170019
 */
public class PedidoDAO {
    public void SalvarPedido(Pedido ped ){
          
                 try { 
                  String nome = "Z:\\DesafioJava\\DesafioJava\\Pedido.txt";
                  FileWriter arq = new FileWriter(nome,true);
                  BufferedWriter gravarArq = new BufferedWriter(arq);
                  gravarArq.write(ped.GetDescricao()+ ";" + ped.GetQuantidade());
                  gravarArq.newLine();
                  gravarArq.flush();
                  
                 
                  
                  
                  arq.close();
              
                    System.out.println("Pedido Cadastrado com sucesso !");  
                } catch (IOException e) {
                    System.err.printf("Erro ao salvar o Pedido: %s.\n",
                      e.getMessage());
                }
      
    }
    public void Imprimir(Pedido ped ){
          
                 try { 
                  String nome = "Z:\\DesafioJava\\DesafioJava\\Imprimir.txt";
                  FileWriter arq = new FileWriter(nome,true);
                  BufferedWriter gravarArq = new BufferedWriter(arq);
                  Date d = new Date(System.currentTimeMillis());
                  gravarArq.write(ped.GetDescricao()+ ";" + ped.GetQuantidade() + ";" + d.getTime() + "; 0");
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
