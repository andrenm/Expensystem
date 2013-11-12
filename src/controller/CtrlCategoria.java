package controller;

import domain.CategoriaLancamento;
import java.util.ArrayList;
/**
 *
 * @author André
 */
public class CtrlCategoria {
    
    public ArrayList<String> listaCategorias()
    {
        //TODO: conexao com o XML para retornar as categorias
        
      CategoriaLancamento cat1 = new CategoriaLancamento("Eletronicos");
      CategoriaLancamento cat2 = new CategoriaLancamento("Supermercado");
      CategoriaLancamento cat3 = new CategoriaLancamento("Viajem");

        ArrayList<String> ArrCat = new ArrayList<String>();
        ArrCat.add(cat1.getNome());
        ArrCat.add(cat2.getNome());
        ArrCat.add(cat3.getNome());
        
       return ArrCat;
    }
}
