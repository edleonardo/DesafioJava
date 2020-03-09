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
public class Funcionario extends  Usuario{
    private String nome ;
    private String SobreNome;
    
    
    public void SetNome(String Nome){
            this.nome = Nome;
    }
    public String GetNome( ){
    return this.nome;
    }
    
       public void SetSobrenome(String Sobrenome){
            this.SobreNome = Sobrenome;
    }
    public String GetSobreNome( ){
    return this.SobreNome;
    }

}
