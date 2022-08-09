package br.com.licitacao.model;

import br.com.licitacao.dto.LicitacaoRequest;
import br.com.licitacao.enums.ETipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Licitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private ETipo tipo;
    private Double valor;

    public static Licitacao of(LicitacaoRequest request) {
        return Licitacao
                .builder()
                .tipo(request.getTipo())
                .titulo(request.getTitulo())
                .valor(request.getValor())
                .build();
    }

    public static Licitacao of(LicitacaoRequest request, Integer id) {
        return Licitacao
                .builder()
                .id(id)
                .tipo(request.getTipo())
                .titulo(request.getTitulo())
                .valor(request.getValor())
                .build();
    }
}
