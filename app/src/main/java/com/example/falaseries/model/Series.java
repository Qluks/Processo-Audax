package com.example.falaseries.model;

import java.io.Serializable;
import java.util.Arrays;

public class Series implements Serializable {
    private static final long serialVersionUID = 1L;

    public long id;
    public String Titulo;
    public String Descricao;
    public byte[] imagem;

    @Override
    public String toString() {
        return "Series{" +
                "id=" + id +
                ", Titulo='" + Titulo + '\'' +
                ", Descricao='" + Descricao + '\'' +
                ", imagem=" + Arrays.toString(imagem) +
                '}';
    }
}
