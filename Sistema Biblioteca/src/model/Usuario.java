package model;

import controller.DataAccessObject;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

public class Usuario extends DataAccessObject {
       
    private int codigoUsuario;
    private String nomeCompleto;    
    private String dataNascimento;
    private String numeroCpf;
    private String email;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String celular;
    private String dataCadastro;   
    private String senhaAcesso;
    private TipoUsuario tipoUsuario;  

    public Usuario() {
        super("usuarios");
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
    
    public String getDataNascimento() {
        return dataNascimento;
    }
    
    public String getNumeroCpf() {
        return numeroCpf;
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

    public String getCelular() {
        return celular;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }
    
    public String getSenhaAcesso() {
        return senhaAcesso;
    }
    
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
    
    private String getSenhaHash(String senhaAcesso) {
        String senhaHash = "";
        try {            
            MessageDigest md = MessageDigest.getInstance( "SHA-256" );            
            senhaAcesso += String.valueOf( getCodigoUsuario() ); // Técnica de Proteção de Morris-Thompson (Sal n-bits)            
            senhaHash = new BigInteger( 1, md.digest( senhaAcesso.getBytes("UTF-8") ) ).toString(16);       
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }               
        return senhaHash;
    }
              
    public void setCodigoUsuario(int codigoUsuario) {
        if( codigoUsuario != this.codigoUsuario ) {
            this.codigoUsuario = codigoUsuario;
            addChange("codigo_usuario", this.codigoUsuario);
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

    public void setNumeroCpf(String numeroCpf) {
        if( !numeroCpf.equals( this.numeroCpf ) ) {
            this.numeroCpf = numeroCpf;
            addChange("numero_cpf", this.numeroCpf);
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

    public void setCelular(String celular) {
        if( !celular.equals( this.celular ) ) {
            this.celular = celular;
            addChange("celular", this.celular);
        }
    }
    
    public void setDataCadastro(String dataCadastro) {
        if( !dataCadastro.equals( this.dataCadastro ) ) {
            this.dataCadastro = dataCadastro;
            addChange("data_cadastro", this.dataCadastro);
        }
    }

    public void setSenhaAcesso(String senhaAcesso) {
        if( !senhaAcesso.equals( this.senhaAcesso ) ) {
            this.senhaAcesso = getSenhaHash( senhaAcesso );
            addChange("senha_acesso", this.senhaAcesso);
        }
    }
    
    public void setTipoUsuario(TipoUsuario tipoUsuario) throws Exception {
        
        if( this.tipoUsuario  == null ) {
            
            if( tipoUsuario != null ) {
                
                this.tipoUsuario = new TipoUsuario();
                this.tipoUsuario.setCodigoTipo( tipoUsuario.getCodigoTipo() );
                this.tipoUsuario.load();
                addChange( "codigo_tipo_usuario", this.tipoUsuario.getCodigoTipo() );
                
            }
            
        } else {
            
            if( tipoUsuario == null ) {
                
                this.tipoUsuario = null;
                addChange( "codigo_tipo_usuario", null );
                
            } else {
                
                if( !this.tipoUsuario.equals( tipoUsuario ) ) {
                    
                    this.tipoUsuario.setCodigoTipo( tipoUsuario.getCodigoTipo() );
                    this.tipoUsuario.load();
                    addChange( "codigo_tipo_usuario", this.tipoUsuario.getCodigoTipo() );
                    
                }
                
            }
        }
        
    }
       
    @Override
    protected String getWhereClauseForOneEntry() {
        return " codigo_usuario = " + codigoUsuario;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        
        codigoUsuario = (int) data.get(0);
        nomeCompleto = (String) data.get(1);
        
        if( data.get(2) != null ) {
            dataNascimento = data.get(2).toString();
        }
        
        numeroCpf = (String) data.get(3);
        email = (String) data.get(4);
        endereco = (String) data.get(5);
        numero = (String) data.get(6);
        complemento = (String) data.get(7);
        bairro = (String) data.get(8);
        cidade = (String) data.get(9);
        estado = (String) data.get(10);
        celular = (String) data.get(11);      
        
        if( data.get(12) != null ) {
            dataCadastro = data.get(12).toString();
        }
        
        senhaAcesso = (String) data.get(13);
        
        if( data.get(14) != null ) {
            
            if( tipoUsuario == null ) {
                tipoUsuario = new TipoUsuario();
            }           
            
            tipoUsuario.setCodigoTipo( (int) data.get(14) );
            tipoUsuario.load();
        }

    }
    
    @Override
    public boolean equals(Object obj) {        
        if( obj instanceof Usuario ) {
           
           Usuario aux;
           aux = (Usuario) obj;
            
           if( codigoUsuario == aux.getCodigoUsuario()) {
               return true;
           }             
        }        
        return false;
    }
        
}