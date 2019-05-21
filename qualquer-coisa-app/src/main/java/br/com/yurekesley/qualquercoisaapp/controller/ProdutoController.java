package br.com.yurekesley.qualquercoisaapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.yurekesley.qualquercoisaapp.model.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController extends GenericController<Produto, Long> {

}
