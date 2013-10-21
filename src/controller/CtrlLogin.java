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
    }
    
    public String ValidaLogin(Usuario user)
    {   
        try {
            
            ManipuladorXML xml = new ManipuladorXML();
            login = xml.searchLogin(user.getEmail(), new String(user.getSenha()));  
            
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
