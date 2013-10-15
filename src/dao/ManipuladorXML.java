package dao;

import domain.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import com.thoughtworks.xstream.XStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author benjamin.psjunior
 */
public class ManipuladorXML {   
    
    public static void main(String[] args) {
        
      /*XStream xstream = new XStream();      
        
      try {
          
        // carrega o arquivo xml
        File f = new File("C:\\Users\\benjamin.psjunior\\Documents\\NetBeansProjects\\Expensystem\\src\\dao\\teste.xml");
        FileInputStream input = new FileInputStream(f);
        
        xstream.alias("usuario", Usuario.class);        
        //xstream.alias("lancamento", Lancamento.class);        
        //xstream.alias("categoriaLancamento", CategoriaLancamento.class);
        // cria um objeto de Pessoa, contendo os dados lidos no xml
        Usuario u = (Usuario) xstream.fromXML(input);        
        // imprime os dados
        //System.out.println(u);
        System.out.println("Nome: " + u.getNome());
        //System.out.println("Email: " + u.getEmail());
        
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (Exception e){
        e.printStackTrace();
      }*/
       // System.out.println(this.lerXML());
                
    }
    
    public ArrayList lerXML() {
        
        try {
            
            XStream xStream = new XStream();
            //xStream.alias("enderecos", ArrayList.class);
            //xStream.processAnnotations(Endereco.class);
 
            BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\benjamin.psjunior\\Documents\\NetBeansProjects\\Expensystem\\src\\dao\\teste.xml"));
            
            ArrayList dados = (ArrayList) xStream.fromXML(input);
            input.close();
            
            return dados;
 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
}


