/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author benjamin.psjunior
 */
public class Lancamento extends CategoriaLancamento{
    
    private String descricao;
    private double valor;
    private int status;
    private int tipo;
    private String DataInclusao;
    private List<CategoriaLancamento> categorias;

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public String getDataInclusao()
     {
         return DataInclusao;
    }
//    public void setDataInclusao(Date DataInclusao) {
//        
//         DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//         df.format(DataInclusao);
//         
//         this.DataInclusao = DataInclusao;
//    }
    
    public Lancamento()
    {
    }
    
    public Lancamento(String descricao,double valor, String nomeCategoria)
    {
        Date d = new Date();
                
        this.descricao = descricao;
        this.valor = valor;
        setNome(nomeCategoria);
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.DataInclusao =  df.format(d).toString();
    }
    
     public String getCategoriaLancamento() {
        return getNome();
    }

    public void addCategoriaLancamento(String nome) {
        CategoriaLancamento cl = new CategoriaLancamento(nome);
        this.categorias.add(cl);
    }
}
