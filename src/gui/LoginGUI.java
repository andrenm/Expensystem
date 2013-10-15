
package gui;

//vendor's packages
import controller.CtrlLogin;
import domain.Usuario;
        
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author benjamin.psjunior
 */
public class LoginGUI extends JFrame {    

    private CtrlLogin loginController;
    
    /**
     * Creates new form JFramePrincipal
     */
    
    public LoginGUI()
    {

    }
    
    public LoginGUI(CtrlLogin control) {
        
        initComponents();
        this.loginController = control;
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUser = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnNovoRegistro = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblPasswordName = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtUser.setName("txtUser"); // NOI18N
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.setName("btnLogin"); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnNovoRegistro.setText("Registrar-se");
        btnNovoRegistro.setName("btnRegistrar"); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(102, 102, 255));
        lblTitulo.setText("Expensys");

        lblUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(51, 51, 51));
        lblUserName.setText("Usuário:");

        lblPasswordName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPasswordName.setForeground(new java.awt.Color(51, 51, 51));
        lblPasswordName.setText("Senha:");

        txtPassword.setName("txtPassword"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUserName)
                            .addComponent(lblPasswordName))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNovoRegistro))
                            .addComponent(txtUser)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(lblTitulo)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPasswordName)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(txtPassword))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if(txtUser.getText().isEmpty() || txtPassword.getPassword().length == 0)
        {
            JOptionPane.showMessageDialog(null,"Favor preencher os campos Usuário e Senha");
        }
        else
        {
           CtrlLogin login = new CtrlLogin();
           try
           {
                String result = login.ValidaLogin(new Usuario(txtUser.getText(),txtPassword.getPassword()));

                if(result.equals("INCORRETO"))
                {
                  this.dispose();
                  JOptionPane.showMessageDialog(null,"Os campos Usuário e/ou Senha estão incorretos");
                }
                else
                {
                      
                  this.dispose();
                  MainGUI main = new MainGUI();
                  main.setVisible(true);

                  //JOptionPane.showMessageDialog(null,"logado");
                }
           }
           catch(Exception ex)
           {
             JOptionPane.showMessageDialog(null,"O sistema encontrou um erro e não conseguiu logar, tente novamente.");
           }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnNovoRegistro;
    private javax.swing.JLabel lblPasswordName;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
