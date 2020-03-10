/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author 082170019
 */
public class Usuario {

    private String usuario;

    private String senha;

    private int flag;

    public String GetUsuario() {
        return usuario;
    }

    public void SetUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String GetSenha() {
        return senha;
    }

    public void SetSenha(String senha) {
        this.senha = senha;
    }

    public int GetFlag() {
        return flag;
    }

    public void SetFlag(int flag) {
        this.flag = flag;
    }
}
