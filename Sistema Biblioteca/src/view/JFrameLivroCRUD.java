package view;

import java.awt.event.WindowEvent;
import model.Livro;
import controller.LogTrack;
import model.Autor;
import model.Editora;
import model.Genero;

public class JFrameLivroCRUD extends javax.swing.JFrame {
    
    private Livro livro;
    private Editora editora;  
    private Autor autor;
    private Genero genero;
    
    private boolean disconnectOnClose;

    public JFrameLivroCRUD( Livro livro, boolean disconnectOnClose ) throws Exception {
        initComponents();
        
        if( livro == null ) {
            this.livro  = new Livro();
        } else {
                        
            this.livro = livro;
            
            if( this.livro.getEditora()!= null ) {         
                
                this.editora = new Editora();
                this.editora.setCodigoEditora(this.livro.getEditora().getCodigoEditora());
                this.editora.load();
                
            }
            
            if( this.livro.getAutor()!= null ) {         
                
                this.autor = new Autor();
                this.autor.setCodigoAutor(this.livro.getAutor().getCodigoAutor());
                this.autor.load();
                
            }
            
            if( this.livro.getGenero()!= null ) {         
                
                this.genero = new Genero();
                this.genero.setCodigoGenero(this.livro.getGenero().getCodigoGenero());
                this.genero.load();
                
            }
            
            dataUp();
            jTextFieldCodigo.setEnabled(false);
            
        }
        
        this.disconnectOnClose = disconnectOnClose;
    }
    
     private void dataUp() {
   
        jTextFieldCodigo.setText( String.valueOf( livro.getCodigoLivro() ) );
        jTextFieldTitulo.setText( livro.getTitulo());        
        jTextFieldAnoPublicacao.setText( livro.getAnoPublicacao());
        jTextFieldISBN.setText( livro.getIsbn());
        jTextFieldIdioma.setText( livro.getIdioma());
        jTextFieldPaginas.setText( String.valueOf(livro.getQuantidadePaginas()));
        jTextAreaSinopse.setText(livro.getSinopse());
        jTextFieldEdicao.setText( livro.getEdicao());
        jTextFieldFormato.setText( livro.getFormato());
        
        if( ( livro.getClassificacaoEtaria()!= null ) && ( livro.getClassificacaoEtaria().equals("Livre") ) ) {
                jRadioButtonLivre.setSelected( true );
        } else {
            jRadioButtonLivre.setSelected( false );
        }
        
        if( ( livro.getClassificacaoEtaria()!= null ) && ( livro.getClassificacaoEtaria().equals("10 anos") ) ) {
                jRadioButton10anos.setSelected( true );
        } else {
            jRadioButton10anos.setSelected( false );
        }
        
        if( ( livro.getClassificacaoEtaria()!= null ) && ( livro.getClassificacaoEtaria().equals("12 anos") ) ) {
                jRadioButton12anos.setSelected( true );
        } else {
            jRadioButton12anos.setSelected( false );
        }
        
        if( ( livro.getClassificacaoEtaria()!= null ) && ( livro.getClassificacaoEtaria().equals("14 anos") ) ) {
                jRadioButton14anos.setSelected( true );
        } else {
            jRadioButton14anos.setSelected( false );
        }
        
        if( ( livro.getClassificacaoEtaria()!= null ) && ( livro.getClassificacaoEtaria().equals("16 anos") ) ) {
                jRadioButton16anos.setSelected( true );
        } else {
            jRadioButton16anos.setSelected( false );
        }
        
        if( ( livro.getClassificacaoEtaria()!= null ) && ( livro.getClassificacaoEtaria().equals("18 anos") ) ) {
                jRadioButton18anos.setSelected( true );
        } else {
            jRadioButton18anos.setSelected( false );
        }
        
        jTextFieldDataAquisicao.setText( livro.getDataAquisicao());
        
        if( livro.getEditora().getNome() != null ) {
            jTextFieldEditora.setText( livro.getEditora().getNome() );
        }
        
        if( livro.getAutor().getNomeCompleto()!= null ) {
            jTextFieldAutor.setText( livro.getAutor().getNomeCompleto());
        }
        
        if( livro.getGenero().getNome() != null ) {
            jTextFieldEditora2.setText( livro.getGenero().getNome() );
        }
        
    }
    
