package view;

import java.awt.event.WindowEvent;
import controller.LogTrack;
import model.Livro;
import model.Resenha;
import model.Usuario;

public class JFrameResenhaCRUD extends javax.swing.JFrame {
    
    private Resenha resenha;
    private Usuario usuario;  
    private Livro livro;
    
    private boolean disconnectOnClose;

    public JFrameResenhaCRUD( Resenha resenha, boolean disconnectOnClose ) throws Exception {
        initComponents();
        
        if( resenha == null ) {
            this.resenha  = new Resenha();
        } else {
                        
            this.resenha = resenha;
            
            if( this.resenha.getUsuario()!= null ) {         
                
                this.usuario = new Usuario();
                this.usuario.setCodigoUsuario(this.resenha.getUsuario().getCodigoUsuario());
                this.usuario.load();
                
            }
            
            if( this.resenha.getLivro()!= null ) {         
                
                this.livro = new Livro();
                this.livro.setCodigoLivro(this.resenha.getLivro().getCodigoLivro());
                this.livro.load();
                
            }
            
            dataUp();
            jTextFieldCodigo.setEnabled(false);
            
        }
        
        this.disconnectOnClose = disconnectOnClose;
    }
    
     private void dataUp() {
   
        jTextFieldCodigo.setText( String.valueOf( resenha.getCodigoResenha() ) );
        
        if( ( resenha.getAvaliacao()!= null ) && ( resenha.getAvaliacao().equals("1 estrela") ) ) {
                jRadioButton1estrela.setSelected( true );
        } else {
            jRadioButton1estrela.setSelected( false );
        }
        
        if( ( resenha.getAvaliacao()!= null ) && ( resenha.getAvaliacao().equals("2 estrelas") ) ) {
                jRadioButton2estrelas.setSelected( true );
        } else {
            jRadioButton2estrelas.setSelected( false );
        }
        
        if( ( resenha.getAvaliacao()!= null ) && ( resenha.getAvaliacao().equals("3 estrelas") ) ) {
                jRadioButton3estrelas.setSelected( true );
        } else {
            jRadioButton3estrelas.setSelected( false );
        }
        
        if( ( resenha.getAvaliacao()!= null ) && ( resenha.getAvaliacao().equals("4 estrelas") ) ) {
                jRadioButton4estrelas.setSelected( true );
        } else {
            jRadioButton4estrelas.setSelected( false );
        }
        
        if( ( resenha.getAvaliacao()!= null ) && ( resenha.getAvaliacao().equals("5 estrelas") ) ) {
                jRadioButton5estrelas.setSelected( true );
        } else {
            jRadioButton5estrelas.setSelected( false );
        }
        
        jTextFieldTitulo.setText( resenha.getTitulo());
        jTextAreaComentario.setText(resenha.getComentario());        
        jTextFieldData.setText( resenha.getData());
        
        if( resenha.getUsuario().getNomeCompleto()!= null ) {
            jTextFieldUsuario.setText( resenha.getUsuario().getNomeCompleto());
        }
        
        if( resenha.getLivro().getTitulo()!= null ) {
            jTextFieldLivro.setText( resenha.getLivro().getTitulo());
        }        
    }
    
     private void dataDown() throws Exception {
      
        resenha.setCodigoResenha( Integer.parseInt( jTextFieldCodigo.getText() ) );
        
        if( jRadioButton1estrela.isSelected() ) {
            resenha.setAvaliacao("1 estrela");
        }
        
        if( jRadioButton2estrelas.isSelected() ) {
            resenha.setAvaliacao("2 estrelas");
        }
        
        if( jRadioButton3estrelas.isSelected() ) {
            resenha.setAvaliacao("3 estrelas");
        }
        
        if( jRadioButton4estrelas.isSelected() ) {
            resenha.setAvaliacao("4 estrelas");
        }
        
        if( jRadioButton5estrelas.isSelected() ) {
            resenha.setAvaliacao("5 estrelas");
        }
        
        resenha.setTitulo(jTextFieldTitulo.getText() );
        resenha.setComentario(jTextAreaComentario.getText());
        resenha.setData(jTextFieldData.getText() );        
        resenha.setUsuario(usuario);
        resenha.setLivro(livro);
     }
     
