package br.com.licitacao.repository;

import br.com.licitacao.model.Licitacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicitacaoRepository extends JpaRepository<Licitacao, Integer> {
}
