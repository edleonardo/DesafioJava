/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import DAO.PedidoDAO;
import DAO.ProdutoDAO;
import Objects.Pedido;
import Objects.Produto;
import desafio.Desafio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 082170006
 */
public class EstadoCadastroPedido extends MaquinaEstado {

    @Override
    public boolean Executa() {
        boolean sair = false;
        try {
            Pedido pedido = new Pedido();
            Scanner scan = new Scanner(System.in);

            System.out.println("Digite o Produto\n");

            ProdutoDAO DAO = new ProdutoDAO();
            List<Produto> ListaProduto = DAO.ListaProdutos();
            for (int x = 0; x < ListaProduto.size(); x++) {
                System.out.println(x + " - " + ListaProduto.get(x).GetDescricao());

            }

            int valor = Integer.parseInt(scan.nextLine());

            if (valor < 0 || valor > ListaProduto.size()) {
                throw new Exception("Digite somente produtos da lista");
            }
            pedido.SetDescricao(ListaProduto.get(valor).GetDescricao());

            System.out.println("Digite a Quantidade");
            pedido.SetQuantidade(Integer.parseInt(scan.nextLine()));

            // TODO - Validação de senha
            PedidoDAO DAOPedido = new PedidoDAO();
            DAOPedido.SalvarPedido(pedido);

            System.out.println("Deseja imprimir 1 para sim qualquer coisa para não");

            if (Integer.parseInt(scan.nextLine()) == 1) {
                DAOPedido.Imprimir(pedido);

            }
            pedido.SetQuantidade(Integer.parseInt(scan.nextLine()));

            Desafio.estado = EnumEstadoConsole.MENU.getEstadoMaquina();

        } catch (NumberFormatException e) {
            System.out.println("Digite somente numeros no campo quantidade");
            return false;
        } catch (Exception e) {
            System.err.printf("Erro ao salvar Pedido \n",
                    e.getMessage());
        }
        return sair;
    }

}
