package com.example.pruebatecnica1.service;

import com.example.pruebatecnica1.model.Cliente;
import com.example.pruebatecnica1.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositorio clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }

    public Cliente encontrarPorEmailYNombres(String email , String nombres) {
        return clienteRepository.findByEmailAndNombres(email , nombres);
    }

    public List<Cliente> encontrarTodosPorApellidosYNombres(String email , String nombres) {
        return clienteRepository.findAllByApellidosAndNombres(email , nombres);
    }

    public Cliente update(Integer id, Cliente updateCliente) {
        if (updateCliente == null) {
            throw new NullPointerException("UpdateCliente object cannot be null");
        }
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente not found with id " + id));
        cliente.setNombres(updateCliente.getNombres());
        cliente.setApellidos(updateCliente.getApellidos());
        cliente.setEmail(updateCliente.getEmail());
        return clienteRepository.save(cliente);
    }
}

