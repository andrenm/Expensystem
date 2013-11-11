package controller;

import domain.Lancamento;
import java.util.ArrayList;


/**
 *
 * @author André
 */
public class CtrlLancamentos {
    
 
    public String AdicionaLancamentos(String nome, String valor, String Categoria, int Tipo)
    {
       CtrlGastos gerLanc = new CtrlGastos();
  
       double valorFinal = 0;
       valorFinal= Double.parseDouble(valor.replace("R$", "").trim());
       
       try
       {
           Lancamento lan = new Lancamento(nome,valorFinal,Categoria,Tipo);
           //TODO: adicona valores  como novo lançamento
       }
       catch(Exception ex)
       {
           throw  ex;
       }
        
       ArrayList<Lancamento> LLan = new ArrayList<Lancamento>();
       LLan = gerLanc.listaLancamentos();
       
       int count =0;
       for(int i =0; i < LLan.size(); i++)
       {
           if(LLan.get(i).getDescricao() != nome)
           {
               count ++;
           }
       }
       
       if(count ==  LLan.size())
       {
           return "Ocorreu um erro durante o processo, o lançamento não foi gravado.";
       }
        return "Lançamento gravado com sucesso.";
    }
}
