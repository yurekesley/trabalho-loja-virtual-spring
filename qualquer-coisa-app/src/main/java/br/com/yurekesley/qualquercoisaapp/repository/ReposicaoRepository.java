package br.com.yurekesley.qualquercoisaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.yurekesley.qualquercoisaapp.model.Reposicao;

@Repository
public interface ReposicaoRepository extends JpaRepository<Reposicao, Long> {

}
