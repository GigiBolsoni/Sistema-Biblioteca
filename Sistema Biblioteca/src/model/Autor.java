package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class Autor extends DataAccessObject {
      
    private int codigoAutor;
    private String nomeCompleto;    
    private String dataNascimento;
    private String biografia;
    private String nacionalidade;

    public Autor() {
        super("autores");
    }
    
    public int getCodigoAutor() {
        return codigoAutor;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
    
    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }
        
    public void setCodigoAutor(int codigoAutor) {
        if( codigoAutor != this.codigoAutor ) {
            this.codigoAutor = codigoAutor;
            addChange("codigo_autor", this.codigoAutor);
        }
    }

    public void setNomeCompleto(String nomeCompleto) {
        if( !nomeCompleto.equals( this.nomeCompleto ) ) {
            this.nomeCompleto = nomeCompleto;
            addChange("nome_completo", this.nomeCompleto);
        }
    }

    public void setDataNascimento(String dataNascimento) {
        if( !dataNascimento.equals( this.dataNascimento ) ) {
            this.dataNascimento = dataNascimento;
            addChange("data_nascimento", this.dataNascimento);
        }
    }

    public void setBiografia(String biografia) {
        if( !biografia.equals( this.biografia ) ) {
            this.biografia = biografia;
            addChange("biografia", this.biografia);
        }
    }

    public void setNacionalidade(String nacionalidade) {
        if( !nacionalidade.equals( this.nacionalidade ) ) {
            this.nacionalidade = nacionalidade;
            addChange("nacionalidade", this.nacionalidade);
        }
    }
       
    @Override
    protected String getWhereClauseForOneEntry() {
        return " codigo_autor = " + codigoAutor;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        
        codigoAutor = (int) data.get(0);
        nomeCompleto = (String) data.get(1);
        
        if( data.get(2) != null ) {
            dataNascimento = data.get(2).toString();
        }
        
        biografia = (String) data.get(3);
        nacionalidade = (String) data.get(4);
    }
    
    @Override
    public boolean equals(Object obj) {        
        if( obj instanceof Autor ) {
           
           Autor aux;
           aux = (Autor) obj;
            
           if( codigoAutor == aux.getCodigoAutor()) {
               return true;
           }             
        }        
        return false;
    }
        
}