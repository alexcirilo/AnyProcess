package com.devs.model;

import java.util.Date;

public class Processo {

    private int id;
    private int numero_processo;
    private Date data_entrada;
    private float valor_recurso;
    private String objetivo;
    private TipoProcesso tipoProcesso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_processo() {
        return numero_processo;
    }

    public void setNumero_processo(int numero_processo) {
        this.numero_processo = numero_processo;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public float getValor_recurso() {
        return valor_recurso;
    }

    public void setValor_recurso(float valor_recurso) {
        this.valor_recurso = valor_recurso;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public TipoProcesso getTipoProcesso() {
        return tipoProcesso;
    }

    public void setTipoProcesso(TipoProcesso tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }
}
