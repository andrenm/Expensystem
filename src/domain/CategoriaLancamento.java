/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author benjamin.psjunior
 */
public class CategoriaLancamento {
    
    private String nome;    

    public CategoriaLancamento() {}

    public CategoriaLancamento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
