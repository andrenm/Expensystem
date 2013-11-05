/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package preloader;

import controller.CtrlLogin;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

/**
 *
 * @author senac2012
 */
public class Progress extends JFrame {

    JProgressBar current;
    JTextArea out;
    JButton find;
    Thread runner;
    int num = 0;

    public Progress() {
        super("Progress");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout());
        current = new JProgressBar(0, 2000);
        current.setValue(0);
        current.setStringPainted(true);
        pane.add(current);
        setContentPane(pane);
    }


    public void iterate() {
        while (num < 2000) {
            current.setValue(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            num += 500;
        }
        
        this.dispose();
        CtrlLogin c = new CtrlLogin();
    }
}
