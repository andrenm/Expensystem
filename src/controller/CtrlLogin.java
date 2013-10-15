/*alterado*/
package controller;

//vendor's packages
import gui.*;
import domain.Usuario;
import dao.ManipuladorXML;

/**
 *
 * @author benjamin.psjunior
 */
public class CtrlLogin {   
        
    private LoginGUI windowLogin;
    //private Modelo modelo;
    private Usuario login;
    
    public CtrlLogin() {
        
        windowLogin = new LoginGUI(this);
        windowLogin.setVisible(true);
        
        //modelo = new Modelo();
    }
    
    public String ValidaLogin(Usuario user)
    {   
        try {
            
            ManipuladorXML xml = new ManipuladorXML();
            System.out.println(user.getEmail());
            System.out.println(user.getSenha());
            login = xml.searchLogin(user.getEmail(), user.getSenha());
            
            System.out.println("AQUIII:");
            System.out.println(login);
            
            if(login != null) {
                return "LOGADO";
            } else {
                return "INCORRETO";
            }
            
        } catch(Exception ex) {
            throw ex;
        }
    }
}
