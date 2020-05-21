/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Config.Config;
import DAO.PedidoDAO;
import DAO.ProdutoDAO;
import Objects.Pedido;
import Objects.Produto;
import desafio.Desafio;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
<<<<<<< HEAD
            //SALVA MSG AUDITORIA PARA A THREAD SALVAR PARARELO
            Config.getInstance().SetMsgAuditoria("Produto", pedido.GetDescricao());
=======
            Config.getInstance().SalvarLog("Pedido", pedido.GetDescricao());
>>>>>>> 98d2a0ff72c2c2072c2b2d72ea91940d67d53b9a
            System.out.println("Deseja imprimir?\n1 - Sim\nQualquer outra tecla - Não");

            if (Integer.parseInt(scan.nextLine()) == 1) {
                DAOPedido.Imprimir(pedido);
            }

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
