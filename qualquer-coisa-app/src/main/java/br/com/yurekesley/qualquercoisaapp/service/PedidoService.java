package br.com.yurekesley.qualquercoisaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yurekesley.qualquercoisaapp.model.Item;
import br.com.yurekesley.qualquercoisaapp.model.Pedido;

@Service
public class PedidoService extends GenericService<Pedido, Long> {
		
	@Autowired
	private EstoqueService estoqueService;
	
	@Override
	public void save(Pedido pedido) {
				
		for (Item item : pedido.getItens()) {
				item.getProduto()
		}
		
		// this.repository.save(t);
	}
	
	
}
