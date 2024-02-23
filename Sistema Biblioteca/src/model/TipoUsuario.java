package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class TipoUsuario extends DataAccessObject {
    
    private int codigoTipo;
    private String nome;
    private String moduloAdministrativo;
    private String moduloAtendimento;

    public TipoUsuario() {
        super("tipo_usuario");
    }    

    public int getCodigoTipo() {
        return codigoTipo;
    }

    public String getNome() {
        return nome;
    }   

    public String getModuloAdministrativo() {
        return moduloAdministrativo;
    }

    public String getModuloAtendimento() {
        return moduloAtendimento;
    }

    public void setCodigoTipo(int codigoTipo) {
        if( codigoTipo != this.codigoTipo ) {
            this.codigoTipo = codigoTipo;
            addChange("codigo_tipo", this.codigoTipo);
        }
    }

    public void setNome(String nome) {
        if( !nome.equals( this.nome ) ) {
            this.nome = nome;
            addChange("nome", this.nome);
        }
    }  

    public void setModuloAdministrativo(String moduloAdministrativo) {
        if( !moduloAdministrativo.equals( this.moduloAdministrativo ) ) {
            this.moduloAdministrativo = moduloAdministrativo;
            addChange("modulo_administrativo", this.moduloAdministrativo);
        }
    }

    public void setModuloAtendimento(String moduloAtendimento) {
        if( !moduloAtendimento.equals( this.moduloAtendimento ) ) {
            this.moduloAtendimento = moduloAtendimento;
            addChange("modulo_atendimento", this.moduloAtendimento);
        }
    }

    @Override
    protected String getWhereClauseForOneEntry() {
        return " codigo_tipo = " + codigoTipo;
    }

    @Override
    protected void fill(ArrayList<Object> data) {
        codigoTipo = (int) data.get(0);
        nome = (String) data.get(1);
        moduloAdministrativo = (String) data.get(2);
        moduloAtendimento = (String) data.get(3);
    }

    @Override
    public boolean equals(Object obj) {        
        if( obj instanceof TipoUsuario ) {
           
           TipoUsuario aux;
           aux = (TipoUsuario) obj;
            
           if( codigoTipo == aux.getCodigoTipo() ) {
               return true;
           }             
        }        
        return false;
    }
    
}