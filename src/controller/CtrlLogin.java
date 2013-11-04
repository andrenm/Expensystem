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
    private MainGUI windowMain;
    private NovoUsuarioGUI windowNovoUsuario;
    //private Modelo modelo;
    private Usuario login;
    
    public CtrlLogin() {
        
        windowLogin = new LoginGUI(this);
        windowLogin.setVisible(true);
    }
    
    public void TelaMain(){
        //windowLogin.setVisible(false);
        windowLogin.dispose();
        windowNovoUsuario.dispose();
        //windowLogin = null;
        windowMain = new MainGUI(this);
        windowMain.setVisible(true);
    }
    
    public void telaNovoUsuario() {
        //windowLogin.setVisible(false);
        windowLogin.dispose();
        //windowLogin = null;
        windowNovoUsuario = new NovoUsuarioGUI(this);
        windowNovoUsuario.setVisible(true);        
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
    
    public boolean criarUsuario(Usuario user) {   
        try {
            
            ManipuladorXML xml = new ManipuladorXML();
            boolean create = xml.createUserXml(user.getEmail(), user.getSenha());  
            
            return create;
            
        } catch(Exception ex) {
            throw ex;
        }     
    }
}
