/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Config.Config;
import DAO.FuncionarioDAO;
import DAO.UsuarioDAO;
import Objects.Funcionario;
import Objects.Usuario;
import desafio.Desafio;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 082170006
 */
public class EstadoCadastroFuncionario extends MaquinaEstado {

    @Override
    public boolean Executa() {
        boolean sair = false;
        try {
            Funcionario fun = new Funcionario();
            Scanner scan = new Scanner(System.in);

            System.out.println("Digite o nome");
            fun.SetNome(scan.nextLine());
            System.out.println("Digite o Sobrenome");
            fun.SetSobrenome(scan.nextLine());

            System.out.println("Digite o usuario");
            fun.SetUsuario(scan.nextLine());
            System.out.println("Digite a senha");
            fun.SetSenha(scan.nextLine());

            System.out.println("Digite a função 0 para Vendedor ou 1 para Gerente");
            int valorFuncao = Integer.parseInt(scan.nextLine());

            if (valorFuncao > 1 || valorFuncao < 0) {
                throw new Exception("Digite somente funções valídas");
            } else {
                if (valorFuncao == 0) {
                    fun.SetFuncao("Vendedor");
                } else {
                    fun.SetFuncao("Gerente");
                }
            }
            fun.SetFlag(valorFuncao);
            FuncionarioDAO DAO = new FuncionarioDAO();
            DAO.SalvarFuncionario(fun);

             //SALVA MSG AUDITORIA PARA A THREAD SALVAR PARARELO
            Config.getInstance().SetMsgAuditoria("Funcionario", fun.GetNome());

            Desafio.estado = EnumEstadoConsole.MENU.getEstadoMaquina();

        } catch (NumberFormatException e) {
            System.out.println("Digite somente numeros no campo quantidade");
            return false;
        } catch (Exception e) {
            System.err.printf("Erro ao salvar funcionario\n" + e.getMessage());

        }

        return sair;
    }

}