     private void dataDown() throws Exception {
      
        livro.setCodigoLivro( Integer.parseInt( jTextFieldCodigo.getText() ) );
        livro.setTitulo(jTextFieldTitulo.getText() );        
        livro.setAnoPublicacao(jTextFieldAnoPublicacao.getText() );
        livro.setIsbn(jTextFieldISBN.getText() );
        livro.setIdioma(jTextFieldIdioma.getText() );
        livro.setQuantidadePaginas(Integer.parseInt(jTextFieldPaginas.getText() ));
        livro.setSinopse(jTextAreaSinopse.getText());
        livro.setEdicao(jTextFieldEdicao.getText() );  
        livro.setFormato(jTextFieldFormato.getText() ); 
        
        if( jRadioButtonLivre.isSelected() ) {
            livro.setClassificacaoEtaria("Livre");
        }
        
        if( jRadioButton10anos.isSelected() ) {
            livro.setClassificacaoEtaria("10 anos");
        }
        
        if( jRadioButton12anos.isSelected() ) {
            livro.setClassificacaoEtaria("12 anos");
        }
        
        if( jRadioButton14anos.isSelected() ) {
            livro.setClassificacaoEtaria("14 anos");
        }
        
        if( jRadioButton16anos.isSelected() ) {
            livro.setClassificacaoEtaria("16 anos");
        }
        
        if( jRadioButton18anos.isSelected() ) {
            livro.setClassificacaoEtaria("18 anos");
        }
        
        livro.setDataAquisicao(jTextFieldDataAquisicao.getText() );
        
        livro.setEditora(editora);
        livro.setAutor(autor);
        livro.setGenero(genero);

     }
     
    private void checkInput() throws Exception {
        
        if( jTextFieldCodigo.getText().isEmpty() ) {
            throw new Exception("Informe Código.");
        } else {
            if( !jTextFieldCodigo.getText().matches("\\d+") ) {
                throw new Exception("O campo Código deve ser um número.");
            }
        }
        
        if( jTextFieldTitulo.getText().isEmpty() ) {
            throw new Exception("Informe o Título.");
        }
        
        if (jTextFieldAnoPublicacao.getText().isEmpty()) {
            throw new Exception("Informe o Ano de Publicação.");
        } else {
            if (!jTextFieldAnoPublicacao.getText().matches("\\d{4}")) {
                throw new Exception("O Ano de Publicação deve estar no formato AAAA (ano).");
            }
        }
        
        if (jTextFieldISBN.getText().isEmpty()) {
            throw new Exception("Informe o ISBN.");
        } else {
            if (!jTextFieldISBN.getText().matches("\\d{3}-\\d{2}-\\d{3,4}-\\d{3,4}-\\d{1}")) {
                throw new Exception("O ISBN deve estar no formato XXX-XX-XXX-XXXX-X ou XXX-XX-XXXX-XXX-X.");
            }
        }
        
        if( jTextFieldPaginas.getText().isEmpty() ) {
            throw new Exception("Informe o Número de Páginas.");
        } else {
            if( !jTextFieldPaginas.getText().matches("\\d+") ) {
                throw new Exception("O campo Páginas deve ser um número.");
            }
        }
        
        if( (GrupoButtonsClassificacaoEtaria.getSelection() == null )){
                throw new Exception("Selecione uma Classificação");
        }

        if(  jTextFieldDataAquisicao.getText().isEmpty() ) {
             throw new Exception("Informe Data de Aquisição.");
        } else {
            if( !jTextFieldDataAquisicao.getText().matches("\\d{4}-\\d{2}-\\d{2}")  ) {
                 throw new Exception("A Data de Aquisição deve estar no formato AAAA-MM-DD.");
            }
        }
        
        if( editora == null ) {
            throw new Exception("Informe Editora.");
        }
        
        if( autor == null ) {
            throw new Exception("Informe Autor.");
        }
        
        if( genero == null ) {
            throw new Exception("Informe Gênero.");
        }
        
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoButtonsClassificacaoEtaria = new javax.swing.ButtonGroup();
        jLabelSinopse = new javax.swing.JLabel();
        jLabelFormato = new javax.swing.JLabel();
        jLabelIdioma = new javax.swing.JLabel();
        jTextFieldIdioma = new javax.swing.JTextField();
        jLabelAnoPublicacao = new javax.swing.JLabel();
        jTextFieldAnoPublicacao = new javax.swing.JTextField();
        jLabelEdicao = new javax.swing.JLabel();
        jLabelClassificacaoEtaria = new javax.swing.JLabel();
        jLabelISBN = new javax.swing.JLabel();
        jLabelPaginas = new javax.swing.JLabel();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelTitulo = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jTextFieldISBN = new javax.swing.JTextField();
        jTextFieldPaginas = new javax.swing.JTextField();
        jTextFieldFormato = new javax.swing.JTextField();
        jTextFieldEdicao = new javax.swing.JTextField();
        jLabelDataAquisicao = new javax.swing.JLabel();
        jTextFieldDataAquisicao = new javax.swing.JTextField();
        jLabelEditora = new javax.swing.JLabel();
        jTextFieldEditora = new javax.swing.JTextField();
        jButtonSelecionarEditora = new javax.swing.JButton();
        jButtonApagarEditora = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaSinopse = new javax.swing.JTextArea();
        jRadioButtonLivre = new javax.swing.JRadioButton();
        jLabelLivre = new javax.swing.JLabel();
        jRadioButton10anos = new javax.swing.JRadioButton();
        jLabel10anos = new javax.swing.JLabel();
        jRadioButton12anos = new javax.swing.JRadioButton();
        jLabel12anos = new javax.swing.JLabel();
        jRadioButton14anos = new javax.swing.JRadioButton();
        jLabel14anos = new javax.swing.JLabel();
        jRadioButton16anos = new javax.swing.JRadioButton();
        jLabel16anos = new javax.swing.JLabel();
        jRadioButton18anos = new javax.swing.JRadioButton();
        jLabel18anos = new javax.swing.JLabel();
        jLabelAutor = new javax.swing.JLabel();
        jTextFieldAutor = new javax.swing.JTextField();
        jButtonSelecionarEditora1 = new javax.swing.JButton();
        jButtonApagarEditora1 = new javax.swing.JButton();
        jLabelEditora2 = new javax.swing.JLabel();
        jTextFieldEditora2 = new javax.swing.JTextField();
        jButtonSelecionarEditora2 = new javax.swing.JButton();
        jButtonApagarEditora2 = new javax.swing.JButton();
        jLabelImagemFundoCRUD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Livro");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelSinopse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelSinopse.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSinopse.setText("Sinopse:");
        getContentPane().add(jLabelSinopse, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, -1, -1));

