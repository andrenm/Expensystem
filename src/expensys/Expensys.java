/*
 * Pacote sem utilizacao até o momento;
 * a nao ser a inicializacao (sem nexo);
 
 */

package expensys;

import controller.CtrlLogin;
import preloader.Progress;

/**
 *
 * @author benjamin.psjunior
 */
public class Expensys {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Progress frame = new Progress();
        frame.pack();
        frame.setVisible(true);
        frame.iterate();
        
        //CtrlLogin c = new CtrlLogin();
    }
}
