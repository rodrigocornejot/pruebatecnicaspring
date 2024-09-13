package com.example.pruebatecnica1.controller;

import com.example.pruebatecnica1.model.Cliente;
import com.example.pruebatecnica1.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")

public class ClienteControllador {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/nombres/{nombres}/apellidos/{apellidos}")
    public List<Cliente> encontrarClientes(@PathVariable String nombres,@PathVariable String apellidos) { return clienteService.encontrarTodosPorApellidosYNombres(nombres,apellidos);}

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Integer id, @RequestBody Cliente updateCliente) {
        if (updateCliente != null) {
            Cliente cliente = clienteService.update(id, updateCliente);
            if (cliente != null) {
                return ResponseEntity.ok(cliente);
            } else {
                return ResponseEntity.noContent().build();
            }
        }
        return null;
    }
}
