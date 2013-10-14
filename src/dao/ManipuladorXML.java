/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import com.thoughtworks.xstream.XStream;

import domain.*;

/**
 *
 * @author benjamin.psjunior
 */
public class ManipuladorXML {    
    
    XStream xstream = new XStream();
    
    public Usuario BuscaLogin()
    {
        Usuario user = (Usuario)xstream.fromXML("C:\\Users\\André\\Documents\\SENAC\\PI - Projeto integrador _ SEGUNDA\\Expensys\\src\\dao\\expensys.xml");
        return  user;
 
    }
}
