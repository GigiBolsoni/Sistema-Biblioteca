package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class Resenha extends DataAccessObject {
       
    private int codigoResenha;
    private String avaliacao;    
    private String titulo;
    private String comentario;
    private String data;
    private Usuario usuario;  
    private Livro livro;

    public Resenha() {
        super("resenhas");
    }

    public int getCodigoResenha() {
        return codigoResenha;
    }

    public String getAvaliacao() {
        return avaliacao;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getComentario() {
        return comentario;
    }

    public String getData() {
        return data;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }
              
    public void setCodigoResenha(int codigoResenha) {
        if( codigoResenha != this.codigoResenha ) {
            this.codigoResenha = codigoResenha;
            addChange("codigo_resenha", this.codigoResenha);
        }
    }

    public void setAvaliacao(String avaliacao) {
        if( !avaliacao.equals(this.avaliacao ) ) {
            this.avaliacao = avaliacao;
            addChange("avaliacao", this.avaliacao);
        }
    }

    public void setTitulo(String titulo) {
        if( !titulo.equals(this.titulo ) ) {
            this.titulo = titulo;
            addChange("titulo_resenha", this.titulo);
        }
    }

    public void setComentario(String comentario) {
        if( !comentario.equals(this.comentario ) ) {
            this.comentario = comentario;
            addChange("comentario", this.comentario);
        }
    }
    
    public void setData(String data) {
        if( !data.equals(this.data ) ) {
            this.data = data;
            addChange("data_resenha", this.data);
        }
    }
    
    public void setUsuario(Usuario usuario) throws Exception {
        
        if( this.usuario  == null ) {
            
            if( usuario != null ) {
                
                this.usuario = new Usuario();
                this.usuario.setCodigoUsuario(usuario.getCodigoUsuario());
                this.usuario.load();
                addChange("codigo_usuario", this.usuario.getCodigoUsuario());
                
            }
            
        } else {
            
            if( usuario == null ) {
                
                this.usuario = null;
                addChange( "codigo_usuario", null );
                
            } else {
                
                if( !this.usuario.equals(usuario ) ) {
                    
                    this.usuario.setCodigoUsuario(usuario.getCodigoUsuario());
                    this.usuario.load();
                    addChange("codigo_usuario", this.usuario.getCodigoUsuario());
                    
                }
                
            }
        }
        
    }
    
    public void setLivro(Livro livro) throws Exception {
        
        if( this.livro  == null ) {
            
            if( livro != null ) {
                
                this.livro = new Livro();
                this.livro.setCodigoLivro(livro.getCodigoLivro());
                this.livro.load();
                addChange("codigo_livro", this.livro.getCodigoLivro());
                
            }
            
        } else {
            
            if( livro == null ) {
                
                this.livro = null;
                addChange( "codigo_livro", null );
                
            } else {
                
                if( !this.livro.equals(livro ) ) {
                    
                    this.livro.setCodigoLivro(livro.getCodigoLivro());
                    this.livro.load();
                    addChange("codigo_livro", this.livro.getCodigoLivro());
                    
                }
                
            }
        }
        
    }
       
    @Override
    protected String getWhereClauseForOneEntry() {
        return " codigo_resenha = " + codigoResenha;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        
        codigoResenha = (int) data.get(0);
        avaliacao = (String) data.get(1);
        titulo = (String) data.get(2);
        comentario = (String) data.get(3); 
        
        if( data.get(4) != null ) {
            this.data = data.get(4).toString();
        }
        
        if( data.get(5) != null ) {
            
            if( usuario == null ) {
                usuario = new Usuario();
            }           
            
            usuario.setCodigoUsuario((int) data.get(5) );
            usuario.load();
        }
        
        if( data.get(6) != null ) {
            
            if( livro == null ) {
                livro = new Livro();
            }           
            
            livro.setCodigoLivro((int) data.get(6) );
            livro.load();
        }
    }
    
    @Override
    public boolean equals(Object obj) {        
        if( obj instanceof Resenha ) {
           
           Resenha aux;
           aux = (Resenha) obj;
            
           if( codigoResenha == aux.getCodigoResenha()) {
               return true;
           }             
        }        
        return false;
    }
        
}