        jLabelFormato.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelFormato.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFormato.setText("Formato:");
        getContentPane().add(jLabelFormato, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        jLabelIdioma.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelIdioma.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIdioma.setText("Idioma:");
        getContentPane().add(jLabelIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        getContentPane().add(jTextFieldIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 190, -1));

        jLabelAnoPublicacao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelAnoPublicacao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAnoPublicacao.setText("Ano Publicação:");
        getContentPane().add(jLabelAnoPublicacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));
        getContentPane().add(jTextFieldAnoPublicacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 118, -1));

        jLabelEdicao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEdicao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdicao.setText("Edição:");
        getContentPane().add(jLabelEdicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabelClassificacaoEtaria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelClassificacaoEtaria.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClassificacaoEtaria.setText("Classificação Etária:");
        getContentPane().add(jLabelClassificacaoEtaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabelISBN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelISBN.setForeground(new java.awt.Color(255, 255, 255));
        jLabelISBN.setText("ISBN:");
        getContentPane().add(jLabelISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, -1));

        jLabelPaginas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelPaginas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPaginas.setText("Páginas:");
        getContentPane().add(jLabelPaginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 230, -1, -1));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 230, -1, -1));

        jLabelCodigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCodigo.setText("Código:");
        getContentPane().add(jLabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 22, -1, -1));
        getContentPane().add(jTextFieldCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 19, 52, -1));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Título:");
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));
        getContentPane().add(jTextFieldTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 234, -1));
        getContentPane().add(jTextFieldISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 200, -1));
        getContentPane().add(jTextFieldPaginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 80, -1));
        getContentPane().add(jTextFieldFormato, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 160, -1));
        getContentPane().add(jTextFieldEdicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 200, -1));

        jLabelDataAquisicao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelDataAquisicao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDataAquisicao.setText("Data Aquisição:");
        getContentPane().add(jLabelDataAquisicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, -1, -1));
        getContentPane().add(jTextFieldDataAquisicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, 118, -1));

        jLabelEditora.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEditora.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEditora.setText("Editora:");
        getContentPane().add(jLabelEditora, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jTextFieldEditora.setEditable(false);
        getContentPane().add(jTextFieldEditora, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 170, -1));

        jButtonSelecionarEditora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarEditoraActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSelecionarEditora, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 30, 30));

        jButtonApagarEditora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarEditoraActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonApagarEditora, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 30, 30));

        jTextAreaSinopse.setColumns(20);
        jTextAreaSinopse.setRows(5);
        jScrollPane1.setViewportView(jTextAreaSinopse);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 420, 60));

        GrupoButtonsClassificacaoEtaria.add(jRadioButtonLivre);
        getContentPane().add(jRadioButtonLivre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        jLabelLivre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/classificao_livre.png"))); // NOI18N
        getContentPane().add(jLabelLivre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        GrupoButtonsClassificacaoEtaria.add(jRadioButton10anos);
        jRadioButton10anos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton10anosActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton10anos, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        jLabel10anos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/classificacao_10anos.png"))); // NOI18N
        getContentPane().add(jLabel10anos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        GrupoButtonsClassificacaoEtaria.add(jRadioButton12anos);
        getContentPane().add(jRadioButton12anos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        jLabel12anos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/classificacao_12anos.png"))); // NOI18N
        getContentPane().add(jLabel12anos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        GrupoButtonsClassificacaoEtaria.add(jRadioButton14anos);
        getContentPane().add(jRadioButton14anos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));

        jLabel14anos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/classificacao_14anos.png"))); // NOI18N
        getContentPane().add(jLabel14anos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));

        GrupoButtonsClassificacaoEtaria.add(jRadioButton16anos);
        getContentPane().add(jRadioButton16anos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        jLabel16anos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/classificacao_16anos.png"))); // NOI18N
        getContentPane().add(jLabel16anos, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        GrupoButtonsClassificacaoEtaria.add(jRadioButton18anos);
        getContentPane().add(jRadioButton18anos, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));

        jLabel18anos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/classificacao_18anos.png"))); // NOI18N
        getContentPane().add(jLabel18anos, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        jLabelAutor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelAutor.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAutor.setText("Autor:");
        getContentPane().add(jLabelAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        jTextFieldAutor.setEditable(false);
        getContentPane().add(jTextFieldAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 170, -1));

        jButtonSelecionarEditora1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarEditora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarEditora1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSelecionarEditora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 30, 30));

        jButtonApagarEditora1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarEditora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarEditora1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonApagarEditora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 30, 30));

        jLabelEditora2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEditora2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEditora2.setText("Editora:");
        getContentPane().add(jLabelEditora2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, -1, -1));

        jTextFieldEditora2.setEditable(false);
        getContentPane().add(jTextFieldEditora2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 170, -1));

        jButtonSelecionarEditora2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarEditora2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarEditora2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSelecionarEditora2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 180, 30, 30));

        jButtonApagarEditora2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarEditora2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarEditora2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonApagarEditora2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 180, 30, 30));

        jLabelImagemFundoCRUD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/fundo_livros.jpg"))); // NOI18N
        getContentPane().add(jLabelImagemFundoCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 270));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        System.out.println("Excluir");

        try {
            checkInput();
            dataDown();
            livro.delete();
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
            livro.save();
            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
        } catch(Exception ex) {            
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonSelecionarEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarEditoraActionPerformed
        // TODO add your handling code here:
        
        try {
            
            if( editora == null ) {
                editora = new Editora();
            }
            
            JFrameConsultaEditora jFrameConsulta;
            jFrameConsulta = new JFrameConsultaEditora( true, false, editora );
            
            jFrameConsulta.addWindowListener( new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if( editora.getNome()!= null ) {
                        jTextFieldEditora.setText( editora.getNome() );
                    }
                }
            } );
            
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ) {
            LogTrack.getInstance().addException( ex, true, this );
            editora = null;
        }
    }//GEN-LAST:event_jButtonSelecionarEditoraActionPerformed

    private void jButtonApagarEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarEditoraActionPerformed
        // TODO add your handling code here:
        editora = null;
        jTextFieldEditora.setText( null );
    }//GEN-LAST:event_jButtonApagarEditoraActionPerformed

    private void jRadioButton10anosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton10anosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton10anosActionPerformed

    private void jButtonSelecionarEditora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarEditora1ActionPerformed
        // TODO add your handling code here:
        try {
            
            if( autor == null ) {
                autor = new Autor();
            }
            
            JFrameConsultaAutor jFrameConsulta;
            jFrameConsulta = new JFrameConsultaAutor( true, false, autor );
            
            jFrameConsulta.addWindowListener( new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if( autor.getNomeCompleto()!= null ) {
                        jTextFieldAutor.setText( autor.getNomeCompleto());
                    }
                }
            } );
            
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ) {
            LogTrack.getInstance().addException( ex, true, this );
            autor = null;
        }
    }//GEN-LAST:event_jButtonSelecionarEditora1ActionPerformed

    private void jButtonApagarEditora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarEditora1ActionPerformed
        // TODO add your handling code here:
        autor = null;
        jTextFieldAutor.setText( null );
    }//GEN-LAST:event_jButtonApagarEditora1ActionPerformed

    private void jButtonSelecionarEditora2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarEditora2ActionPerformed
        // TODO add your handling code here:
        try {
            
            if( genero == null ) {
                genero = new Genero();
            }
            
            JFrameConsultaGenero jFrameConsulta;
            jFrameConsulta = new JFrameConsultaGenero( true, false, genero );
            
            jFrameConsulta.addWindowListener( new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if( genero.getNome()!= null ) {
                        jTextFieldEditora2.setText( genero.getNome());
                    }
                }
            } );
            
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ) {
            LogTrack.getInstance().addException( ex, true, this );
            genero = null;
        }
    }//GEN-LAST:event_jButtonSelecionarEditora2ActionPerformed

    private void jButtonApagarEditora2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarEditora2ActionPerformed
        // TODO add your handling code here:
        genero = null;
        jTextFieldEditora2.setText( null );
    }//GEN-LAST:event_jButtonApagarEditora2ActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameLivroCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameLivroCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameLivroCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameLivroCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                    new JFrameLivroCRUD( null, true ).setVisible(true);
                } catch (Exception ex) {
                    LogTrack.getInstance().addException( ex, true, null );
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoButtonsClassificacaoEtaria;
    private javax.swing.JButton jButtonApagarEditora;
    private javax.swing.JButton jButtonApagarEditora1;
    private javax.swing.JButton jButtonApagarEditora2;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSelecionarEditora;
    private javax.swing.JButton jButtonSelecionarEditora1;
    private javax.swing.JButton jButtonSelecionarEditora2;
    private javax.swing.JLabel jLabel10anos;
    private javax.swing.JLabel jLabel12anos;
    private javax.swing.JLabel jLabel14anos;
    private javax.swing.JLabel jLabel16anos;
    private javax.swing.JLabel jLabel18anos;
    private javax.swing.JLabel jLabelAnoPublicacao;
    private javax.swing.JLabel jLabelAutor;
    private javax.swing.JLabel jLabelClassificacaoEtaria;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDataAquisicao;
    private javax.swing.JLabel jLabelEdicao;
    private javax.swing.JLabel jLabelEditora;
    private javax.swing.JLabel jLabelEditora2;
    private javax.swing.JLabel jLabelFormato;
    private javax.swing.JLabel jLabelISBN;
    private javax.swing.JLabel jLabelIdioma;
    private javax.swing.JLabel jLabelImagemFundoCRUD;
    private javax.swing.JLabel jLabelLivre;
    private javax.swing.JLabel jLabelPaginas;
    private javax.swing.JLabel jLabelSinopse;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JRadioButton jRadioButton10anos;
    private javax.swing.JRadioButton jRadioButton12anos;
    private javax.swing.JRadioButton jRadioButton14anos;
    private javax.swing.JRadioButton jRadioButton16anos;
    private javax.swing.JRadioButton jRadioButton18anos;
    private javax.swing.JRadioButton jRadioButtonLivre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaSinopse;
    private javax.swing.JTextField jTextFieldAnoPublicacao;
    private javax.swing.JTextField jTextFieldAutor;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDataAquisicao;
    private javax.swing.JTextField jTextFieldEdicao;
    private javax.swing.JTextField jTextFieldEditora;
    private javax.swing.JTextField jTextFieldEditora2;
    private javax.swing.JTextField jTextFieldFormato;
    private javax.swing.JTextField jTextFieldISBN;
    private javax.swing.JTextField jTextFieldIdioma;
    private javax.swing.JTextField jTextFieldPaginas;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
