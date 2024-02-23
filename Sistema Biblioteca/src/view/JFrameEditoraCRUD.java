package view;

import java.awt.event.WindowEvent;
import controller.LogTrack;
import model.Editora;

public class JFrameEditoraCRUD extends javax.swing.JFrame {
    
    private Editora editora;
    
    private boolean disconnectOnClose;

    public JFrameEditoraCRUD( Editora editora, boolean disconnectOnClose ) throws Exception {
        initComponents();
        
        if( editora == null ) {
            this.editora  = new Editora();
        } else {
                        
            this.editora = editora;

            dataUp();
            jTextFieldCodigo.setEnabled(false);
            
        }
        
        this.disconnectOnClose = disconnectOnClose;
    }
    
     private void dataUp() {
   
        jTextFieldCodigo.setText( String.valueOf( editora.getCodigoEditora()) );
        jTextFieldNome.setText( editora.getNome());        
        jTextFieldCNPJ.setText( editora.getCnpj()); 
        jTextFieldEmail.setText( editora.getEmail() );
        jTextFieldEndereco.setText( editora.getEndereco() );
        jTextFieldNumero.setText( editora.getNumero() );
        jTextFieldComplemento.setText( editora.getComplemento() );
        jTextFieldBairro.setText( editora.getBairro() );
        jTextFieldCidade.setText( editora.getCidade() );
        jTextFieldEstado.setText( editora.getEstado() );
        jTextFieldTelefone.setText(editora.getTelefone());
        jTextFieldWebSite.setText( editora.getWebsite());
        jTextFieldFundacao.setText( editora.getFundacao());        
    }
    
