package br.com.yurekesley.qualquercoisaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.yurekesley.qualquercoisaapp.model.Pedido;
import br.com.yurekesley.qualquercoisaapp.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController extends GenericController<Pedido, Long> {
	
	@Autowired 
	private PedidoService service;
	
	@Override
	@PostMapping
	@CrossOrigin
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Pedido pedido) {
		this.service.save(pedido);
	}

}
