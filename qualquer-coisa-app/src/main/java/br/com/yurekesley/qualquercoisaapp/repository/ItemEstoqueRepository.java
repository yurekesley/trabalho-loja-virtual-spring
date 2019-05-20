package br.com.yurekesley.qualquercoisaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.yurekesley.qualquercoisaapp.model.Estoque;
import br.com.yurekesley.qualquercoisaapp.model.ItemEstoque;
import br.com.yurekesley.qualquercoisaapp.model.Produto;

@Repository
public interface ItemEstoqueRepository extends JpaRepository<ItemEstoque, Long> {

	Integer countByEstoqueAndProduto(Estoque estoque, Produto produto);

}