     private void dataDown() throws Exception {
      
        editora.setCodigoEditora(Integer.parseInt( jTextFieldCodigo.getText() ) );
        editora.setNome( jTextFieldNome.getText() );        
        editora.setCnpj(jTextFieldCNPJ.getText() );
        editora.setEmail( jTextFieldEmail.getText() );
        editora.setEndereco( jTextFieldEndereco.getText() );
        editora.setNumero( jTextFieldNumero.getText() );
        editora.setComplemento( jTextFieldComplemento.getText() );
        editora.setBairro( jTextFieldBairro.getText() );
        editora.setCidade( jTextFieldCidade.getText() );
        editora.setEstado( jTextFieldEstado.getText() );
        editora.setTelefone(jTextFieldTelefone.getText() );
        editora.setWebsite(jTextFieldWebSite.getText() );
        editora.setFundacao(jTextFieldFundacao.getText() );
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
        
        if (jTextFieldCNPJ.getText().isEmpty()) {
            throw new Exception("Informe o CNPJ.");
        } else {
            if (!jTextFieldCNPJ.getText().matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")) {
                throw new Exception("O CNPJ deve estar no formato XX.XXX.XXX/XXXX-XX.");
            }
        }
        
        if (jTextFieldTelefone.getText().isEmpty()) {
            throw new Exception("Informe o Número de Telefone.");
        } else {
            if (!jTextFieldTelefone.getText().matches("\\(\\d{2}\\)\\s?\\d{4,5}-\\d{4}")) {
                throw new Exception("O Número de Telefone deve estar no formato (XX)XXXXX-XXXX ou (XX)XXXX-XXXX.");
            }
        }
  
        if (jTextFieldFundacao.getText().isEmpty()) {
            throw new Exception("Informe Fundação.");
        } else {
            if (!jTextFieldFundacao.getText().matches("\\d{4}")) {
                throw new Exception("A Fundação deve estar no formato AAAA (ano).");
            }
        }
        
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNumero = new javax.swing.JLabel();
        jLabelComplemento = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelCNPJ = new javax.swing.JLabel();
        jTextFieldCNPJ = new javax.swing.JTextField();
        jLabelBairro = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabelEndereco = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelFundacao = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelTelefone = new javax.swing.JLabel();
        jTextFieldEndereco = new javax.swing.JTextField();
        jTextFieldNumero = new javax.swing.JTextField();
        jTextFieldComplemento = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jTextFieldCidade = new javax.swing.JTextField();
        jTextFieldEstado = new javax.swing.JTextField();
        jTextFieldFundacao = new javax.swing.JTextField();
        jLabelWebSite = new javax.swing.JLabel();
        jTextFieldWebSite = new javax.swing.JTextField();
        jTextFieldTelefone = new javax.swing.JTextField();
        jLabelImagemFundoCRUD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Editora");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNumero.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNumero.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumero.setText("Número:");
        getContentPane().add(jLabelNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabelComplemento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelComplemento.setForeground(new java.awt.Color(255, 255, 255));
        jLabelComplemento.setText("Complemento:");
        getContentPane().add(jLabelComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        jLabelEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmail.setText("Email:");
        getContentPane().add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        getContentPane().add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 270, -1));

        jLabelCNPJ.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelCNPJ.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCNPJ.setText("CNPJ:");
        getContentPane().add(jLabelCNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));
        getContentPane().add(jTextFieldCNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 20, 190, -1));

        jLabelBairro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelBairro.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBairro.setText("Bairro:");
        getContentPane().add(jLabelBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabelCidade.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelCidade.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCidade.setText("Cidade:");
        getContentPane().add(jLabelCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        jLabelEndereco.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEndereco.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEndereco.setText("Endereço:");
        getContentPane().add(jLabelEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        jLabelEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEstado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEstado.setText("Estado:");
        getContentPane().add(jLabelEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, -1, -1));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, -1, -1));

        jLabelCodigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCodigo.setText("Código:");
        getContentPane().add(jLabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 22, -1, -1));
        getContentPane().add(jTextFieldCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 19, 52, -1));

        jLabelFundacao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelFundacao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFundacao.setText("Fundação:");
        getContentPane().add(jLabelFundacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, -1, -1));

        jLabelNome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNome.setText("Nome:");
        getContentPane().add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));
        getContentPane().add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 234, -1));

        jLabelTelefone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelTelefone.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelefone.setText("Telefone:");
        getContentPane().add(jLabelTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));
        getContentPane().add(jTextFieldEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 290, -1));
        getContentPane().add(jTextFieldNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 130, -1));
        getContentPane().add(jTextFieldComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 100, 360, -1));
        getContentPane().add(jTextFieldBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 162, -1));
        getContentPane().add(jTextFieldCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 337, -1));
        getContentPane().add(jTextFieldEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 139, -1));
        getContentPane().add(jTextFieldFundacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 180, -1));

        jLabelWebSite.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelWebSite.setForeground(new java.awt.Color(255, 255, 255));
        jLabelWebSite.setText("Website:");
        getContentPane().add(jLabelWebSite, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        getContentPane().add(jTextFieldWebSite, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 330, -1));
        getContentPane().add(jTextFieldTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 203, -1));

        jLabelImagemFundoCRUD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/fundo_CRUDs.jpg"))); // NOI18N
        getContentPane().add(jLabelImagemFundoCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        System.out.println("Excluir");

        try {
            checkInput();
            dataDown();
            editora.delete();
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
            editora.save();
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
            java.util.logging.Logger.getLogger(JFrameEditoraCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameEditoraCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameEditoraCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameEditoraCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                    new JFrameEditoraCRUD( null, true ).setVisible(true);
                } catch (Exception ex) {
                    LogTrack.getInstance().addException( ex, true, null );
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCNPJ;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelComplemento;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelFundacao;
    private javax.swing.JLabel jLabelImagemFundoCRUD;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelWebSite;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCNPJ;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldEstado;
    private javax.swing.JTextField jTextFieldFundacao;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldTelefone;
    private javax.swing.JTextField jTextFieldWebSite;
    // End of variables declaration//GEN-END:variables
}
