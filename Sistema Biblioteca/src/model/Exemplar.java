package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class Exemplar extends DataAccessObject {
       
    private int codigoExemplar;
    private String status;    
    private String dataAquisicao;
    private Livro livro;

    public Exemplar() {
        super("exemplares");
    }

    public int getCodigoExemplar() {
        return codigoExemplar;
    }

    public String getStatus() {
        return status;
    }
    
    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setCodigoExemplar(int codigoExemplar) {
        if( codigoExemplar != this.codigoExemplar ) {
            this.codigoExemplar = codigoExemplar;
            addChange("codigo_exemplar", this.codigoExemplar);
        }
    }

    public void setStatus(String status) {
        if( !status.equals(this.status ) ) {
            this.status = status;
            addChange("status", this.status);
        }
    }

    public void setDataAquisicao(String dataAquisicao) {
        if( !dataAquisicao.equals(this.dataAquisicao ) ) {
            this.dataAquisicao = dataAquisicao;
            addChange("data_aquisicao", this.dataAquisicao);
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
        return " codigo_exemplar = " + codigoExemplar;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        codigoExemplar = (int) data.get(0);
        status = (String) data.get(1);
        if( data.get(2) != null ) {
            dataAquisicao = data.get(2).toString();
        }
        
        if( data.get(3) != null ) {
            if( livro == null ) {
                livro = new Livro();
            }           
            livro.setCodigoLivro((int) data.get(3) );
            livro.load();
        }
    }
    
    @Override
    public boolean equals(Object obj) {        
        if( obj instanceof Exemplar ) {
           Exemplar aux;
           aux = (Exemplar) obj;
            
           if( codigoExemplar == aux.getCodigoExemplar()) {
               return true;
           }             
        }        
        return false;
    }
        
}
