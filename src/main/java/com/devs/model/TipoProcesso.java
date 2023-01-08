package com.devs.model;

public class TipoProcesso {
    private int id;
    private String nome;

    public TipoProcesso() {

    }

    public TipoProcesso(int id, String nome) {

        this(nome);
        this.id = id;
    }
    public TipoProcesso(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "TipoProcesso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
