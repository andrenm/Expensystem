/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Lancamento;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public class CtrlGastos {
    
    public ArrayList<Lancamento> listaLancamentos() {
        return CtrlSession.getCurrentUser().getLancamentos();
    }   
    
    public double getTotalDebito() {
       //get lancamentos do usuario
       //TODO: rever o que diferencia os debitos de creditos
       ArrayList<Lancamento> lancamentosUsuario = CtrlSession.getCurrentUser().getLancamentos();       
       double totalDebito = 0;
       
       for (Lancamento lancamento : lancamentosUsuario) {
           totalDebito += lancamento.getValor();           
       }
       
       return Math.round(totalDebito);
    }  
    
    public double getTotalCredito() {
       //get lancamentos do usuario
       //TODO: rever o que diferencia os creditos de debitos
       ArrayList<Lancamento> lancamentosUsuario = CtrlSession.getCurrentUser().getLancamentos();       
       double totalCredito = 0;
       
       for (Lancamento lancamento : lancamentosUsuario) {
           totalCredito += lancamento.getValor();           
       }
       
       return Math.round(totalCredito);       
    }
    
    
}
