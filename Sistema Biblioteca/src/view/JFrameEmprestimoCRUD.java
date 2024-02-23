package view;

import java.awt.event.WindowEvent;
import controller.LogTrack;
import model.Exemplar;
import model.Emprestimo;
import model.Usuario;

public class JFrameEmprestimoCRUD extends javax.swing.JFrame {
    
    private Emprestimo emprestimo;
    private Usuario usuario;  
    private Exemplar exemplar;
    
    private boolean disconnectOnClose;

    public JFrameEmprestimoCRUD( Emprestimo emprestimo, boolean disconnectOnClose ) throws Exception {
        initComponents();
        
        if( emprestimo == null ) {
            this.emprestimo  = new Emprestimo();
        } else {
                        
            this.emprestimo = emprestimo;
            
            if( this.emprestimo.getUsuario()!= null ) {         
                
                this.usuario = new Usuario();
                this.usuario.setCodigoUsuario(this.emprestimo.getUsuario().getCodigoUsuario());
                this.usuario.load();
                
            }
            
            if( this.emprestimo.getExemplar()!= null ) {         
                
                this.exemplar = new Exemplar();
                this.exemplar.setCodigoExemplar(this.emprestimo.getExemplar().getCodigoExemplar());
                this.exemplar.load();
                
            }
            
            dataUp();
            jTextFieldCodigo.setEnabled(false);
            
        }
        
        this.disconnectOnClose = disconnectOnClose;
    }
    
     private void dataUp() {
   
        jTextFieldCodigo.setText( String.valueOf( emprestimo.getCodigoEmprestimo() ) );
        
        jTextFieldDataEmprestimo.setText( emprestimo.getDataEmprestimo());      
        jTextFieldDataDevolucaoPrevista.setText( emprestimo.getDataDevolucaoPrevista());
        jTextFieldDataDevolucaoReal.setText( emprestimo.getDataDevolucaoReal());
        
        if( emprestimo.getUsuario().getNomeCompleto()!= null ) {
            jTextFieldUsuario.setText( emprestimo.getUsuario().getNomeCompleto());
        }
        
        if( emprestimo.getExemplar().getLivro().getTitulo()!= null ) {
            jTextFieldExemplar.setText( emprestimo.getExemplar().getLivro().getTitulo());
        }        
    }
    
     private void dataDown() throws Exception {
      
        emprestimo.setCodigoEmprestimo( Integer.parseInt( jTextFieldCodigo.getText() ) );
        emprestimo.setDataEmprestimo(jTextFieldDataEmprestimo.getText() );
        emprestimo.setDataDevolucaoPrevista(jTextFieldDataDevolucaoPrevista.getText() );     
        emprestimo.setDataDevolucaoReal(jTextFieldDataDevolucaoReal.getText() );  
        emprestimo.setUsuario(usuario);
        emprestimo.setExemplar(exemplar);
     }
     
    private void checkInput() throws Exception {
        
        if( jTextFieldCodigo.getText().isEmpty() ) {
            throw new Exception("Informe Código.");
        } else {
            if( !jTextFieldCodigo.getText().matches("\\d+") ) {
                throw new Exception("O campo Código deve ser um número.");
            }
        }
        
        if(  jTextFieldDataEmprestimo.getText().isEmpty() ) {
             throw new Exception("Informe Data Empréstimo.");
        } else {
            if( !jTextFieldDataEmprestimo.getText().matches("\\d{4}-\\d{2}-\\d{2}")  ) {
                 throw new Exception("A Data de Empréstimo deve estar no formato AAAA-MM-DD.");
            }
        }
        
        if(  jTextFieldDataDevolucaoPrevista.getText().isEmpty() ) {
             throw new Exception("Informe Data Devolução Prevista.");
        } else {
            if( !jTextFieldDataDevolucaoPrevista.getText().matches("\\d{4}-\\d{2}-\\d{2}")  ) {
                 throw new Exception("A Data de Devolução Prevista deve estar no formato AAAA-MM-DD.");
            }
        }
        
        if(  jTextFieldDataDevolucaoReal.getText().isEmpty() ) {
             throw new Exception("Informe Data Devolução Real.");
        } else {
            if( !jTextFieldDataDevolucaoReal.getText().matches("\\d{4}-\\d{2}-\\d{2}")  ) {
                 throw new Exception("A Data de Devolução Real deve estar no formato AAAA-MM-DD.");
            }
        }
        
        if( usuario == null ) {
            throw new Exception("Informe Usuário.");
        }
        
        if( exemplar == null ) {
            throw new Exception("Informe Exemplar.");
        }
        
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDataDevolucaoReal = new javax.swing.JLabel();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelDataEmprestimo = new javax.swing.JLabel();
        jTextFieldDataEmprestimo = new javax.swing.JTextField();
        jLabelDataDevolucaoPrevista = new javax.swing.JLabel();
        jTextFieldDataDevolucaoPrevista = new javax.swing.JTextField();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jButtonSelecionarUsuario = new javax.swing.JButton();
        jButtonApagarUsuario = new javax.swing.JButton();
        jLabelExemplar = new javax.swing.JLabel();
        jTextFieldExemplar = new javax.swing.JTextField();
        jButtonSelecionarExemplar = new javax.swing.JButton();
        jButtonApagarExemplar = new javax.swing.JButton();
        jTextFieldDataDevolucaoReal = new javax.swing.JTextField();
        jLabelImagemFundoCRUD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Empréstimo");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDataDevolucaoReal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelDataDevolucaoReal.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDataDevolucaoReal.setText("Data Devolução Real:");
        getContentPane().add(jLabelDataDevolucaoReal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

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

        jLabelDataEmprestimo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelDataEmprestimo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDataEmprestimo.setText("Data Empréstimo:");
        getContentPane().add(jLabelDataEmprestimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));
        getContentPane().add(jTextFieldDataEmprestimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 120, -1));

