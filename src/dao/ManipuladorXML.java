package dao;

import com.thoughtworks.xstream.XStream;
import domain.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author benjamin.psjunior
 */
public class ManipuladorXML {   
    
    // diretorio para busca dos arquivos XML
    public static String PATH_XML = "C:\\Users\\senac2012\\Documents\\src\\dao\\";    
    
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
    
    public boolean createUserXml(String email, char[] senha) {  
        
        //init XStrem
    	XStream xstream = new XStream();         
    	xstream.alias("usuario", Usuario.class);
    	xstream.alias("lancamento", Lancamento.class);
    	xstream.alias("categoriaLancamento", CategoriaLancamento.class);
        
        //novo usuario    
        Usuario user = new Usuario(email, senha);     
        
        File arquivo = new File(PATH_XML + "expensys.xml");
        FileOutputStream gravar;
        
        ArrayList xmlExistente = (ArrayList<Usuario>) xstream.fromXML(arquivo);
        //add
        int nextID = xmlExistente.size() + 1;
        user.setId(nextID); 
        xmlExistente.add(user);
        
        String xmlNew;
        xmlNew = xstream.toXML(xmlExistente); 
        
        try {
            gravar = new FileOutputStream(arquivo);
            gravar.write(xmlNew.getBytes());
            gravar.close();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
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


