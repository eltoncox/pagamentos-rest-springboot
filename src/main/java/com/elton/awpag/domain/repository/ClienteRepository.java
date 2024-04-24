package com.elton.awpag.domain.repository;

import com.elton.awpag.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

     // List<Cliente> findByNomeContainingIgnoreCase(String nome)
     List<Cliente> findByNome(String nome);
     Optional<Cliente> findByEmail(String email);

}
