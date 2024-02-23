package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class Livro extends DataAccessObject {
       
    private int codigoLivro;
    private String titulo;    
    private String anoPublicacao;
    private String isbn;
    private String idioma;
    private int quantidadePaginas;
    private String sinopse;
    private String edicao;
    private String formato;
    private String classificacaoEtaria;
    private String dataAquisicao;
    private Editora editora;  
    private Autor autor;
    private Genero genero;

    public Livro() {
        super("livros");
    }

    public int getCodigoLivro() {
        return codigoLivro;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public String getAnoPublicacao() {
        return anoPublicacao;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public String getIdioma() {
        return idioma;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getEdicao() {
        return edicao;
    }

    public String getFormato() {
        return formato;
    }

    public String getClassificacaoEtaria() {
        return classificacaoEtaria;
    }

    public String getDataAquisicao() {
        return dataAquisicao;
    }
    
    public Editora getEditora() {
        return editora;
    }

    public Autor getAutor() {
        return autor;
    }

    public Genero getGenero() {
        return genero;
    }
              
    public void setCodigoLivro(int codigoLivro) {
        if( codigoLivro != this.codigoLivro ) {
            this.codigoLivro = codigoLivro;
            addChange("codigo_livro", this.codigoLivro);
        }
    }

    public void setTitulo(String titulo) {
        if( !titulo.equals(this.titulo ) ) {
            this.titulo = titulo;
            addChange("titulo", this.titulo);
        }
    }

    public void setAnoPublicacao(String anoPublicacao) {
        if( !anoPublicacao.equals(this.anoPublicacao ) ) {
            this.anoPublicacao = anoPublicacao;
            addChange("ano_publicacao", this.anoPublicacao);
        }
    }

    public void setIsbn(String isbn) {
        if( !isbn.equals(this.isbn ) ) {
            this.isbn = isbn;
            addChange("isbn", this.isbn);
        }
    }
    
    public void setIdioma(String idioma) {
        if( !idioma.equals(this.idioma ) ) {
            this.idioma = idioma;
            addChange("idioma", this.idioma);
        }
    }

    public void setQuantidadePaginas(int quantidadePaginas) {
        if( quantidadePaginas != this.quantidadePaginas ) {
            this.quantidadePaginas = quantidadePaginas;
            addChange("quantidade_paginas", this.quantidadePaginas);
        }
    }

    public void setSinopse(String sinopse) {
        if( !sinopse.equals(this.sinopse ) ) {
            this.sinopse = sinopse;
            addChange("sinopse", this.sinopse);
        }
    }

    public void setEdicao(String edicao) {
        if( !edicao.equals(this.edicao ) ) {
            this.edicao = edicao;
            addChange("edicao", this.edicao);
        }
    }

    public void setFormato(String formato) {
        if( !formato.equals(this.formato ) ) {
            this.formato = formato;
            addChange("formato", this.formato);
        }
    }

    public void setClassificacaoEtaria(String classificacaoEtaria) {
        if( !classificacaoEtaria.equals(this.classificacaoEtaria ) ) {
            this.classificacaoEtaria = classificacaoEtaria;
            addChange("classificacao_etaria", this.classificacaoEtaria);
        }
    }
    
    public void setDataAquisicao(String dataAquisicao) {
        if( !dataAquisicao.equals(this.dataAquisicao ) ) {
            this.dataAquisicao = dataAquisicao;
            addChange("data_aquisicao", this.dataAquisicao);
        }
    }
    
    public void setEditora(Editora editora) throws Exception {
        
        if( this.editora  == null ) {
            
            if( editora != null ) {
                
                this.editora = new Editora();
                this.editora.setCodigoEditora(editora.getCodigoEditora());
                this.editora.load();
                addChange("codigo_editora", this.editora.getCodigoEditora());
                
            }
            
        } else {
            
            if( editora == null ) {
                
                this.editora = null;
                addChange( "codigo_editora", null );
                
            } else {
                
                if( !this.editora.equals(editora ) ) {
                    
                    this.editora.setCodigoEditora(editora.getCodigoEditora());
                    this.editora.load();
                    addChange("codigo_editora", this.editora.getCodigoEditora());
                    
                }
                
            }
        }
        
    }
    
    public void setAutor(Autor autor) throws Exception {
        
        if( this.autor  == null ) {
            
            if( autor != null ) {
                
                this.autor = new Autor();
                this.autor.setCodigoAutor(autor.getCodigoAutor());
                this.autor.load();
                addChange("codigo_autor", this.autor.getCodigoAutor());
                
            }
            
        } else {
            
            if( autor == null ) {
                
                this.autor = null;
                addChange( "codigo_autor", null );
                
            } else {
                
                if( !this.autor.equals(autor ) ) {
                    
                    this.autor.setCodigoAutor(autor.getCodigoAutor());
                    this.autor.load();
                    addChange("codigo_autor", this.autor.getCodigoAutor());
                    
                }
                
            }
        }
        
    }
    
    public void setGenero(Genero genero) throws Exception {
        
        if( this.genero  == null ) {
            
            if( genero != null ) {
                
                this.genero = new Genero();
                this.genero.setCodigoGenero(genero.getCodigoGenero());
                this.genero.load();
                addChange("codigo_genero", this.genero.getCodigoGenero());
                
            }
            
        } else {
            
            if( genero == null ) {
                
                this.genero = null;
                addChange( "codigo_genero", null );
                
            } else {
                
                if( !this.genero.equals(genero ) ) {
                    
                    this.genero.setCodigoGenero(genero.getCodigoGenero());
                    this.genero.load();
                    addChange("codigo_genero", this.genero.getCodigoGenero());
                    
                }
                
            }
        }
        
    }
       
    @Override
    protected String getWhereClauseForOneEntry() {
        return " codigo_livro = " + codigoLivro;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        
        codigoLivro = (int) data.get(0);
        titulo = (String) data.get(1);
        anoPublicacao = (String) data.get(2);
        isbn = (String) data.get(3);
        idioma = (String) data.get(4);
        quantidadePaginas = (int) data.get(5);
        sinopse = (String) data.get(6);
        edicao = (String) data.get(7);
        formato = (String) data.get(8);
        classificacaoEtaria = (String) data.get(9);    
        
        if( data.get(10) != null ) {
            dataAquisicao = data.get(10).toString();
        }
        
        if( data.get(11) != null ) {
            
            if( editora == null ) {
                editora = new Editora();
            }           
            
            editora.setCodigoEditora((int) data.get(11) );
            editora.load();
        }
        
        if( data.get(12) != null ) {
            
            if( autor == null ) {
                autor = new Autor();
            }           
            
            autor.setCodigoAutor((int) data.get(12) );
            autor.load();
        }
        
        if( data.get(13) != null ) {
            
            if( genero == null ) {
                genero = new Genero();
            }           
            
            genero.setCodigoGenero((int) data.get(13) );
            genero.load();
        }

    }
    
    @Override
    public boolean equals(Object obj) {        
        if( obj instanceof Livro ) {
           
           Livro aux;
           aux = (Livro) obj;
            
           if( codigoLivro == aux.getCodigoLivro()) {
               return true;
           }             
        }        
        return false;
    }
        
}