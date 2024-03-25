package com.senai.tutoria.services;

import java.util.List;

public interface GenericService<T> {
    T criar(T entity);
    List<T> buscarTodos();

    T buscarPorId(Long id);

    T alterar(Long id, T entity);

    void excluir(Long id);
}
