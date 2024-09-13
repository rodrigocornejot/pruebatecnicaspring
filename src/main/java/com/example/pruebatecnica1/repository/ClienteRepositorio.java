package com.example.pruebatecnica1.repository;

import com.example.pruebatecnica1.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ClienteRepositorio extends JpaRepository<Cliente, Integer> {
    List<Cliente> findAllByApellidosAndNombres(String apellidos , String nombres);
    Cliente findByEmailAndNombres(String email , String nombres);

    @Query("SELECT c FROM Cliente c where c.email=?1 and c.nombres=?2 ")
    Cliente buscarCliente(String email , String nombres);
}
