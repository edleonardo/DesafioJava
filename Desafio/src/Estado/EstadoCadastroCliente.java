/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import DAO.ClienteDAO;
import Objects.Cliente;
import desafio.Desafio;
import java.util.Scanner;

/**
 *
 * @author 082170019
 */
public class EstadoCadastroCliente extends MaquinaEstado {

    @Override
    public boolean Executa() {
        boolean sair = false;
        try {
            Cliente cli = new Cliente();
            Scanner scan = new Scanner(System.in);

            System.out.println("Digite o nome");
            cli.SetNome(scan.nextLine());
            System.out.println("Digite o Sobrenome");
            cli.SetSobrenome(scan.nextLine());

            System.out.println("Digite 0 para Masculino ou 1 para Feminino");
            int validaSexo = Integer.parseInt(scan.nextLine());

            if (validaSexo == 0) {
                cli.SetSexo("Masculino");
            } else if (validaSexo == 1) {
                cli.SetSexo("Feminino");
            } else {
                throw new Exception ("Valor inválido");
            }
            // TODO - Validação de senha
            ClienteDAO DAO = new ClienteDAO();
            DAO.SalvarCliente(cli);
            DAO.SalvaLog(cli);
            Desafio.estado = EnumEstadoConsole.MENU.getEstadoMaquina();

        } catch (Exception e) {
            System.err.printf("Erro ao salvar cliente\n",
                    e.getMessage());
        }

        return sair;
    }
}
