package org.dh.c2023I.clinica.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IController<E> {
    ResponseEntity<List<E>> listarTodos();
}
