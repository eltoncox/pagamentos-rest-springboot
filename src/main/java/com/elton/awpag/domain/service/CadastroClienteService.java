package com.elton.awpag.domain.service;

import com.elton.awpag.domain.model.Cliente;
import com.elton.awpag.domain.repository.ClienteRepository;
import com.elton.awpag.domain.exception.NegocioException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CadastroClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente buscar(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NegocioException("Cliente não encontrado"));
    }


    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .filter(c -> !c.equals(cliente))
                .isPresent();

        if (emailEmUso) {
            throw new NegocioException("Já existe um cliente cadastrado com este e-mail");
        }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }

}