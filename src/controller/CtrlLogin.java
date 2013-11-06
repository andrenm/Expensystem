package controller;

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
    
    private Usuario currentUser;
    
    public CtrlLogin() {
        
        /* init windows */
        windowLogin = new LoginGUI(this);
        windowMain = new MainGUI(this);
        windowNovoUsuario = new NovoUsuarioGUI(this);
        
        windowLogin.setVisible(true);
    }
    
    public void showTelaMain() {        
        windowLogin.dispose();
        windowNovoUsuario.dispose();        
        windowMain.setVisible(true);
    }
    
    public void showTelaNovoUsuario() {        
        //windowLogin.dispose();
        windowNovoUsuario.setVisible(true);        
    }
    
    public boolean validarLogin(Usuario user) {   
        try {            
            ManipuladorXML xml = new ManipuladorXML();
            currentUser = xml.searchLogin(user.getEmail(), new String(user.getSenha()));  
            return this.hasCurrentUser();            
        } catch(Exception ex) {
            throw ex;
        }
    }
    
    public boolean criarUsuario(Usuario user) {   
        try {            
            ManipuladorXML xml = new ManipuladorXML();
            currentUser = xml.createUserXml(user.getNome(), user.getEmail(), user.getSenha());             
            return this.hasCurrentUser();          
        } catch(Exception ex) {
            throw ex;
        }     
    }
    
    public Usuario getCurrentUser() {
        return this.currentUser;
    }
    
    private boolean hasCurrentUser() {
        if (this.currentUser != null) {
            //System.out.println("ID:  " + this.currentUser.getId());
            return true;
        } else {
            return false;
        }
    }
}
