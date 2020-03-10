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
public class Produto {

    private String Descricao;
    private double preco;

    public String GetDescricao() {
        return this.Descricao;
    }

    public void SetDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public double GetPreco() {
        return this.preco;
    }

    public void SetPreco(double Preco) {
        this.preco = Preco;
    }
}
