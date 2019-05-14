package br.com.yurekesley.qualquercoisaapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.yurekesley.qualquercoisaapp.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends GenericController<Cliente, Long>{

}
