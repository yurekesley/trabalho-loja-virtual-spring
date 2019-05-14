package br.com.yurekesley.qualquercoisaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.yurekesley.qualquercoisaapp.service.IGenericService;

@CrossOrigin
public abstract class GenericController<T, ID> implements IGenericController<T, ID> {

	@Autowired
	private IGenericService<T, ID> service;

	@GetMapping
	@Override
	@CrossOrigin
	@ResponseStatus(HttpStatus.OK)
	public List<T> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/{id}")
	@CrossOrigin
	@Override
	@ResponseStatus(HttpStatus.OK)
	public T findById(@PathVariable ID id) {
		return this.service.findById(id);
	}

	@Override
	@CrossOrigin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteById(@PathVariable ID id) {
		this.service.deleteById(id);
	}

	@Override
	@PostMapping
	@CrossOrigin
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody T t) {
		this.service.save(t);
	}

	@Override
	@CrossOrigin
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody T t) {
		this.service.update(t);
	}

}