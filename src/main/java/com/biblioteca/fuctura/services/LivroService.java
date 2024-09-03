package com.biblioteca.fuctura.services;

import com.biblioteca.fuctura.axceptions.ObjectNotFoundException;
import com.biblioteca.fuctura.dtos.LivroDTO;
import com.biblioteca.fuctura.models.Livro;
import com.biblioteca.fuctura.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private CategoriaService categoriaService;



    public Livro findById(Integer id) {
        Optional<Livro> livro =  livroRepository.findById(id);

        if (livro.isPresent()){

            return livro.get();
        }
        throw new ObjectNotFoundException("Livro não encontrado!");
    }

    public List<Livro> findAllByIdCategoria(Integer id_cat) {
        categoriaService.findById(id_cat);
        return livroRepository.findAllLivrosByCategoria(id_cat);
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public List<Livro> findByCategoriaNome(String nome){
        categoriaService.buscarPorNome(nome);
        return livroRepository.findByCategoriaNomeContainingIgnoreCase(nome);
    }

    public Livro update(LivroDTO livroDTO) {
        findById(livroDTO.getId());
        Livro livro = new Livro(livroDTO);
        return livroRepository.save(livro);
    }
}
