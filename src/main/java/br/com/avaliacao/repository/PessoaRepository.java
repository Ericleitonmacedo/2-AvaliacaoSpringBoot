package br.com.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.avaliacao.model.Pessoa;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