    private void checkInput() throws Exception {
        
        if( jTextFieldCodigo.getText().isEmpty() ) {
            throw new Exception("Informe Código.");
        } else {
            if( !jTextFieldCodigo.getText().matches("\\d+") ) {
                throw new Exception("O campo Código deve ser um número.");
            }
        }
        
        if( (GrupoButtonsAvaliacoes.getSelection() == null )){
                throw new Exception("Selecione uma Avaliação");
        }
        
        if( jTextFieldTitulo.getText().isEmpty() ) {
            throw new Exception("Informe o Título.");
        }
        
        if(  jTextFieldData.getText().isEmpty() ) {
             throw new Exception("Informe Data.");
        } else {
            if( !jTextFieldData.getText().matches("\\d{4}-\\d{2}-\\d{2}")  ) {
                 throw new Exception("A Data de Aquisição deve estar no formato AAAA-MM-DD.");
            }
        }
        
        if( usuario == null ) {
            throw new Exception("Informe Usuário.");
        }
        
        if( livro == null ) {
            throw new Exception("Informe Livro.");
        }
        
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoButtonsAvaliacoes = new javax.swing.ButtonGroup();
        jLabelComentario = new javax.swing.JLabel();
        jLabelAvaliacao = new javax.swing.JLabel();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelTitulo = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabelData = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JTextField();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jButtonSelecionarUsuario = new javax.swing.JButton();
        jButtonApagarUsuario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaComentario = new javax.swing.JTextArea();
        jRadioButton1estrela = new javax.swing.JRadioButton();
        jLabel1estrela = new javax.swing.JLabel();
        jRadioButton2estrelas = new javax.swing.JRadioButton();
        jLabel2estrelas = new javax.swing.JLabel();
        jRadioButton3estrelas = new javax.swing.JRadioButton();
        jLabel3estrelas = new javax.swing.JLabel();
        jRadioButton4estrelas = new javax.swing.JRadioButton();
        jLabel4estrelas = new javax.swing.JLabel();
        jRadioButton5estrelas = new javax.swing.JRadioButton();
        jLabel5estrelas = new javax.swing.JLabel();
        jLabelLivro = new javax.swing.JLabel();
        jTextFieldLivro = new javax.swing.JTextField();
        jButtonSelecionarLivro = new javax.swing.JButton();
        jButtonApagarLivro = new javax.swing.JButton();
        jLabelImagemFundoCRUD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Resenha");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelComentario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelComentario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelComentario.setText("Comentário:");
        getContentPane().add(jLabelComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        jLabelAvaliacao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelAvaliacao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAvaliacao.setText("Avaliação:");
        getContentPane().add(jLabelAvaliacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, -1, -1));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, -1, -1));

        jLabelCodigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCodigo.setText("Código:");
        getContentPane().add(jLabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 22, -1, -1));
        getContentPane().add(jTextFieldCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 19, 52, -1));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Título:");
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));
        getContentPane().add(jTextFieldTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 240, -1));

        jLabelData.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelData.setForeground(new java.awt.Color(255, 255, 255));
        jLabelData.setText("Data:");
        getContentPane().add(jLabelData, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));
        getContentPane().add(jTextFieldData, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 118, -1));

        jLabelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Usuário:");
        getContentPane().add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));

        jTextFieldUsuario.setEditable(false);
        getContentPane().add(jTextFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 170, -1));

        jButtonSelecionarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSelecionarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 30, 30));

        jButtonApagarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonApagarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 30, 30));

        jTextAreaComentario.setColumns(20);
        jTextAreaComentario.setRows(5);
        jScrollPane1.setViewportView(jTextAreaComentario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 420, 60));

        GrupoButtonsAvaliacoes.add(jRadioButton1estrela);
        getContentPane().add(jRadioButton1estrela, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        jLabel1estrela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem_1estrela.png"))); // NOI18N
        getContentPane().add(jLabel1estrela, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        GrupoButtonsAvaliacoes.add(jRadioButton2estrelas);
        jRadioButton2estrelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2estrelasActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2estrelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        jLabel2estrelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem_2estrelas.png"))); // NOI18N
        getContentPane().add(jLabel2estrelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        GrupoButtonsAvaliacoes.add(jRadioButton3estrelas);
        getContentPane().add(jRadioButton3estrelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jLabel3estrelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem_3estrelas.png"))); // NOI18N
        getContentPane().add(jLabel3estrelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        GrupoButtonsAvaliacoes.add(jRadioButton4estrelas);
        getContentPane().add(jRadioButton4estrelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jLabel4estrelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem_4estrelas.png"))); // NOI18N
        getContentPane().add(jLabel4estrelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        GrupoButtonsAvaliacoes.add(jRadioButton5estrelas);
        getContentPane().add(jRadioButton5estrelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jLabel5estrelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem_5estrelas.png"))); // NOI18N
        getContentPane().add(jLabel5estrelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        jLabelLivro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelLivro.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLivro.setText("Livro:");
        getContentPane().add(jLabelLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jTextFieldLivro.setEditable(false);
        getContentPane().add(jTextFieldLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 170, -1));

        jButtonSelecionarLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarLivroActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSelecionarLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 30, 30));

        jButtonApagarLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarLivroActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonApagarLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 30, 30));

        jLabelImagemFundoCRUD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/fundo_livros.jpg"))); // NOI18N
        getContentPane().add(jLabelImagemFundoCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 270));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        System.out.println("Excluir");

        try {
            checkInput();
            dataDown();
            resenha.delete();
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
            resenha.save();
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
            jFrameConsulta = new JFrameConsultaUsuario( true, false, usuario, false );
            
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

    private void jRadioButton2estrelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2estrelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2estrelasActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameResenhaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameResenhaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameResenhaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameResenhaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFrameResenhaCRUD( null, true ).setVisible(true);
                } catch (Exception ex) {
                    LogTrack.getInstance().addException( ex, true, null );
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoButtonsAvaliacoes;
    private javax.swing.JButton jButtonApagarLivro;
    private javax.swing.JButton jButtonApagarUsuario;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSelecionarLivro;
    private javax.swing.JButton jButtonSelecionarUsuario;
    private javax.swing.JLabel jLabel1estrela;
    private javax.swing.JLabel jLabel2estrelas;
    private javax.swing.JLabel jLabel3estrelas;
    private javax.swing.JLabel jLabel4estrelas;
    private javax.swing.JLabel jLabel5estrelas;
    private javax.swing.JLabel jLabelAvaliacao;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelComentario;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelImagemFundoCRUD;
    private javax.swing.JLabel jLabelLivro;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JRadioButton jRadioButton1estrela;
    private javax.swing.JRadioButton jRadioButton2estrelas;
    private javax.swing.JRadioButton jRadioButton3estrelas;
    private javax.swing.JRadioButton jRadioButton4estrelas;
    private javax.swing.JRadioButton jRadioButton5estrelas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaComentario;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldLivro;
    private javax.swing.JTextField jTextFieldTitulo;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
