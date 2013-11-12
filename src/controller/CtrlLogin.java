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
    
    public CtrlLogin() {        
        /* init windows */
        windowLogin = new LoginGUI(this);
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
            CtrlSession.setCurrentUser(xml.searchLogin(user.getEmail(), new String(user.getSenha())));  
            return this.hasUserLogged();            
        } catch(Exception ex) {
            throw ex;
        }
    }
    
    public boolean criarUsuario(Usuario user) {   
        try {            
            ManipuladorXML xml = new ManipuladorXML();
            CtrlSession.setCurrentUser(xml.createUserXml(user.getNome(), user.getEmail(), user.getSenha()));             
            return this.hasUserLogged();          
        } catch(Exception ex) {
            throw ex;
        }     
    }
    
    private boolean hasUserLogged() {
        if (CtrlSession.getCurrentUser() != null) {
            //System.out.println("ID:  " + this.currentUser.getId());            
            windowMain = new MainGUI(this);
            return true;
        } else {
            return false;
        }
    }
}
