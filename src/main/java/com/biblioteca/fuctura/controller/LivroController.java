package com.biblioteca.fuctura.controller;


import com.biblioteca.fuctura.dtos.LivroDTO;
import com.biblioteca.fuctura.models.Livro;
import com.biblioteca.fuctura.services.LivroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;
    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> findById(@PathVariable Integer id){
        Livro livro = livroService.findById(id);
        LivroDTO livroDTO = modelMapper.map(livro,LivroDTO.class);
        return ResponseEntity.ok().body(livroDTO);
    }

    @GetMapping
    //http://localhost:8080/livro?categoria=2
    public ResponseEntity<List<LivroDTO>> findAllByCategoria(@RequestParam(value = "categoria",defaultValue = "0") Integer id_cat){
        List<Livro> livroList =  livroService.findAllByIdCategoria(id_cat);
        return  ResponseEntity.ok().body(livroList.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList()));

    }

    @GetMapping("/all")
    //http://localhost:8080/livro
    public ResponseEntity<List<LivroDTO>> findAll(){
        List<Livro> livroList =  livroService.findAll();
        return  ResponseEntity.ok().body(livroList.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList()));

    }

    @GetMapping("/categoria/{nome}")
    public ResponseEntity<List<LivroDTO>> findByCategoriaNome(@PathVariable String nome){
        List<Livro> livroList =  livroService.findByCategoriaNome(nome);
        return  ResponseEntity.ok().body(livroList.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList()));

    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> updateLivro(@PathVariable Integer id, @RequestBody LivroDTO livroDTO){
        livroDTO.setId(id);
        Livro livro = livroService.update(livroDTO);
        LivroDTO livroDTOAtualizado = new LivroDTO(livro);
        return ResponseEntity.ok().body(livroDTOAtualizado);

    }
}
