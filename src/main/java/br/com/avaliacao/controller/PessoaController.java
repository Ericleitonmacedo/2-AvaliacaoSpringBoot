package br.com.avaliacao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.avaliacao.model.Pessoa;
import br.com.avaliacao.model.PessoaRequest;
import br.com.avaliacao.model.PessoaResponse;
import br.com.avaliacao.service.PessoaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	private PessoaService service;
	
	@GetMapping
	public ResponseEntity<List<PessoaResponse>> pessoa() {
		return new ResponseEntity<>(this.service.pesquisarTodasPessoas(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> salvar(@RequestBody PessoaRequest pessoaDTO) {
		return new ResponseEntity<>(this.service.salvar(pessoaDTO), HttpStatus.CREATED);	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		this.service.deletar(id);
		return new ResponseEntity<>("Pessoa excluída com sucesso!", HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> editar(@RequestBody PessoaResponse pessoaResponse) {
		this.service.editar(pessoaResponse);
		return new ResponseEntity<>("Pessoa atualizada com sucesso!", HttpStatus.OK);
	}

}
