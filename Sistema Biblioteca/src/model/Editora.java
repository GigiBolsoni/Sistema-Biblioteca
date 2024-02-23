package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class Editora extends DataAccessObject {
     
    private int codigoEditora;
    private String nome;    
    private String cnpj;
    private String email;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;
    private String website;
    private String fundacao;


    public Editora() {
        super("editoras");
    }

    public int getCodigoEditora() {
        return codigoEditora;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }
    
    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getWebsite() {
        return website;
    }

    public String getFundacao() {
        return fundacao;
    }
              
    public void setCodigoEditora(int codigoEditora) {
        if( codigoEditora != this.codigoEditora ) {
            this.codigoEditora = codigoEditora;
            addChange("codigo_editora", this.codigoEditora);
        }
    }

    public void setNome(String nome) {
        if( !nome.equals(this.nome ) ) {
            this.nome = nome;
            addChange("nome", this.nome);
        }
    }

    public void setCnpj(String cnpj) {
        if( !cnpj.equals(this.cnpj ) ) {
            this.cnpj = cnpj;
            addChange("cnpj", this.cnpj);
        }
    }
    
    public void setEmail(String email) {
        if( !email.equals( this.email ) ) {
            this.email = email;
            addChange("email", this.email);
        }
    }

    public void setEndereco(String endereco) {
        if( !endereco.equals( this.endereco ) ) {
            this.endereco = endereco;
            addChange("endereco", this.endereco);
        }
    }

    public void setNumero(String numero) {
        if( !numero.equals( this.numero ) ) {
            this.numero = numero;
            addChange("numero", this.numero);
        }
    }

    public void setComplemento(String complemento) {
        if( !complemento.equals( this.complemento ) ) {
            this.complemento = complemento;
            addChange("complemento", this.complemento);
        }
    }

    public void setBairro(String bairro) {
        if( !bairro.equals( this.bairro ) ) {
            this.bairro = bairro;
            addChange("bairro", this.bairro);
        }
    }

    public void setCidade(String cidade) {
        if( !cidade.equals( this.cidade ) ) {
            this.cidade = cidade;
            addChange("cidade", this.cidade);
        }
    }

    public void setEstado(String estado) {
        if( !estado.equals( this.estado ) ) {
            this.estado = estado;
            addChange("estado", this.estado);
        }
    }

    public void setTelefone(String telefone) {
        if( !telefone.equals(this.telefone ) ) {
            this.telefone = telefone;
            addChange("telefone", this.telefone);
        }
    }

    public void setWebsite(String website) {
        if( !website.equals(this.website ) ) {
            this.website = website;
            addChange("website", this.website);
        }
    }

    public void setFundacao(String fundacao) {
        if( !fundacao.equals(this.fundacao ) ) {
            this.fundacao = fundacao;
            addChange("fundacao", this.fundacao);
        }
    }
    
    @Override
    protected String getWhereClauseForOneEntry() {
        return " codigo_editora = " + codigoEditora;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        
        codigoEditora = (int) data.get(0);
        nome = (String) data.get(1);
        cnpj = (String) data.get(2);
        email = (String) data.get(3);
        endereco = (String) data.get(4);
        numero = (String) data.get(5);
        complemento = (String) data.get(6);
        bairro = (String) data.get(7);
        cidade = (String) data.get(8);
        estado = (String) data.get(9);
        telefone = (String) data.get(10);      
        website = (String) data.get(11);
        fundacao = (String) data.get(12); 
    }
    
    @Override
    public boolean equals(Object obj) {        
        if( obj instanceof Editora ) {
           
           Editora aux;
           aux = (Editora) obj;
            
           if( codigoEditora == aux.getCodigoEditora()) {
               return true;
           }             
        }        
        return false;
    }
        
}