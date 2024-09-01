package com.blibioteca.fuctura.controller;

import com.blibioteca.fuctura.dtos.CategoriaDTO;
import com.blibioteca.fuctura.models.Categoria;
import com.blibioteca.fuctura.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    public ResponseEntity<CategoriaDTO> save(@RequestBody CategoriaDTO categoriaDTO){
        Categoria cat = categoriaService.save(categoriaDTO);
        return ResponseEntity.ok().body(modelMapper.map(cat,CategoriaDTO.class));
    }


    @GetMapping
    public ResponseEntity<List<CategoriaDTO>>findAll(Integer id){

        List<Categoria> categorialist = categoriaService.findAll();
        return ResponseEntity.ok().body(
                categorialist.stream().map(obj -> modelMapper.map(
                        obj,CategoriaDTO.class)).collect(Collectors.toList()));

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO>findById(@PathVariable Integer id){
        Categoria categoria = categoriaService.findById(id);
        CategoriaDTO categoriaDTO = modelMapper.map(categoria,CategoriaDTO.class);
        return ResponseEntity.ok().body(categoriaDTO);

    }


    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO){
        categoriaDTO.setId(id);
        Categoria cat = categoriaService.update(categoriaDTO);
        return ResponseEntity.ok().body(modelMapper.map(cat,CategoriaDTO.class));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deleteItem(@PathVariable Integer id){
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
