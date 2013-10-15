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
    
    public CtrlLogin() {
        
        windowLogin = new LoginGUI(this);
        windowLogin.setVisible(true);
        
        //modelo = new Modelo();
    }
    
    public String ValidaLogin(Usuario user)
    {   
        try
        {
            //Teste pra ver se acessa o xml
           // ManipuladorXML xml = new ManipuladorXML();
           // user = xml.BuscaLogin();
            
            //valida usuario e senha por hardcoded
            if(user.getNome().equals("andre") && new String(user.getSenha()).equals("123"))
            {
                return "LOGADO";
            }
            else
            {
                return "INCORRETO";
            }
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }
    
    /*public void adicionaCidade(String estado, String cidade) {
        
        modelo.addCidade(estado, new Cidade(cidade));  
         janela.updateCidades(estado);
        janela2.updateCidades(estado);
        janela3.updateCidades(estado);
    }*/
}
