/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Config.Config;
import DAO.FuncionarioDAO;
import DAO.ProdutoDAO;
import Objects.Funcionario;
import Objects.Produto;
import desafio.Desafio;
import java.util.Scanner;

/**
 *
 * @author 082170006
 */
public class EstadoCadastroProduto extends MaquinaEstado {

    @Override
    public boolean Executa() {
        boolean sair = false;
        try {
            Produto prod = new Produto();
            Scanner scan = new Scanner(System.in);

            System.out.println("Digite a descrição do Produto");
            prod.SetDescricao(scan.nextLine());
            System.out.println("Digite o Valor");
            prod.SetPreco(Double.parseDouble(scan.nextLine()));

            // TODO - Validação de senha
            ProdutoDAO DAO = new ProdutoDAO();
            DAO.SalvarProduto(prod);
             //SALVA MSG AUDITORIA PARA A THREAD SALVAR PARARELO
            Config.getInstance().SetMsgAuditoria("Pedido", prod.GetDescricao());
          
            Desafio.estado = EnumEstadoConsole.MENU.getEstadoMaquina();

        } catch (NumberFormatException e) {
            System.out.println("Digite somente numeros no campo por valor");
            return false;
        } catch (Exception e) {
            System.err.printf("Erro ao salvar Produto \n",
                    e.getMessage());
        }
        return sair;
    }

}
