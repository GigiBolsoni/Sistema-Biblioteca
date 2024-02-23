package view;

import java.awt.event.WindowEvent;
import model.Usuario;
import controller.LogTrack;
import model.TipoUsuario;

public class JFrameUsuarioCRUD extends javax.swing.JFrame {
    
    private Usuario usuario;
    private TipoUsuario tipoUsuario;
    
    private boolean disconnectOnClose;

    public JFrameUsuarioCRUD( Usuario usuario, boolean disconnectOnClose ) throws Exception {
        initComponents();
        
        if( usuario == null ) {
            this.usuario  = new Usuario();
        } else {
                        
            this.usuario = usuario;
            
            if( this.usuario.getTipoUsuario() != null ) {         
                
                this.tipoUsuario = new TipoUsuario();
                this.tipoUsuario.setCodigoTipo( this.usuario.getTipoUsuario().getCodigoTipo() );
                this.tipoUsuario.load();
                
            }
            
            dataUp();
            jTextFieldCodigo.setEnabled(false);
            
        }
        
        this.disconnectOnClose = disconnectOnClose;
    }
    
     private void dataUp() {
   
        jTextFieldCodigo.setText( String.valueOf( usuario.getCodigoUsuario() ) );
        jTextFieldNome.setText( usuario.getNomeCompleto() );        
        jTextFieldDataNascimento.setText( usuario.getDataNascimento() );
        jTextFieldCpf.setText( usuario.getNumeroCpf() );
        jTextFieldEmail.setText( usuario.getEmail() );
        jTextFieldEndereco.setText( usuario.getEndereco() );
        jTextFieldNumero.setText( usuario.getNumero() );
        jTextFieldComplemento.setText( usuario.getComplemento() );
        jTextFieldBairro.setText( usuario.getBairro() );
        jTextFieldCidade.setText( usuario.getCidade() );
        jTextFieldEstado.setText( usuario.getEstado() );
        jTextFieldCelular.setText( usuario.getCelular() );
        jTextFieldDataCadastro.setText( usuario.getDataCadastro());
        jPasswordFieldSenha.setText( usuario.getSenhaAcesso() );
        
        if( usuario.getTipoUsuario().getNome() != null ) {
            jTextFieldTipoUsuario.setText( usuario.getTipoUsuario().getNome() );
        }
        
    }
    
     private void dataDown() throws Exception {
      
        usuario.setCodigoUsuario( Integer.parseInt( jTextFieldCodigo.getText() ) );
        usuario.setNomeCompleto( jTextFieldNome.getText() );        
        usuario.setDataNascimento( jTextFieldDataNascimento.getText() );
        usuario.setNumeroCpf( jTextFieldCpf.getText() );
        usuario.setEmail( jTextFieldEmail.getText() );
        usuario.setEndereco( jTextFieldEndereco.getText() );
        usuario.setNumero( jTextFieldNumero.getText() );
        usuario.setComplemento( jTextFieldComplemento.getText() );
        usuario.setBairro( jTextFieldBairro.getText() );
        usuario.setCidade( jTextFieldCidade.getText() );
        usuario.setEstado( jTextFieldEstado.getText() );
        usuario.setCelular( jTextFieldCelular.getText() );     
        usuario.setDataCadastro(jTextFieldDataCadastro.getText() );
        
        usuario.setSenhaAcesso( jPasswordFieldSenha.getText() );
        
        usuario.setTipoUsuario( tipoUsuario );

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
        
        if(  jTextFieldDataNascimento.getText().isEmpty() ) {
             throw new Exception("Informe Data de Nascimento.");
        } else {
            if( !jTextFieldDataNascimento.getText().matches("\\d{4}-\\d{2}-\\d{2}")  ) {
                 throw new Exception("A Data de Nascimento deve estar no formato AAAA-MM-DD.");
            }
        }
        
        if (jTextFieldCpf.getText().isEmpty()) {
            throw new Exception("Informe o CPF.");
        } else {
            if (!jTextFieldCpf.getText().matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
                throw new Exception("O CPF deve estar no formato XXX.XXX.XXX-XX.");
            }
        }
        
        if (jTextFieldCelular.getText().isEmpty()) {
            throw new Exception("Informe o Número de Celular.");
        } else {
            if (!jTextFieldCelular.getText().matches("\\(\\d{2}\\)\\s?\\d{4,5}-\\d{4}")) {
                throw new Exception("O Número de Celular deve estar no formato (XX)XXXXX-XXXX ou (XX)XXXX-XXXX.");
            }
        }
        
        if(  jTextFieldDataCadastro.getText().isEmpty() ) {
             throw new Exception("Informe Data de Cadastro.");
        } else {
            if( !jTextFieldDataCadastro.getText().matches("\\d{4}-\\d{2}-\\d{2}")  ) {
                 throw new Exception("A Data de Cadastro deve estar no formato AAAA-MM-DD.");
            }
        }

        if( jPasswordFieldSenha.getText().isEmpty() ) {
            throw new Exception("Informe Senha.");
        }
        
        if( tipoUsuario == null ) {
            throw new Exception("Informe Tipo Usuário.");
        }
        
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNumero = new javax.swing.JLabel();
        jLabelComplemento = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelDataNascimento = new javax.swing.JLabel();
        jTextFieldDataNascimento = new javax.swing.JTextField();
        jLabelBairro = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabelCPF = new javax.swing.JLabel();
        jLabelEndereco = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelSenha = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelCelular = new javax.swing.JLabel();
        jTextFieldCpf = new javax.swing.JTextField();
        jTextFieldEndereco = new javax.swing.JTextField();
        jTextFieldNumero = new javax.swing.JTextField();
        jTextFieldComplemento = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jTextFieldCidade = new javax.swing.JTextField();
        jTextFieldEstado = new javax.swing.JTextField();
        jTextFieldCelular = new javax.swing.JTextField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jLabelDataCadastro = new javax.swing.JLabel();
        jTextFieldDataCadastro = new javax.swing.JTextField();
        jLabelTipoUsuario = new javax.swing.JLabel();
        jTextFieldTipoUsuario = new javax.swing.JTextField();
        jButtonSelecionarTipoUsuario = new javax.swing.JButton();
        jButtonApagarTipoUsuario = new javax.swing.JButton();
        jLabelImagemFundoCRUD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuário");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNumero.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNumero.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumero.setText("Número:");
        getContentPane().add(jLabelNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 102, -1, -1));

