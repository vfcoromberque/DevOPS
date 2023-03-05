package br.com.cwi.crescer.bascrescer.mapper;

import br.com.cwi.crescer.bascrescer.controller.request.RealizarComentarioRequest;
import br.com.cwi.crescer.bascrescer.domain.Comentario;

public class RealizarComentarioMapper {
    public static Comentario toEntity(RealizarComentarioRequest request) {
        return Comentario.builder()
                .conteudo(request.getConteudo())
                .dataComentario(request.getDataComentario())
                .build();
    }
}
