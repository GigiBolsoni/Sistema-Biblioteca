package view;

import java.awt.event.WindowEvent;
import controller.LogTrack;
import model.Emprestimo;
import model.Multa;
import model.Usuario;

public class JFrameMultaCRUD extends javax.swing.JFrame {
    
    private Multa multa;
    private Usuario usuario;  
    private Emprestimo emprestimo;
    
    private boolean disconnectOnClose;

    public JFrameMultaCRUD( Multa multa, boolean disconnectOnClose ) throws Exception {
        initComponents();
        
        if( multa == null ) {
            this.multa  = new Multa();
        } else {
                        
            this.multa = multa;
            
            if( this.multa.getUsuario()!= null ) {         
                
                this.usuario = new Usuario();
                this.usuario.setCodigoUsuario(this.multa.getUsuario().getCodigoUsuario());
                this.usuario.load();
                
            }
            
            if( this.multa.getEmprestimo()!= null ) {         
                
                this.emprestimo = new Emprestimo();
                this.emprestimo.setCodigoEmprestimo(this.multa.getEmprestimo().getCodigoEmprestimo());
                this.emprestimo.load();
                
            }
            
            dataUp();
            jTextFieldCodigo.setEnabled(false);
            
        }
        
        this.disconnectOnClose = disconnectOnClose;
    }
    
     private void dataUp() {
   
        jTextFieldCodigo.setText( String.valueOf( multa.getCodigoMulta() ) );    
        jTextFieldValor.setText(String.valueOf(multa.getValor()));
        jTextFieldDataPagamento.setText( multa.getDataPagamento());
        jTextFieldStatus.setText( multa.getStatus());
        
        if( multa.getUsuario().getNomeCompleto()!= null ) {
            jTextFieldUsuario.setText( multa.getUsuario().getNomeCompleto());
        }
        
        if( multa.getEmprestimo().getDataEmprestimo()!= null ) {
            jTextFieldEmprestimo.setText( multa.getEmprestimo().getDataEmprestimo());
        }        
    }
    
     private void dataDown() throws Exception {
      
        multa.setCodigoMulta( Integer.parseInt( jTextFieldCodigo.getText() ) );
        multa.setValor(Float.parseFloat(jTextFieldValor.getText()) );
        multa.setDataPagamento(jTextFieldDataPagamento.getText() );     
        multa.setStatus(jTextFieldStatus.getText() );   
        multa.setUsuario(usuario);
        multa.setEmprestimo(emprestimo);
     }
     
