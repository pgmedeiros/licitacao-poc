package br.com.licitacao.dto;

import br.com.licitacao.enums.ETipo;
import br.com.licitacao.model.Licitacao;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LicitacaoResponse {

    private String titulo;
    private Double valor;
    private ETipo tipo;

    public static LicitacaoResponse of(Licitacao licitacao) {
        return LicitacaoResponse
                .builder()
                .valor(licitacao.getValor())
                .tipo(licitacao.getTipo())
                .titulo(licitacao.getTitulo())
                .build();
    }
}
