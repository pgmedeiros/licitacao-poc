package br.com.licitacao.controller;

import br.com.licitacao.service.LicitacaoService;
import br.com.licitacao.dto.LicitacaoRequest;
import br.com.licitacao.dto.LicitacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/licitacao")
public class LicitacaoController {

    @Autowired
    private LicitacaoService service;

    @GetMapping("{id}")
    public LicitacaoResponse findById(@PathVariable Integer id) {
        var licitacao = service.findById(id);
        return LicitacaoResponse.of(licitacao);
    }

    @PostMapping
    public LicitacaoResponse save(@RequestBody LicitacaoRequest request) {
        var licitacao = service.save(request);
        return LicitacaoResponse.of(licitacao);
    }

    @PutMapping("{id}")
    public LicitacaoResponse update(@RequestBody LicitacaoRequest request, @PathVariable Integer id) {
        var licitacao = service.update(request, id);
        return LicitacaoResponse.of(licitacao);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
