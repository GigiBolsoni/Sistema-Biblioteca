package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class Genero extends DataAccessObject {
     
    private int codigoGenero;
    private String nome;    

    public Genero() {
        super("generos");
    }

    
    public int getCodigoGenero() {
        return codigoGenero;
    }

    public String getNome() {
        return nome;
    }
              
    public void setCodigoGenero(int codigoGenero) {
        if( codigoGenero != this.codigoGenero ) {
            this.codigoGenero = codigoGenero;
            addChange("codigo_genero", this.codigoGenero);
        }
    }

    public void setNome(String nome) {
        if( !nome.equals(this.nome ) ) {
            this.nome = nome;
            addChange("nome", this.nome);
        }
    }
    
    @Override
    protected String getWhereClauseForOneEntry() {
        return " codigo_genero = " + codigoGenero;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        
        codigoGenero = (int) data.get(0);
        nome = (String) data.get(1); 
    }
    
    @Override
    public boolean equals(Object obj) {        
        if( obj instanceof Genero ) {
           
           Genero aux;
           aux = (Genero) obj;
            
           if( codigoGenero == aux.getCodigoGenero()) {
               return true;
           }             
        }        
        return false;
    }
        
}