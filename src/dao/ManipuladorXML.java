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
    public static String PATH_XML = "C:\\Users\\benjamin.psjunior\\Documents\\NetBeansProjects\\trunk\\src\\dao\\";    
    
    public Usuario searchLogin(String usuario, char[] senha) {       
        
        Usuario userReturn = null;        
        ArrayList<Usuario> userList = null;
        
        System.out.print(userList);
        //get users list
        userList = returnXML("teste.xml");
        
        System.out.print(userList);
        
        if (userList == null)
            return null;
        
        for (Usuario user : userList) {                 
            if (user.getEmail().equals(usuario) && new String(user.getSenha()).equals(senha)) {                     
                userReturn = user;                
                break;
            }
        }	
        
        return userReturn;
    }
    
    public ArrayList returnXML(String arquivo) {
        
        String alias = "usuario";
    	ArrayList objectList = null;
        
        //init XStrem
    	XStream xtream = new XStream();    	
    	xtream.alias(alias, ArrayList.class);  		
    	
    	try {
            
            BufferedReader ler = new BufferedReader(new FileReader(PATH_XML + arquivo));             
            objectList = (ArrayList<Usuario>) xtream.fromXML(ler);
            System.out.println("KKK>");
            //System.out.println(objectList);
            //free memory
    	    ler.close();
    				    		
    	} catch(IOException e) {            
            System.out.println("O arquivo nao foi localizado.");
    	}
        System.out.println(objectList);
    	return objectList;
    }
}


