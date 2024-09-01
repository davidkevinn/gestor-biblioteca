package com.blibioteca.fuctura.services;


import com.blibioteca.fuctura.axceptions.DataIntegriyuViolationException;
import com.blibioteca.fuctura.axceptions.IllegalArgumentExcepetion;
import com.blibioteca.fuctura.axceptions.ObjectNotFoundException;
import com.blibioteca.fuctura.dtos.CategoriaDTO;
import com.blibioteca.fuctura.models.Categoria;
import com.blibioteca.fuctura.repositories.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Categoria> findAll(){
        List<Categoria> categoriaList =  categoriaRepository.findAll();
        return categoriaList;
    }


    public Categoria findById(Integer id){
        Optional<Categoria> cat =  categoriaRepository.findById(id);
        if (cat.isPresent()){
            return cat.get();
        }
        throw new ObjectNotFoundException("Categoria não encontrada!");
    }


    public void delete(Categoria categoria) {
        categoriaRepository.delete(categoria);

    }



    public Categoria save(CategoriaDTO categoriaDTO) {
        findBynome(categoriaDTO);
        return categoriaRepository.save(modelMapper.map(categoriaDTO,Categoria.class));
    }

    public void deleteById(Integer id){
        findById(id);
        Optional<Categoria> cat = categoriaRepository.findById(id);
        if (!cat.get().getLivros().isEmpty()){

            throw new DataIntegriyuViolationException("Categoria possui livro não pode ser deletada.");
        }
        categoriaRepository.deleteById(id);
    }

    public Categoria update(CategoriaDTO categoriaDTO) {
        return categoriaRepository.save(modelMapper.map(categoriaDTO,Categoria.class));
    }

    private void findBynome(CategoriaDTO categoriaDTO){
        Optional<Categoria> cat = categoriaRepository.findByNome(categoriaDTO.getNome());

        if (cat.isPresent() && cat.get().getNome().equalsIgnoreCase(categoriaDTO.getNome())){
            throw new IllegalArgumentExcepetion("Já existe uma categoria com esse nome. "+categoriaDTO.getNome());
        }
    }

    public void buscarPorNome(String nome){
        Optional<Categoria> cat = categoriaRepository.findByNomeContainingIgnoreCase(nome);
        if(cat.isEmpty()){
            throw new ObjectNotFoundException("Categória não encontrada.");
        }

    }

}
