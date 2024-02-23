package view;

import java.awt.event.WindowEvent;
import controller.LogTrack;
import model.TipoUsuario;

public class JFrameTipoUsuarioCRUD extends javax.swing.JFrame {
    
    private TipoUsuario tipoUsuario;
    private boolean disconnectOnClose;

    public JFrameTipoUsuarioCRUD( TipoUsuario tipoUsuario, boolean disconnectOnClose ) {
        initComponents();
                
        if( tipoUsuario == null ) {
            this.tipoUsuario  = new TipoUsuario();
        } else {
            this.tipoUsuario = tipoUsuario;
            dataUp();
            jTextFieldCodigo.setEnabled(false);
        }
        
        this.disconnectOnClose = disconnectOnClose;        
    }
    
     private void dataUp() {
   
        jTextFieldCodigo.setText( Integer.toString( tipoUsuario.getCodigoTipo() ) );
        jTextFieldNome.setText( tipoUsuario.getNome() );
        
        if( ( tipoUsuario.getModuloAdministrativo() != null ) &&
            ( tipoUsuario.getModuloAdministrativo().equals("S") ) ) {
                jCheckBoxAdministrativo.setSelected( true );
        } else {
            jCheckBoxAdministrativo.setSelected( false );
        }
        
        if( ( tipoUsuario.getModuloAtendimento() != null ) &&
            ( tipoUsuario.getModuloAtendimento().equals("S") ) ) {
                jCheckBoxAtendimento.setSelected( true );
        } else {
            jCheckBoxAtendimento.setSelected( false );
        }              
    }
    
     private void dataDown() throws Exception {
      
        tipoUsuario.setCodigoTipo( Integer.parseInt( jTextFieldCodigo.getText() ) );
        tipoUsuario.setNome( jTextFieldNome.getText() );
        
        if( jCheckBoxAdministrativo.isSelected() ) {
            tipoUsuario.setModuloAdministrativo("S");
        } else {
            tipoUsuario.setModuloAdministrativo("N");
        }
        
        if( jCheckBoxAtendimento.isSelected() ) {
            tipoUsuario.setModuloAtendimento("S");
        } else {
            tipoUsuario.setModuloAtendimento("N");
        }
     }
     
    private void checkInput() throws Exception {
        
        if( jTextFieldCodigo.getText().isEmpty() ) {
            throw new Exception("Informe Código.");
        } else {
            if( !jTextFieldCodigo.getText().matches("\\d+") ) {
                throw new Exception("O campo Código deve ser um número.");
            }
        }
        
        if( jTextFieldNome.getText().isEmpty() ) {
            throw new Exception("Informe Nome.");
        }
            
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jLabelModulos = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelCodigo = new javax.swing.JLabel();
        jPanelCadastroModulo = new javax.swing.JPanel();
        jCheckBoxAdministrativo = new javax.swing.JCheckBox();
        jCheckBoxAtendimento = new javax.swing.JCheckBox();
        jLabelImagemFundoCRUD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Tipo Usuário");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        jLabelModulos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelModulos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelModulos.setText("Módulos:");
        getContentPane().add(jLabelModulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        getContentPane().add(jTextFieldCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 19, 52, -1));

        jLabelNome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNome.setText("Nome:");
        getContentPane().add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));
        getContentPane().add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 280, -1));

        jLabelCodigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCodigo.setText("Código:");
        getContentPane().add(jLabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 22, -1, -1));

        jCheckBoxAdministrativo.setText("Administrativo");
        jCheckBoxAdministrativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAdministrativoActionPerformed(evt);
            }
        });

        jCheckBoxAtendimento.setText("Atendimento");

        javax.swing.GroupLayout jPanelCadastroModuloLayout = new javax.swing.GroupLayout(jPanelCadastroModulo);
        jPanelCadastroModulo.setLayout(jPanelCadastroModuloLayout);
        jPanelCadastroModuloLayout.setHorizontalGroup(
            jPanelCadastroModuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroModuloLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jCheckBoxAdministrativo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(jCheckBoxAtendimento)
                .addGap(50, 50, 50))
        );
        jPanelCadastroModuloLayout.setVerticalGroup(
            jPanelCadastroModuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroModuloLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelCadastroModuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxAdministrativo)
                    .addComponent(jCheckBoxAtendimento))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelCadastroModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 370, 60));

        jLabelImagemFundoCRUD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/fundo_CRUDs.jpg"))); // NOI18N
        getContentPane().add(jLabelImagemFundoCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 230));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        System.out.println("Excluir");

        try {
            checkInput();
            dataDown();
            tipoUsuario.delete();
            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
        } catch(Exception ex) {
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        System.out.println("Salvar");

        try {
            checkInput();
            dataDown();
            tipoUsuario.save();
            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
        } catch(Exception ex) {            
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jCheckBoxAdministrativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAdministrativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxAdministrativoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameTipoUsuarioCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameTipoUsuarioCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameTipoUsuarioCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameTipoUsuarioCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFrameTipoUsuarioCRUD( null, true ).setVisible(true);
                } catch (Exception ex) {
                    LogTrack.getInstance().addException( ex, true, null );
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JCheckBox jCheckBoxAdministrativo;
    private javax.swing.JCheckBox jCheckBoxAtendimento;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelImagemFundoCRUD;
    private javax.swing.JLabel jLabelModulos;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JPanel jPanelCadastroModulo;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