    private void checkInput() throws Exception {
        
        if( jTextFieldCodigo.getText().isEmpty() ) {
            throw new Exception("Informe Código.");
        } else {
            if( !jTextFieldCodigo.getText().matches("\\d+") ) {
                throw new Exception("O campo Código deve ser um número.");
            }
        }
        
        if(  jTextFieldValor.getText().isEmpty() ) {
             throw new Exception("Informe Valor.");
        } else {
            if( !jTextFieldValor.getText().matches("\\d+(\\.\\d+)?")  ) {
                 throw new Exception("O valor deve estar no formato decimal.");
            }
        }
        
        if(  jTextFieldDataPagamento.getText().isEmpty() ) {
             throw new Exception("Informe Data Pagamento.");
        } else {
            if( !jTextFieldDataPagamento.getText().matches("\\d{4}-\\d{2}-\\d{2}")  ) {
                 throw new Exception("A Data de Pagamento deve estar no formato AAAA-MM-DD.");
            }
        }
        
        if( usuario == null ) {
            throw new Exception("Informe Usuário.");
        }
        
        if( emprestimo == null ) {
            throw new Exception("Informe Emprestimo.");
        }
        
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelStatus = new javax.swing.JLabel();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelValor = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jLabelDataPagamento = new javax.swing.JLabel();
        jTextFieldDataPagamento = new javax.swing.JTextField();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jButtonSelecionarUsuario = new javax.swing.JButton();
        jButtonApagarUsuario = new javax.swing.JButton();
        jLabelEmprestimo = new javax.swing.JLabel();
        jTextFieldEmprestimo = new javax.swing.JTextField();
        jButtonSelecionarEmprestimo = new javax.swing.JButton();
        jButtonApagarEmprestimo = new javax.swing.JButton();
        jTextFieldStatus = new javax.swing.JTextField();
        jLabelImagemFundoCRUD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Multa");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStatus.setText("Status:");
        getContentPane().add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, -1));

        jLabelCodigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCodigo.setText("Código:");
        getContentPane().add(jLabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 22, -1, -1));
        getContentPane().add(jTextFieldCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 19, 52, -1));

        jLabelValor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelValor.setForeground(new java.awt.Color(255, 255, 255));
        jLabelValor.setText("Valor:");
        getContentPane().add(jLabelValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));
        getContentPane().add(jTextFieldValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 120, -1));

        jLabelDataPagamento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelDataPagamento.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDataPagamento.setText("Data Pagamento:");
        getContentPane().add(jLabelDataPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, -1));
        getContentPane().add(jTextFieldDataPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 118, -1));

        jLabelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Usuário:");
        getContentPane().add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        jTextFieldUsuario.setEditable(false);
        getContentPane().add(jTextFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 170, -1));

        jButtonSelecionarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSelecionarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 30, 30));

        jButtonApagarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonApagarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 30, 30));

        jLabelEmprestimo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEmprestimo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmprestimo.setText("Empréstimo:");
        getContentPane().add(jLabelEmprestimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jTextFieldEmprestimo.setEditable(false);
        getContentPane().add(jTextFieldEmprestimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 170, -1));

        jButtonSelecionarEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarEmprestimoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSelecionarEmprestimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 30, 30));

        jButtonApagarEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarEmprestimoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonApagarEmprestimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 30, 30));
        getContentPane().add(jTextFieldStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 200, -1));

        jLabelImagemFundoCRUD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/fundo_livros.jpg"))); // NOI18N
        getContentPane().add(jLabelImagemFundoCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 160));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        System.out.println("Excluir");

        try {
            checkInput();
            dataDown();
            multa.delete();
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
            multa.save();
            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
        } catch(Exception ex) {            
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonSelecionarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarUsuarioActionPerformed
        // TODO add your handling code here:
        
        try {
            
            if( usuario == null ) {
                usuario = new Usuario();
            }
            
            JFrameConsultaUsuario jFrameConsulta;
            jFrameConsulta = new JFrameConsultaUsuario( true, false, usuario, true );
            
            jFrameConsulta.addWindowListener( new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if( usuario.getNomeCompleto()!= null ) {
                        jTextFieldUsuario.setText( usuario.getNomeCompleto());
                    }
                }
            } );
            
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ) {
            LogTrack.getInstance().addException( ex, true, this );
            usuario = null;
        }
    }//GEN-LAST:event_jButtonSelecionarUsuarioActionPerformed

    private void jButtonApagarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarUsuarioActionPerformed
        // TODO add your handling code here:
        usuario = null;
        jTextFieldUsuario.setText( null );
    }//GEN-LAST:event_jButtonApagarUsuarioActionPerformed

    private void jButtonSelecionarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarEmprestimoActionPerformed
        // TODO add your handling code here:
        try {
            
            if( emprestimo == null ) {
                emprestimo = new Emprestimo();
            }
            
            JFrameConsultaEmprestimo jFrameConsulta;
            jFrameConsulta = new JFrameConsultaEmprestimo( true, false, emprestimo, null, true );
            
            jFrameConsulta.addWindowListener( new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if( emprestimo.getDataEmprestimo()!= null ) {
                        jTextFieldEmprestimo.setText( emprestimo.getDataEmprestimo());
                    }
                }
            } );
            
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ) {
            LogTrack.getInstance().addException( ex, true, this );
            emprestimo = null;
        }
    }//GEN-LAST:event_jButtonSelecionarEmprestimoActionPerformed

    private void jButtonApagarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarEmprestimoActionPerformed
        // TODO add your handling code here:
        emprestimo = null;
        jTextFieldEmprestimo.setText( null );
    }//GEN-LAST:event_jButtonApagarEmprestimoActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameMultaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMultaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMultaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMultaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                    new JFrameMultaCRUD( null, true ).setVisible(true);
                } catch (Exception ex) {
                    LogTrack.getInstance().addException( ex, true, null );
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApagarEmprestimo;
    private javax.swing.JButton jButtonApagarUsuario;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSelecionarEmprestimo;
    private javax.swing.JButton jButtonSelecionarUsuario;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDataPagamento;
    private javax.swing.JLabel jLabelEmprestimo;
    private javax.swing.JLabel jLabelImagemFundoCRUD;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDataPagamento;
    private javax.swing.JTextField jTextFieldEmprestimo;
    private javax.swing.JTextField jTextFieldStatus;
    private javax.swing.JTextField jTextFieldUsuario;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
