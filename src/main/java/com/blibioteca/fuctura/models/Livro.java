package com.blibioteca.fuctura.models;
import com.blibioteca.fuctura.dtos.LivroDTO;
import com.blibioteca.fuctura.enuns.Tamanho;

import javax.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String titulo;
    private String autor;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    private Tamanho tamanho;

    public Livro() {
    }

    public Livro(LivroDTO livroDTO) {
        this.id = livroDTO.getId();
        this.tamanho = livroDTO.getTamanho();
        this.categoria = livroDTO.getCategoria();
        this.descricao = livroDTO.getDescricao();
        this.autor = livroDTO.getAutor();
        this.titulo = livroDTO.getTitulo();
    }

    public Livro(Integer id, String titulo, String autor, String descricao, Tamanho tamanho, Categoria categoria) {
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

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", categoria=" + categoria +
                ", tamanho=" + tamanho +
                '}';
    }
}