        jLabelDataDevolucaoPrevista.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelDataDevolucaoPrevista.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDataDevolucaoPrevista.setText("Data Devolucao Prevista:");
        getContentPane().add(jLabelDataDevolucaoPrevista, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, -1));
        getContentPane().add(jTextFieldDataDevolucaoPrevista, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 118, -1));

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

        jLabelExemplar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelExemplar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelExemplar.setText("Exemplar:");
        getContentPane().add(jLabelExemplar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jTextFieldExemplar.setEditable(false);
        getContentPane().add(jTextFieldExemplar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 170, -1));

        jButtonSelecionarExemplar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarExemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarExemplarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSelecionarExemplar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 30, 30));

        jButtonApagarExemplar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarExemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarExemplarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonApagarExemplar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 30, 30));
        getContentPane().add(jTextFieldDataDevolucaoReal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 118, -1));

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
            emprestimo.delete();
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
            emprestimo.save();
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
            jFrameConsulta = new JFrameConsultaUsuario( true, false, usuario, true);
            
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

    private void jButtonSelecionarExemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarExemplarActionPerformed
        // TODO add your handling code here:
        try {
            
            if( exemplar == null ) {
                exemplar = new Exemplar();
            }
            
            JFrameConsultaExemplar jFrameConsulta;
            jFrameConsulta = new JFrameConsultaExemplar( true, false, exemplar, null, true);
            
            jFrameConsulta.addWindowListener( new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if( exemplar.getLivro().getTitulo()!= null ) {
                        jTextFieldExemplar.setText( exemplar.getLivro().getTitulo());
                    }
                }
            } );
            
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ) {
            LogTrack.getInstance().addException( ex, true, this );
            exemplar = null;
        }
    }//GEN-LAST:event_jButtonSelecionarExemplarActionPerformed

    private void jButtonApagarExemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarExemplarActionPerformed
        // TODO add your handling code here:
        exemplar = null;
        jTextFieldExemplar.setText( null );
    }//GEN-LAST:event_jButtonApagarExemplarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameEmprestimoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameEmprestimoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameEmprestimoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameEmprestimoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                    new JFrameEmprestimoCRUD( null, true ).setVisible(true);
                } catch (Exception ex) {
                    LogTrack.getInstance().addException( ex, true, null );
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApagarExemplar;
    private javax.swing.JButton jButtonApagarUsuario;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSelecionarExemplar;
    private javax.swing.JButton jButtonSelecionarUsuario;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDataDevolucaoPrevista;
    private javax.swing.JLabel jLabelDataDevolucaoReal;
    private javax.swing.JLabel jLabelDataEmprestimo;
    private javax.swing.JLabel jLabelExemplar;
    private javax.swing.JLabel jLabelImagemFundoCRUD;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDataDevolucaoPrevista;
    private javax.swing.JTextField jTextFieldDataDevolucaoReal;
    private javax.swing.JTextField jTextFieldDataEmprestimo;
    private javax.swing.JTextField jTextFieldExemplar;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
