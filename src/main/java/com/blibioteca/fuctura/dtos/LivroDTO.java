package com.blibioteca.fuctura.dtos;

import com.blibioteca.fuctura.enuns.Tamanho;
import com.blibioteca.fuctura.models.Categoria;
import com.blibioteca.fuctura.models.Livro;

import javax.persistence.*;

public class LivroDTO {

    private Integer id;
    private String titulo;
    private String autor;
    private String descricao;
    private Categoria categoria;
    private Tamanho tamanho;
    private Livro livro;

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.descricao = livro.getDescricao();
        this.categoria = livro.getCategoria();
        this.tamanho = livro.getTamanho();

    }

    public LivroDTO() {
    }

    public LivroDTO(Integer id, String titulo, String autor, String descricao, Categoria categoria, Tamanho tamanho) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.descricao = descricao;
        this.categoria = categoria;
        this.tamanho = tamanho;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }
}
