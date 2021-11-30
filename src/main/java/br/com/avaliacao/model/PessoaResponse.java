package br.com.avaliacao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class PessoaResponse {
	
	private Long id;
	
	private String nome;

	private String email;

	private String telefone;
	
	private String curso;

	
}
