package br.com.yurekesley.qualquercoisaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yurekesley.qualquercoisaapp.model.Cliente;
import br.com.yurekesley.qualquercoisaapp.repository.ClienteRepository;

@Service
public class ClienteService extends GenericService<Cliente, Long> {

	@Autowired
	private ClienteRepository repository;

	Cliente buscarPorNome(String nome) {
		return repository.buscarPorNome(nome);
	}
}
