
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
    
    public LoginGUI() {}
    
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
        jLabel1 = new javax.swing.JLabel();

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
        btnNovoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoRegistroActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 51, 0));
        lblTitulo.setText("Expensys");

        lblUserName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(51, 51, 51));
        lblUserName.setText("Usuário:");

        lblPasswordName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPasswordName.setForeground(new java.awt.Color(51, 51, 51));
        lblPasswordName.setText("Senha:");

        txtPassword.setName("txtPassword"); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/silver_lock_icon_3.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitulo)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUserName)
                    .addComponent(lblPasswordName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNovoRegistro))
                    .addComponent(txtUser)
                    .addComponent(txtPassword))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUserName)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPasswordName)
                            .addComponent(txtPassword))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLogin)
                            .addComponent(btnNovoRegistro))
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(42, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if(txtUser.getText().isEmpty() || txtPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Favor preencher os campos Usuário e Senha");
        } else {
           try {
                boolean result = loginController.validarLogin(new Usuario(txtUser.getText(),txtPassword.getPassword()));

                if(!result) {
                    //this.dispose();
                    JOptionPane.showMessageDialog(null, "Os campos Usuário e/ou Senha estão incorretos");
                } else {
                    JOptionPane.showMessageDialog(null, "Olá " + loginController.getCurrentUser().getNome() + ", seja bem-vindo!");                          
                    loginController.showTelaMain();
                }
           } catch(Exception ex) {               
             JOptionPane.showMessageDialog(null, "O sistema encontrou um erro e não conseguiu logar, tente novamente.");
           }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnNovoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoRegistroActionPerformed
        loginController.showTelaNovoUsuario();
    }//GEN-LAST:event_btnNovoRegistroActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnNovoRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblPasswordName;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
