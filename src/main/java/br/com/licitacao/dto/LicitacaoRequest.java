package br.com.licitacao.dto;

import br.com.licitacao.enums.ETipo;
import lombok.Data;

@Data
public class LicitacaoRequest {

    private String titulo;
    private ETipo tipo;
    private Double valor;
}
