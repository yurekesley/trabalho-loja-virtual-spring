package br.com.yurekesley.qualquercoisaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.yurekesley.qualquercoisaapp.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("select c from Cliente c where c.nome = :nome")
	Cliente buscarPorNome(@Param("nome") String nome);

}
