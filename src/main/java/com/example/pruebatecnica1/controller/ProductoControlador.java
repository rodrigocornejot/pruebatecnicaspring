package com.example.pruebatecnica1.controller;

import com.example.pruebatecnica1.model.Producto;
import com.example.pruebatecnica1.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/productos")
public class ProductoControlador {
    private final ProductoService productoService;

    @GetMapping
    public List<Producto> findAll() {
        return productoService.findAll();
    }

    @PostMapping
    public Producto save(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @DeleteMapping("/{id}")
    public void delete(Integer id) {
        productoService.delete(id);
    }
}
