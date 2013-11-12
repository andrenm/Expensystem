package controller;

import domain.Usuario;

/**
 *
 * @author benjamin.psjunior
 */
public class CtrlSession {
    
    public static Usuario currentUser;    

    public static void setCurrentUser(Usuario currentUser) {
        CtrlSession.currentUser = currentUser;
    }    
    
    public static Usuario getCurrentUser() {
        return CtrlSession.currentUser;
    }  
}
