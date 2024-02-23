package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class Emprestimo extends DataAccessObject {

    private int codigoEmprestimo;
    private String dataEmprestimo;
    private String dataDevolucaoPrevista;
    private String dataDevolucaoReal;
    private Usuario usuario;
    private Exemplar exemplar;

    public Emprestimo() {
        super("emprestimos");
    }

    public int getCodigoEmprestimo() {
        return codigoEmprestimo;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public String getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public String getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setCodigoEmprestimo(int codigoEmprestimo) {
        if (codigoEmprestimo != this.codigoEmprestimo) {
            this.codigoEmprestimo = codigoEmprestimo;
            addChange("codigo_emprestimo", this.codigoEmprestimo);
        }
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        if (!dataEmprestimo.equals(this.dataEmprestimo)) {
            this.dataEmprestimo = dataEmprestimo;
            addChange("data_emprestimo", this.dataEmprestimo);
        }
    }

    public void setDataDevolucaoPrevista(String dataDevolucaoPrevista) {
        if (!dataDevolucaoPrevista.equals(this.dataDevolucaoPrevista)) {
            this.dataDevolucaoPrevista = dataDevolucaoPrevista;
            addChange("data_devolucao_prevista", this.dataDevolucaoPrevista);
        }
    }

    public void setDataDevolucaoReal(String dataDevolucaoReal) {
        if (!dataDevolucaoReal.equals(this.dataDevolucaoReal)) {
            this.dataDevolucaoReal = dataDevolucaoReal;
            addChange("data_devolucao_real", this.dataDevolucaoReal);
        }
    }

    public void setUsuario(Usuario usuario) throws Exception {
        if (this.usuario == null) {
            if (usuario != null) {
                this.usuario = new Usuario();
                this.usuario.setCodigoUsuario(usuario.getCodigoUsuario());
                this.usuario.load();
                addChange("codigo_usuario", this.usuario.getCodigoUsuario());
            }
        } else {
            if (usuario == null) {
                this.usuario = null;
                addChange("codigo_usuario", null);
            } else {
                if (!this.usuario.equals(usuario)) {
                    this.usuario.setCodigoUsuario(usuario.getCodigoUsuario());
                    this.usuario.load();
                    addChange("codigo_usuario", this.usuario.getCodigoUsuario());
                }
            }
        }
    }

    public void setExemplar(Exemplar exemplar) throws Exception {
        if (this.exemplar == null) {
            if (exemplar != null) {
                this.exemplar = new Exemplar();
                this.exemplar.setCodigoExemplar(exemplar.getCodigoExemplar());
                this.exemplar.load();
                addChange("codigo_exemplar", this.exemplar.getCodigoExemplar());
            }
        } else {
            if (exemplar == null) {
                this.exemplar = null;
                addChange("codigo_exemplar", null);
            } else {
                if (!this.exemplar.equals(exemplar)) {
                    this.exemplar.setCodigoExemplar(exemplar.getCodigoExemplar());
                    this.exemplar.load();
                    addChange("codigo_exemplar", this.exemplar.getCodigoExemplar());
                }
            }
        }
    }

    @Override
    protected String getWhereClauseForOneEntry() {
        return " codigo_emprestimo = " + codigoEmprestimo;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        codigoEmprestimo = (int) data.get(0);
        
        if( data.get(1) != null ) {
            dataEmprestimo = data.get(1).toString();
        }
        if( data.get(2) != null ) {
            dataDevolucaoPrevista = data.get(2).toString();
        }
        if( data.get(3) != null ) {
            dataDevolucaoReal = data.get(3).toString();
        }

        if (data.get(4) != null) {
            if (usuario == null) {
                usuario = new Usuario();
            }
            usuario.setCodigoUsuario((int) data.get(4));
            usuario.load();
        }

        if (data.get(5) != null) {
            if (exemplar == null) {
                exemplar = new Exemplar();
            }
            exemplar.setCodigoExemplar((int) data.get(5));
            exemplar.load();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Emprestimo) {
            Emprestimo aux = (Emprestimo) obj;
            if (codigoEmprestimo == aux.getCodigoEmprestimo()) {
                return true;
            }
        }
        return false;
    }
}
