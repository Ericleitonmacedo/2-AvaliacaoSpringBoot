package br.com.avaliacao.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.avaliacao.model.Pessoa;
import br.com.avaliacao.model.PessoaRequest;
import br.com.avaliacao.model.PessoaResponse;
import br.com.avaliacao.repository.PessoaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PessoaService {
	
	private PessoaRepository repository;
	
	public Pessoa salvar(PessoaRequest pessoaDTO) {
		return repository.save(convertePessoaRequestParaPessoa(pessoaDTO));
	}
	
	public List<PessoaResponse> pesquisarTodasPessoas() {
		return repository.findAll()
				.stream()
				.map(pessoa -> convertePessoaResponse(pessoa))
				.collect(Collectors.toList());
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
	
	public void editar(PessoaResponse pessoaResponse) {
		repository.save(convertePessoa(pessoaResponse));
	}
	
	
	private Pessoa convertePessoaRequestParaPessoa(PessoaRequest dto) {
        return Pessoa.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .telefone(dto.getTelefone())
                .curso(dto.getCurso())
                .build();
    }

    private PessoaResponse convertePessoaResponse(Pessoa pessoa) {
        return PessoaResponse.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .email(pessoa.getEmail())
                .telefone(pessoa.getTelefone())
                .curso(pessoa.getCurso())
                .build();

    }
    
    private Pessoa convertePessoa(PessoaResponse pessoaResponse) {
        return Pessoa.builder()
                .id(pessoaResponse.getId())
                .nome(pessoaResponse.getNome())
                .email(pessoaResponse.getEmail())
                .telefone(pessoaResponse.getTelefone())
                .curso(pessoaResponse.getCurso())
                .build();

    }
	
	

}
