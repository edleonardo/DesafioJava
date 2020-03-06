/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

/**
 *
 * @author 082170006
 */
public enum EnumEstadoConsole {
    
    LOGIN (new EstadoLogin()),
    MENU (new EstadoMenu()),
    CADASTRO (new EstadoCadastro()),
    CADASTRO_PRODUTO (new EstadoCadastroProduto()),
    CADASTRO_PEDIDO (new EstadoCadastroPedido()),
    CADASTRO_FUNCIONARIO (new EstadoCadastroFuncionario());
    
    private final MaquinaEstado estadoMaquina;   
        
    EnumEstadoConsole(MaquinaEstado estadoMaquina){
        this.estadoMaquina = estadoMaquina;
    }
    
    public MaquinaEstado getEstadoMaquina() {
        return estadoMaquina;
    }
}
