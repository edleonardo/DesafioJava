/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Config.Config;
import Objects.Usuario;
import desafio.Desafio;
import java.util.Scanner;

/**
 *
 * @author 082170006
 */
public class EstadoCadastro extends MaquinaEstado {

    @Override
    public boolean Executa() {
        boolean sair = false;
        System.out.println("*** Seja Bem-Vindo ao sistema, escolha uma das opções abaixo");
        System.out.println("0 - Sair\n1 - Cadastrar um Pedido\n2 - Cadastrar um Produto\n3 - Cadastrar um Cliente");

        Usuario user = Config.getInstance().GetUsuario();

        if (user.GetFlag() == 1) {
            System.out.println("4 - Cadastrar um Funcionario");
        }

        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();
        switch (opcao) {
            case 0:
                Desafio.estado = EnumEstadoConsole.LOGIN.getEstadoMaquina();
                break;
            case 1:
                Desafio.estado = EnumEstadoConsole.CADASTRO_PEDIDO.getEstadoMaquina();
                break;
            case 2:
                Desafio.estado = EnumEstadoConsole.CADASTRO_PRODUTO.getEstadoMaquina();
                break;
            case 3:
                Desafio.estado = EnumEstadoConsole.CADASTRO_CLIENTE.getEstadoMaquina();
                break;
            case 4:
                if (user.GetFlag() == 1) {
                    Desafio.estado = EnumEstadoConsole.CADASTRO_FUNCIONARIO.getEstadoMaquina();
                }
                break;
        }
        return sair;
    }

}
