package dao;

import domain.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import com.thoughtworks.xstream.XStream;

/**
 *
 * @author benjamin.psjunior
 */
public class ManipuladorXML {   
    
    // diretorio para busca dos arquivos XML
    public static String PATH_XML = "C:\\Users\\benjamin.psjunior\\Documents\\NetBeansProjects\\Expensystem\\trunk\\src\\dao\\";    
    
    public Usuario searchLogin(String email, String senha) {       
        
        Usuario userReturn = null;        
        ArrayList<Usuario> userList = null;
        
        //get users list
        userList = returnXML("expensys.xml");
        
        if (userList == null)
            return null;
        
        for (Usuario userL : userList) {       
            if (userL.getEmail().equals(email) && new String(userL.getSenha()).equals(senha)) {                     
                userReturn = userL;                
                break;
            }
        }
        
        return userReturn;
    }
    
    public ArrayList returnXML(String arquivo) {        
       
    	ArrayList objectList = null;
        
        //init XStrem
    	XStream xstream = new XStream();        
    	xstream.alias("usuario", Usuario.class);
    	xstream.alias("lancamento", Lancamento.class);
    	xstream.alias("categoriaLancamento", CategoriaLancamento.class);		
    	
    	try {
            
            BufferedReader ler = new BufferedReader(new FileReader(PATH_XML + arquivo));             
            objectList = (ArrayList<Usuario>) xstream.fromXML(ler);
            
            //free memory
    	    ler.close();
    				    		
    	} catch(IOException e) {            
            System.out.println("O arquivo nao foi localizado.");
    	}
        
    	return objectList;
    }
}


