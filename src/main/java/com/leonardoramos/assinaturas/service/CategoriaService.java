package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.model.Categoria;
import com.leonardoramos.assinaturas.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public Optional<Categoria> buscarPorId(String id){
        return categoriaRepository.findById(UUID.fromString(id));
    }

    public List<Optional<Categoria>> buscarTodos(){
        return categoriaRepository.findAll()
                .stream().map(Optional::ofNullable).collect(Collectors.toList());
    }

    public Optional<Categoria> criar(Categoria categoria){
        return Optional.of(categoriaRepository.save(categoria));
    }

    public Optional<Categoria> atualizar(Categoria novaCategoria, String id){
        Categoria categoria = categoriaRepository.findById(UUID.fromString(id)).orElse(null);
        if (categoria == null) {
            categoria.setNome(novaCategoria.getNome());
            categoria.setDescricao(novaCategoria.getDescricao());
            categoriaRepository.save(categoria);
        }
        return Optional.of(categoria);
    }

    public void deletar(String id){
        categoriaRepository.deleteById(UUID.fromString(id));
    }
}
