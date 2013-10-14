/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author André
 */
public class GerenciaGastos extends Lancamento{
    
    public ArrayList<Lancamento> listaLancamentos()
    {
        Lancamento lanc1 = new Lancamento("Compra de smartphone",1450.0,"Eletronicos");
        Lancamento lanc2 = new Lancamento("Compras do mês",230.20,"Supermercado");
        Lancamento lanc3 = new Lancamento("Venda da minha TV",1800.0,"Eletronicos");

        ArrayList<Lancamento> LLan = new ArrayList<Lancamento>();
            
        LLan.add(lanc1);        
        LLan.add(lanc2);
        LLan.add(lanc3);
        
        return LLan ;
    }
    
    public double listaDebitos()
    {
        // TODO: Puxar valor do XML
        Lancamento lanc1 = new Lancamento("Compra de smartphone",1450.0,"Eletronicos");
        Lancamento lanc2 = new Lancamento("Compras do mês",230.20,"Supermercado");
        Lancamento lanc3 = new Lancamento("Venda da minha TV",1800.0,"Eletronicos");
        
       double[] debitos ={lanc1.getValor(),lanc2.getValor(),lanc3.getValor()};
       double totalDebito = 0;
       
       for(int i=0; i< debitos.length; i++)
       {
           totalDebito += debitos[i];
       }
       
       return totalDebito;
    }
    
       public double listaCreditos()
    {
        // TODO: Puxar valor do XML
        Lancamento lanc1 = new Lancamento("Salario",5200.0,"Salario");
        
       double[] creditos ={lanc1.getValor()};
       double totalCredito = 0;
       
       for(int i=0; i< creditos.length; i++)
       {
           totalCredito += creditos[i];
       }
       
       return totalCredito;
    }
}
