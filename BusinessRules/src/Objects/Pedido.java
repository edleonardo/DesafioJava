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
public class Pedido extends Produto {

    public Pedido() {
        SetNomeArquivo("Pedido.txt");
    }

    private int Quantidade;

    private String Cliente;

    public int GetQuantidade() {
        return this.Quantidade;
    }

    public void SetQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String GetCliente() {
        return this.Cliente;
    }

    public void SetCliente(String Cliente) {
        this.Cliente = Cliente;
    }
}
