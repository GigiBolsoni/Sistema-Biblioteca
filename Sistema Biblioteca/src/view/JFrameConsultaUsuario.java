package view;

import controller.LogTrack;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import controller.ResultSetTableModel;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.RowFilter;
import model.Usuario;

public class JFrameConsultaUsuario extends javax.swing.JFrame {
    
    private boolean alterarAdiconar;
    
    private Usuario usuario;
    private boolean select;
    private boolean disconnectOnClose;
    
    private String query = "SELECT usuarios.codigo_usuario as ID, usuarios.nome_completo as Nome, numero_cpf as CPF, email as Email, tipo_usuario.nome as Tipo FROM usuarios LEFT JOIN tipo_usuario ON usuarios.codigo_tipo_usuario = tipo_usuario.codigo_tipo ORDER BY ID";
    
    private ResultSetTableModel result;   
    private final TableRowSorter< TableModel > filter;

    public JFrameConsultaUsuario( boolean select, boolean disconnectOnClose, Usuario usuario, boolean alterarAdiconar ) throws SQLException {
        initComponents();
        
        this.alterarAdiconar = alterarAdiconar;
        
        jButtonAdicionar.setEnabled(this.alterarAdiconar);
        jButtonAlterar.setEnabled(this.alterarAdiconar);
        
        this.usuario = usuario;
        this.select = select;
        jButtonSelecionar.setEnabled( this.select );
        
        this.disconnectOnClose = disconnectOnClose;
        
        result = new ResultSetTableModel( query );
        jTableConsulta.setModel( result );
        
        filter = new TableRowSorter< TableModel >( result );
        jTableConsulta.setRowSorter( filter );     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jLabelFiltro = new javax.swing.JLabel();
        jTextFieldFiltro = new javax.swing.JTextField();
        jButtonFiltrar = new javax.swing.JButton();
        jButtonSelecionar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonAdicionar = new javax.swing.JButton();
        jLabelImagemFundoConsulta = new javax.swing.JLabel();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Usuários");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableConsulta.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableConsulta);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 886, 214));

        jLabelFiltro.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelFiltro.setForeground(new java.awt.Color(242, 242, 242));
        jLabelFiltro.setText("Filtro:");
        getContentPane().add(jLabelFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, 20));

        jTextFieldFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFiltroActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 183, -1));

        jButtonFiltrar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 100, -1));

        jButtonSelecionar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButtonSelecionar.setText("Selecionar");
        jButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSelecionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 100, -1));

        jButtonAlterar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, 100, -1));

        jButtonAdicionar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 320, 100, -1));

        jLabelImagemFundoConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/fundo_consultas.jpg"))); // NOI18N
        getContentPane().add(jLabelImagemFundoConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        // TODO add your handling code here:
        System.out.println("Filtrar");
        
        String filtro = jTextFieldFiltro.getText();
        if ( filtro.isEmpty() ) {
            filter.setRowFilter( null );
        } else {
            filter.setRowFilter( RowFilter.regexFilter( filtro ) );
        }
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        // TODO add your handling code here:
        System.out.println("Adicionar");
        
        try {
        
            JFrameUsuarioCRUD jFrameCRUD;
            jFrameCRUD = new JFrameUsuarioCRUD( null, false );

            jFrameCRUD.addWindowListener( new java.awt.event.WindowAdapter(){
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent evt) {
                         System.out.println("Atualizar");
                         try {
                             result.setQuery( query );
                         } catch ( Exception ex ) {
                             LogTrack.getInstance().addException( ex, true, null);
                         }
                    }
                } );

            jFrameCRUD.setVisible( true );
        
        } catch (Exception ex) {
            LogTrack.getInstance().addException( ex, true, this );
        }
        
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        // TODO add your handling code here:
        
        int row = jTableConsulta.getSelectedRow();
        if( row != -1 ) {
            
            System.out.println("Alterar");
            
            int codigo = (int) result.getValueAt( row, 0 );
            
            Usuario usuario = new Usuario();
            usuario.setCodigoUsuario(codigo);
            
            try {
                
                usuario.load();
                
                JFrameUsuarioCRUD jFrameCRUD;
                jFrameCRUD = new JFrameUsuarioCRUD( usuario, false );

                jFrameCRUD.addWindowListener( new java.awt.event.WindowAdapter(){
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent evt) {
                             System.out.println("Atualizar");
                             try {
                                 result.setQuery( query );
                             } catch ( Exception ex ) {
                                 LogTrack.getInstance().addException( ex, true, null );
                             }
                        }
                    } );

                jFrameCRUD.setVisible( true );
                
                
            } catch( Exception ex ) {
                LogTrack.getInstance().addException( ex, true, this );
            }            
            
        }
        
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        
        if( this.disconnectOnClose ) {
            System.out.println("Desconectar.");
            result.disconnectFromDatabase();
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarActionPerformed
        // TODO add your handling code here:
        
        int row = jTableConsulta.getSelectedRow();
        if( row != -1 ) {
            
            System.out.println("Selecionar");
            
            int codigo = (int) result.getValueAt( row, 0 );
            
            this.usuario.setCodigoUsuario(codigo);
            
            try {
                this.usuario.load();
                this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
            } catch( Exception ex ) {
                LogTrack.getInstance().addException(ex, true, this);
            }
            
        }        
    }//GEN-LAST:event_jButtonSelecionarActionPerformed

    private void jTextFieldFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFiltroActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameConsultaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameConsultaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameConsultaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameConsultaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                    new JFrameConsultaUsuario( false, true, null, true).setVisible(true);
                } catch ( Exception ex ) {
                    LogTrack.getInstance().addException( ex, true, null );
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonSelecionar;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabelFiltro;
    private javax.swing.JLabel jLabelImagemFundoConsulta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTextField jTextFieldFiltro;
    // End of variables declaration//GEN-END:variables
}
