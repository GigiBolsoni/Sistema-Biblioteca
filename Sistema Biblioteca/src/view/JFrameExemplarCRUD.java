package view;

import java.awt.event.WindowEvent;
import model.Exemplar;
import controller.LogTrack;
import model.Livro;

public class JFrameExemplarCRUD extends javax.swing.JFrame {
    
    private Exemplar exemplar;
    private Livro livro;
    
    private boolean disconnectOnClose;

    public JFrameExemplarCRUD( Exemplar exemplar, boolean disconnectOnClose ) throws Exception {
        initComponents();
        
        if( exemplar == null ) {
            this.exemplar  = new Exemplar();
        } else {
                        
            this.exemplar = exemplar;
            
            if( this.exemplar.getLivro() != null ) {         
                
                this.livro = new Livro();
                this.livro.setCodigoLivro(this.exemplar.getLivro().getCodigoLivro());
                this.livro.load();
                
            }
            
            dataUp();
            jTextFieldCodigo.setEnabled(false);
            
        }
        
        this.disconnectOnClose = disconnectOnClose;
    }
    
     private void dataUp() {
   
        jTextFieldCodigo.setText( String.valueOf( exemplar.getCodigoExemplar() ) );
        jTextFieldStatus.setText( exemplar.getStatus());        
        jTextFieldDataAquisicao.setText( exemplar.getDataAquisicao() );
        
        if( exemplar.getLivro().getTitulo()!= null ) {
            jTextFieldLivro.setText( exemplar.getLivro().getTitulo());
        }
        
    }
    
     private void dataDown() throws Exception {
      
        exemplar.setCodigoExemplar( Integer.parseInt( jTextFieldCodigo.getText() ) );
        exemplar.setStatus(jTextFieldStatus.getText() );        
        exemplar.setDataAquisicao(jTextFieldDataAquisicao.getText() );        
        exemplar.setLivro( livro );
     }
     
    private void checkInput() throws Exception {
        
        if( jTextFieldCodigo.getText().isEmpty() ) {
            throw new Exception("Informe Código.");
        } else {
            if( !jTextFieldCodigo.getText().matches("\\d+") ) {
                throw new Exception("O campo Código deve ser um número.");
            }
        }
        
        if( jTextFieldStatus.getText().isEmpty() ) {
            throw new Exception("Informe Status.");
        }
        
        if(  jTextFieldDataAquisicao.getText().isEmpty() ) {
             throw new Exception("Informe Data de Aquisição.");
        } else {
            if( !jTextFieldDataAquisicao.getText().matches("\\d{4}-\\d{2}-\\d{2}")  ) {
                 throw new Exception("A Data de Aquisição deve estar no formato AAAA-MM-DD.");
            }
        }
        
        if( livro == null ) {
            throw new Exception("Informe Livro.");
        }
        
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDataAquisicao = new javax.swing.JLabel();
        jTextFieldDataAquisicao = new javax.swing.JTextField();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelStatus = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jLabelLivro = new javax.swing.JLabel();
        jTextFieldLivro = new javax.swing.JTextField();
        jButtonSelecionarLivro = new javax.swing.JButton();
        jButtonApagarLivro = new javax.swing.JButton();
        jLabelImagemFundoCRUD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Exemplar");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDataAquisicao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelDataAquisicao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDataAquisicao.setText("Data Aquisição:");
        getContentPane().add(jLabelDataAquisicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));
        getContentPane().add(jTextFieldDataAquisicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 118, -1));

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, -1, -1));

        jLabelCodigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCodigo.setText("Código:");
        getContentPane().add(jLabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 22, -1, -1));
        getContentPane().add(jTextFieldCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 19, 52, -1));

        jLabelStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStatus.setText("Status:");
        getContentPane().add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));
        getContentPane().add(jTextFieldStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 170, -1));

        jLabelLivro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelLivro.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLivro.setText("Livro:");
        getContentPane().add(jLabelLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jTextFieldLivro.setEditable(false);
        getContentPane().add(jTextFieldLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 170, -1));

        jButtonSelecionarLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarLivroActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSelecionarLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 30, 30));

        jButtonApagarLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarLivroActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonApagarLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 30, 30));

        jLabelImagemFundoCRUD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/fundo_CRUDs.jpg"))); // NOI18N
        getContentPane().add(jLabelImagemFundoCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 120));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        System.out.println("Excluir");

        try {
            checkInput();
            dataDown();
            exemplar.delete();
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
            exemplar.save();
            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
        } catch(Exception ex) {            
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonSelecionarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarLivroActionPerformed
        // TODO add your handling code here:
        
        try {
            
            if( livro == null ) {
                livro = new Livro();
            }
            
            JFrameConsultaLivro jFrameConsulta;
            jFrameConsulta = new JFrameConsultaLivro( true, false, livro, false );
            
            jFrameConsulta.addWindowListener( new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if( livro.getTitulo()!= null ) {
                        jTextFieldLivro.setText( livro.getTitulo());
                    }
                }
            } );
            
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ) {
            LogTrack.getInstance().addException( ex, true, this );
            livro = null;
        }
    }//GEN-LAST:event_jButtonSelecionarLivroActionPerformed

    private void jButtonApagarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarLivroActionPerformed
        // TODO add your handling code here:
        livro = null;
        jTextFieldLivro.setText( null );
    }//GEN-LAST:event_jButtonApagarLivroActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameExemplarCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameExemplarCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameExemplarCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameExemplarCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                    new JFrameExemplarCRUD( null, true ).setVisible(true);
                } catch (Exception ex) {
                    LogTrack.getInstance().addException( ex, true, null );
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApagarLivro;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSelecionarLivro;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDataAquisicao;
    private javax.swing.JLabel jLabelImagemFundoCRUD;
    private javax.swing.JLabel jLabelLivro;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDataAquisicao;
    private javax.swing.JTextField jTextFieldLivro;
    private javax.swing.JTextField jTextFieldStatus;
    // End of variables declaration//GEN-END:variables
}
