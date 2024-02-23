package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class Multa extends DataAccessObject {
       
    private int codigoMulta;
    private float valor;
    private String dataPagamento;
    private String status;
    private Usuario usuario;
    private Emprestimo emprestimo;

    public Multa() {
        super("multas");
    }

    public int getCodigoMulta() {
        return codigoMulta;
    }

    public float getValor() {
        return valor;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public String getStatus() {
        return status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setCodigoMulta(int codigoMulta) {
        if (codigoMulta != this.codigoMulta) {
            this.codigoMulta = codigoMulta;
            addChange("codigo_multa", this.codigoMulta);
        }
    }

    public void setValor(float valor) {
        if (valor != this.valor) {
            this.valor = valor;
            addChange("valor", this.valor);
        }
    }

    public void setDataPagamento(String dataPagamento) {
        if (!dataPagamento.equals(this.dataPagamento)) {
            this.dataPagamento = dataPagamento;
            addChange("data_pagamento", this.dataPagamento);
        }
    }

    public void setStatus(String status) {
        if (!status.equals(this.status)) {
            this.status = status;
            addChange("status", this.status);
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

    public void setEmprestimo(Emprestimo emprestimo) throws Exception {
        if (this.emprestimo == null) {
            if (emprestimo != null) {
                this.emprestimo = new Emprestimo();
                this.emprestimo.setCodigoEmprestimo(emprestimo.getCodigoEmprestimo());
                this.emprestimo.load();
                addChange("codigo_emprestimo", this.emprestimo.getCodigoEmprestimo());
            }
        } else {
            if (emprestimo == null) {
                this.emprestimo = null;
                addChange("codigo_emprestimo", null);
            } else {
                if (!this.emprestimo.equals(emprestimo)) {
                    this.emprestimo.setCodigoEmprestimo(emprestimo.getCodigoEmprestimo());
                    this.emprestimo.load();
                    addChange("codigo_emprestimo", this.emprestimo.getCodigoEmprestimo());
                }
            }
        }
    }

    @Override
    protected String getWhereClauseForOneEntry() {
        return " codigo_multa = " + codigoMulta;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        codigoMulta = (int) data.get(0);
        valor = (float) data.get(1);
        
        if( data.get(2) != null ) {
            dataPagamento = data.get(2).toString();
        }
        
        status = (String) data.get(3);

        if (data.get(4) != null) {
            if (usuario == null) {
                usuario = new Usuario();
            }
            usuario.setCodigoUsuario((int) data.get(4));
            usuario.load();
        }

        if (data.get(5) != null) {
            if (emprestimo == null) {
                emprestimo = new Emprestimo();
            }
            emprestimo.setCodigoEmprestimo((int) data.get(5));
            emprestimo.load();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Multa) {
            Multa aux = (Multa) obj;
            if (codigoMulta == aux.getCodigoMulta()) {
                return true;
            }
        }
        return false;
    }
}
