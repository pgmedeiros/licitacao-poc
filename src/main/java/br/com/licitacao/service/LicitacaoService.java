package br.com.licitacao.service;

import br.com.licitacao.dto.LicitacaoRequest;
import br.com.licitacao.model.Licitacao;
import br.com.licitacao.repository.LicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;

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

    public void upload(MultipartFile file, Integer id) {
        var diretorioPath = Path.of("/tmp/licitacao-disco", "licitacao");
        var arquivoPath = diretorioPath.resolve(id.toString());
        try {
            Files.createDirectories(diretorioPath);
            file.transferTo(arquivoPath.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
        }
    }

    public Resource download(Integer id) {
        var path = Path.of("/tmp/licitacao-disco/licitacao/" + id);
        UrlResource resource = null;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Problemas na tentativa baixar arquivo", e);
        }
        return resource;
    }
}
