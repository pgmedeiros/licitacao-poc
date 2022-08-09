package br.com.licitacao.service;

import br.com.licitacao.dto.LicitacaoRequest;
import br.com.licitacao.model.Licitacao;
import br.com.licitacao.repository.LicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LicitacaoService {

    public final RuntimeException LICITACAO_NAO_ENCONTRADA = new RuntimeException("Licitação não encontrada.");

    @Autowired
    private LicitacaoRepository repository;

    public Licitacao findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> LICITACAO_NAO_ENCONTRADA);
    }

    public Licitacao save(LicitacaoRequest request) {
        return repository.save(Licitacao.of(request));
    }

    public Licitacao update(LicitacaoRequest request, Integer id) {
        return repository.save(Licitacao.of(request, id));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
