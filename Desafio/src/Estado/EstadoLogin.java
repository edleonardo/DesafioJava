/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Config.Config;
import DAO.UsuarioDAO;
import Objects.Usuario;
import desafio.Desafio;
import java.util.Scanner;

/**
 *
 * @author 082170006
 */
public class EstadoLogin extends MaquinaEstado {

    @Override
    public boolean Executa() {
        boolean sair = false;
        Usuario user = new Usuario();
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite seu usuário");
        user.SetUsuario(scan.nextLine());
        System.out.println("Digite sua senha");
        user.SetSenha(scan.nextLine());
        // TODO - Validação de senha
        UsuarioDAO DAO = new UsuarioDAO();
        int Flag = DAO.ValidaUsuario(user);
        if (Flag != 3) {
            user.SetFlag(Flag);
            Config.getInstance().SetUsuario(user);
            Desafio.estado = EnumEstadoConsole.MENU.getEstadoMaquina();

        } else {
            System.out.println("Dados inválidos!");
        }
        return sair;
    }
}
