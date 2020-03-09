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
import com.oracle.jrockit.jfr.DataType;
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

            System.out.println("Digite a função 1 para gerente ou 0 para Vendedor");

            if (Integer.parseInt(scan.nextLine()) != 1 || Integer.parseInt(scan.nextLine()) != 0) {
               throw new Exception("Digite somente funções valídas");
            }
             fun.SetFlag(Integer.parseInt(scan.nextLine()));
            // TODO - Validação de senha
            FuncionarioDAO DAO = new FuncionarioDAO();
            DAO.SalvarFuncionario(fun);
            Desafio.estado = EnumEstadoConsole.MENU.getEstadoMaquina();

        } catch (Exception e) {
            System.err.printf("Erro ao salvar funcionario\n",
                    e.getMessage());
        }

        return sair;
    }

}
