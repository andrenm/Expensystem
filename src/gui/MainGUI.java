/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.CtrlGastos;
import controller.CtrlLogin;
import domain.Lancamento;
import java.util.ArrayList;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author André
 */
public class MainGUI extends javax.swing.JFrame {

    private CtrlLogin login;
    private CtrlGastos gastos;
    private CtrlGastos  windowLancamento;
    
    /**
     * Creates new form MainGUI
     */
    public MainGUI(CtrlLogin c) {
        initComponents();
        login = c;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);      
        
        ListaUltimosLancamentos();
        ConsultaCreditoTotal();
        ConsultaDebitoTotal();
        CalculaTotal();
    }
    
    private double ValorCredito = 0;
    private double  ValorDebito = 0;

    private void ListaUltimosLancamentos()
    {
        gastos = new CtrlGastos();
        
        String[] columns = {"Descrição","Valor", "Categoria","Tipo",  "Data"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        
        ArrayList<Lancamento> List = gastos.listaLancamentos();

        for(Lancamento item : List)
        {
            Object[] obj  = new Object[5];

            obj[0] = item.getDescricao();
            obj[1] = "R$ " + item.getValor();
            obj[2] = item.getNome();     
            obj[3] = (item.getTipo() == 0 ? "Avulso" : "Fixo"); 
            obj[4] = item.getDataInclusao();
            
            model.addRow(obj);
        }
        
       jTable_ultimosLancamentos.setModel(model);
       
    }
    
    private void ConsultaCreditoTotal()
    {
        gastos = new CtrlGastos();

        ValorCredito =  gastos.listaCreditos();
        lblValorCredito.setText("R$ " + String.valueOf(ValorCredito));
    }

    private void ConsultaDebitoTotal()
    {
        gastos = new CtrlGastos();

        ValorDebito =  gastos.listaDebitos();
        lblValorDebito.setText("R$ " + String.valueOf(ValorDebito));
    }
 
    private void CalculaTotal()
    {
        double Total = Math.round(ValorCredito - ValorDebito);
        lblValorTotal.setText("R$ " + String.valueOf(Total));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblValorTotal = new javax.swing.JLabel();
        lblTituloTotal = new javax.swing.JLabel();
        lblValorDebito = new javax.swing.JLabel();
        lblTituloDebito = new javax.swing.JLabel();
        lblValorCredito = new javax.swing.JLabel();
        lblTituloCredito = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_ultimosLancamentos = new javax.swing.JTable();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(102, 102, 255));
        lblTitulo.setText("Expensys");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Últimos lançamentos");
        jLabel1.setName(""); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Balanço geral: - MÊS");

        lblValorTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblValorTotal.setName("lblValorTotal"); // NOI18N

        lblTituloTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTituloTotal.setText("Total");
        lblTituloTotal.setName("lblTituloTotal"); // NOI18N

        lblValorDebito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblValorDebito.setName("lblValorDebito"); // NOI18N

        lblTituloDebito.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTituloDebito.setText("Débitos");
        lblTituloDebito.setName("lblTituloDebito"); // NOI18N

        lblValorCredito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblValorCredito.setName("lblValorCredito"); // NOI18N

        lblTituloCredito.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTituloCredito.setText("Créditos");
        lblTituloCredito.setName("lblTituloCredito"); // NOI18N

        jTable_ultimosLancamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_ultimosLancamentos.setName("jTable_ultimosLancamentos"); // NOI18N
        jScrollPane2.setViewportView(jTable_ultimosLancamentos);

        jMenu4.setText("Principal");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Lançamentos");

        jMenuItem1.setText("Cadastrar novo lançamento");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuItem2.setText("Consultar lançamentos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuBar2.add(jMenu5);

        jMenu1.setText("Relatórios");
        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblTituloCredito)
                    .addComponent(lblTituloDebito)
                    .addComponent(lblTituloTotal)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblValorCredito, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(lblValorDebito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(lblTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblTituloDebito))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTituloCredito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValorCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(lblValorDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(lblTituloTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        NovoLancamentoGUI lancamento = new NovoLancamentoGUI();
        lancamento.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ConsultaLancamentoGUI consulta = new ConsultaLancamentoGUI();
        consulta.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable_ultimosLancamentos;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloCredito;
    private javax.swing.JLabel lblTituloDebito;
    private javax.swing.JLabel lblTituloTotal;
    private javax.swing.JLabel lblValorCredito;
    private javax.swing.JLabel lblValorDebito;
    private javax.swing.JLabel lblValorTotal;
    // End of variables declaration//GEN-END:variables
}
