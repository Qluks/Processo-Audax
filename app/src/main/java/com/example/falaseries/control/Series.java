package com.example.falaseries.control;


public class Series {
    private String descricao, titulo;

    public Series(String descricao, String titulo) {
        this.descricao = descricao;
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTitulo() {
        return titulo;
    }
}
