package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.dtos.Categoria.CategoriaRequestDTO;
import com.leonardoramos.assinaturas.dtos.Categoria.CategoriaResponseDTO;
import com.leonardoramos.assinaturas.model.Categoria;
import com.leonardoramos.assinaturas.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public CategoriaResponseDTO buscarPorId(String id){
        return CategoriaResponseDTO.fromModel(Objects.requireNonNull(categoriaRepository.findById(UUID.fromString(id)).orElse(null)));
    }

    /**
     * Busca todas as categorias
     * @return Lista de categorias
     */
    public List<CategoriaResponseDTO> buscarTodos(){
        return CategoriaResponseDTO.fromModel(categoriaRepository.findAll());
    }

    /**
     * Cria uma nova categoria
     * @param categoriaDTO categoria a ser criada
     * @return Categoria criada
     * @throws IllegalArgumentException caso a categoria seja inválida
     */
    public CategoriaResponseDTO criar(CategoriaRequestDTO categoriaDTO){
        Categoria categoria = categoriaDTO.toModel();
        return CategoriaResponseDTO.fromModel(categoriaRepository.save(categoria));
    }

    /**
     * Atualiza uma categoria
     * @param id id da categoria a ser atualizada
     * @param novaCategoria nova categoria
     * @return Categoria atualizada
     * @throws IllegalArgumentException caso a categoria seja inválida
     */
    public CategoriaResponseDTO atualizar(CategoriaRequestDTO novaCategoria, String id){
        Categoria categoria = categoriaRepository.findById(UUID.fromString(id)).orElse(null);
        if (categoria == null) {
            categoria.setNome(novaCategoria.getNome());
            categoria.setDescricao(novaCategoria.getDescricao());
            categoriaRepository.save(categoria);
        }
        return CategoriaResponseDTO.fromModel(categoria);
    }

    /**
     * Deleta uma categoria
     * @param id id da categoria a ser deletada
     */
    public void deletar(String id){
        categoriaRepository.deleteById(UUID.fromString(id));
    }
}