        jLabelComplemento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelComplemento.setForeground(new java.awt.Color(255, 255, 255));
        jLabelComplemento.setText("Complemento:");
        getContentPane().add(jLabelComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 142, -1, -1));

        jLabelEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmail.setText("Email:");
        getContentPane().add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));
        getContentPane().add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 400, -1));

        jLabelDataNascimento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelDataNascimento.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDataNascimento.setText("Data Nascimento:");
        getContentPane().add(jLabelDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));
        getContentPane().add(jTextFieldDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 118, -1));

        jLabelBairro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelBairro.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBairro.setText("Bairro:");
        getContentPane().add(jLabelBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 142, -1, -1));

        jLabelCidade.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelCidade.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCidade.setText("Cidade:");
        getContentPane().add(jLabelCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 182, -1, -1));

        jLabelCPF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelCPF.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCPF.setText("CPF:");
        getContentPane().add(jLabelCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabelEndereco.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEndereco.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEndereco.setText("Endereço:");
        getContentPane().add(jLabelEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 102, -1, -1));

        jLabelEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEstado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEstado.setText("Estado:");
        getContentPane().add(jLabelEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 182, -1, -1));

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

        jLabelSenha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelSenha.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSenha.setText("Senha:");
        getContentPane().add(jLabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, -1, -1));

        jLabelNome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNome.setText("Nome:");
        getContentPane().add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));
        getContentPane().add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 234, -1));

        jLabelCelular.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelCelular.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCelular.setText("Celular:");
        getContentPane().add(jLabelCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        getContentPane().add(jTextFieldCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 199, -1));
        getContentPane().add(jTextFieldEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 99, 389, -1));
        getContentPane().add(jTextFieldNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 99, 87, -1));
        getContentPane().add(jTextFieldComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 139, 299, -1));
        getContentPane().add(jTextFieldBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(483, 139, 162, -1));
        getContentPane().add(jTextFieldCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 179, 337, -1));
        getContentPane().add(jTextFieldEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 179, 139, -1));
        getContentPane().add(jTextFieldCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 203, -1));
        getContentPane().add(jPasswordFieldSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 150, -1));

        jLabelDataCadastro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelDataCadastro.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDataCadastro.setText("Data Cadastro:");
        getContentPane().add(jLabelDataCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));
        getContentPane().add(jTextFieldDataCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 118, -1));

        jLabelTipoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelTipoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTipoUsuario.setText("Tipo Usuário:");
        getContentPane().add(jLabelTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jTextFieldTipoUsuario.setEditable(false);
        getContentPane().add(jTextFieldTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 170, -1));

        jButtonSelecionarTipoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarTipoUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSelecionarTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 30, 30));

        jButtonApagarTipoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarTipoUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonApagarTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 30, 30));

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
            usuario.delete();
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
            usuario.save();
            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
        } catch(Exception ex) {            
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonSelecionarTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarTipoUsuarioActionPerformed
        // TODO add your handling code here:
        
        try {
            
            if( tipoUsuario == null ) {
                tipoUsuario = new TipoUsuario();
            }
            
            JFrameConsultaTipoUsuario jFrameConsulta;
            jFrameConsulta = new JFrameConsultaTipoUsuario( true, false, tipoUsuario );
            
            jFrameConsulta.addWindowListener( new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if( tipoUsuario.getNome() != null ) {
                        jTextFieldTipoUsuario.setText( tipoUsuario.getNome() );
                    }
                }
            } );
            
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ) {
            LogTrack.getInstance().addException( ex, true, this );
            tipoUsuario = null;
        }
    }//GEN-LAST:event_jButtonSelecionarTipoUsuarioActionPerformed

    private void jButtonApagarTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarTipoUsuarioActionPerformed
        // TODO add your handling code here:
        tipoUsuario = null;
        jTextFieldTipoUsuario.setText( null );
    }//GEN-LAST:event_jButtonApagarTipoUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameUsuarioCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameUsuarioCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameUsuarioCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameUsuarioCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFrameUsuarioCRUD( null, true ).setVisible(true);
                } catch (Exception ex) {
                    LogTrack.getInstance().addException( ex, true, null );
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApagarTipoUsuario;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSelecionarTipoUsuario;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelCelular;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelComplemento;
    private javax.swing.JLabel jLabelDataCadastro;
    private javax.swing.JLabel jLabelDataNascimento;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelImagemFundoCRUD;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelTipoUsuario;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCelular;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldDataCadastro;
    private javax.swing.JTextField jTextFieldDataNascimento;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldEstado;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldTipoUsuario;
    // End of variables declaration//GEN-END:variables
}
