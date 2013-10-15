/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;

/**
 *
 * @author benjamin.psjunior
 */
public class Usuario {
    
    private int id;
    private String email;
    private String nome;
    private char[] senha;
    private List<Lancamento> lancamentos;
    
    public Usuario(String nome,char[] senha)
    {
        this.nome = nome;
        this.senha = senha;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char[] getSenha() {
        return senha;
    }

    public void setSenha(char[] senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }
}
