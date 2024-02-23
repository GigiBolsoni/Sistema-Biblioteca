package view;

import java.awt.event.WindowEvent;
import controller.LogTrack;
import model.Autor;

public class JFrameAutorCRUD extends javax.swing.JFrame {
    
    private Autor autor;
    
    private boolean disconnectOnClose;

    public JFrameAutorCRUD( Autor autor, boolean disconnectOnClose ) throws Exception {
        initComponents();
        
        if( autor == null ) {
            this.autor  = new Autor();
        } else {
                        
            this.autor = autor;

            dataUp();
            jTextFieldCodigo.setEnabled(false);
            
        }
        
        this.disconnectOnClose = disconnectOnClose;
    }
    
     private void dataUp() {
   
        jTextFieldCodigo.setText( String.valueOf( autor.getCodigoAutor()) );
        jTextFieldNome.setText( autor.getNomeCompleto());               
        jTextFieldDataNascimento.setText(autor.getDataNascimento());
        jTextAreaBiografia.setText(autor.getBiografia());
        jTextFieldNacionalidade.setText(autor.getNacionalidade());
    }
    
     private void dataDown() throws Exception {
      
        autor.setCodigoAutor(Integer.parseInt( jTextFieldCodigo.getText() ) );
        autor.setNomeCompleto(jTextFieldNome.getText() );
        autor.setDataNascimento(jTextFieldDataNascimento.getText());
        autor.setBiografia(jTextAreaBiografia.getText());
        autor.setNacionalidade(jTextFieldNacionalidade.getText());
     }
     
    private void checkInput() throws Exception {
        
        if( jTextFieldCodigo.getText().isEmpty() ) {
            throw new Exception("Informe Código");
        } else {
            if( !jTextFieldCodigo.getText().matches("\\d+") ) {
                throw new Exception("O campo Código deve ser um número.");
            }
        }
        
        if( jTextFieldNome.getText().isEmpty() ) {
            throw new Exception("Informe Nome.");
        }
        
        if(  jTextFieldDataNascimento.getText().isEmpty() ) {
             throw new Exception("Informe Data de Nascimento.");
        } else {
            if( !jTextFieldDataNascimento.getText().matches("\\d{4}-\\d{2}-\\d{2}")  ) {
                 throw new Exception("A Data de Nascimento deve estar no formato AAAA-MM-DD.");
            }
        }
            
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelDataNascimento = new javax.swing.JLabel();
        jTextFieldDataNascimento = new javax.swing.JTextField();
        jLabelNacionalidade = new javax.swing.JLabel();
        jTextFieldNacionalidade = new javax.swing.JTextField();
        jLabelBiografia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaBiografia = new javax.swing.JTextArea();
        jLabelImagemFundoCRUD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Autor");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));

        jLabelCodigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCodigo.setText("Código:");
        getContentPane().add(jLabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 22, -1, -1));
        getContentPane().add(jTextFieldCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 19, 52, -1));

        jLabelNome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNome.setText("Nome:");
        getContentPane().add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));
        getContentPane().add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 260, -1));

        jLabelDataNascimento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelDataNascimento.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDataNascimento.setText("Data Nascimento:");
        getContentPane().add(jLabelDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        getContentPane().add(jTextFieldDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 90, -1));

        jLabelNacionalidade.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNacionalidade.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNacionalidade.setText("Nacionalidade:");
        getContentPane().add(jLabelNacionalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));
        getContentPane().add(jTextFieldNacionalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 140, -1));

        jLabelBiografia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelBiografia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBiografia.setText("Biografia:");
        getContentPane().add(jLabelBiografia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jTextAreaBiografia.setColumns(20);
        jTextAreaBiografia.setRows(5);
        jScrollPane1.setViewportView(jTextAreaBiografia);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 430, 100));

        jLabelImagemFundoCRUD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/fundo_CRUDs.jpg"))); // NOI18N
        getContentPane().add(jLabelImagemFundoCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 290));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        System.out.println("Excluir");

        try {
            checkInput();
            dataDown();
            autor.delete();
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
            autor.save();
            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
        } catch(Exception ex) {            
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameAutorCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAutorCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAutorCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAutorCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                    new JFrameAutorCRUD( null, true ).setVisible(true);
                } catch (Exception ex) {
                    LogTrack.getInstance().addException( ex, true, null );
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabelBiografia;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDataNascimento;
    private javax.swing.JLabel jLabelImagemFundoCRUD;
    private javax.swing.JLabel jLabelNacionalidade;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaBiografia;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDataNascimento;
    private javax.swing.JTextField jTextFieldNacionalidade;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
