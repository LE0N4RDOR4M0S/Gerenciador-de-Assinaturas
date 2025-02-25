package com.leonardoramos.assinaturas.controller;

import com.leonardoramos.assinaturas.model.Categoria;
import com.leonardoramos.assinaturas.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping
    private List<Optional<Categoria>> buscarTodos(){
        return categoriaService.buscarTodos();
    }

    @GetMapping("/{id")
    private Optional<Categoria> buscarPorId(@PathVariable(name = "id") String id){
        return categoriaService.buscarPorId(id);
    }

    @PostMapping
    private Optional<Categoria> criar(Categoria categoria){
        return categoriaService.criar(categoria);
    }

    @PostMapping("{id}")
    private Optional<Categoria> atualizar(Categoria categoria,@PathVariable(name = "id") String id){
        return categoriaService.atualizar(categoria, id);
    }

    @GetMapping("/{id}/deletar")
    private void deletar(@PathVariable(name = "id") String id){
        categoriaService.deletar(id);
    }

}
