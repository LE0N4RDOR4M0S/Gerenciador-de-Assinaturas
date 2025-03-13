package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.model.Categoria;
import com.leonardoramos.assinaturas.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Classe de serviço para categorias
 */
@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    /**
     *  Busca uma categoria pelo id
     * @param id id da categoria em String
     * @return Categoria correspondente ao id
     * @throws IllegalArgumentException caso o id seja inválido
     */
    public Optional<Categoria> buscarPorId(String id){
        return categoriaRepository.findById(UUID.fromString(id));
    }

    /**
     * Busca todas as categorias
     * @return Lista de categorias
     */
    public List<Optional<Categoria>> buscarTodos(){
        return categoriaRepository.findAll()
                .stream().map(Optional::ofNullable).collect(Collectors.toList());
    }

    /**
     * Cria uma nova categoria
     * @param categoria categoria a ser criada
     * @return Categoria criada
     * @throws IllegalArgumentException caso a categoria seja inválida
     */
    public Optional<Categoria> criar(Categoria categoria){
        return Optional.of(categoriaRepository.save(categoria));
    }

    /**
     * Atualiza uma categoria
     * @param id id da categoria a ser atualizada
     * @param novaCategoria nova categoria
     * @return Categoria atualizada
     * @throws IllegalArgumentException caso a categoria seja inválida
     */
    public Optional<Categoria> atualizar(Categoria novaCategoria, String id){
        Categoria categoria = categoriaRepository.findById(UUID.fromString(id)).orElse(null);
        if (categoria == null) {
            categoria.setNome(novaCategoria.getNome());
            categoria.setDescricao(novaCategoria.getDescricao());
            categoriaRepository.save(categoria);
        }
        return Optional.of(categoria);
    }

    /**
     * Deleta uma categoria
     * @param id id da categoria a ser deletada
     */
    public void deletar(String id){
        categoriaRepository.deleteById(UUID.fromString(id));
    }
}
