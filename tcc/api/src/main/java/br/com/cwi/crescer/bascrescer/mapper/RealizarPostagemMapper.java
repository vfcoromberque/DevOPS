package br.com.cwi.crescer.bascrescer.mapper;

import br.com.cwi.crescer.bascrescer.controller.request.RealizarPostagemRequest;
import br.com.cwi.crescer.bascrescer.domain.Postagem;

public class RealizarPostagemMapper {
    public static Postagem toEntity(RealizarPostagemRequest request) {
        return Postagem.builder()
                .visualizacao(request.getVisualizacao())
                .titulo(request.getTitulo())
                .img(request.getImg())
                .conteudo(request.getConteudo())
                .comentarios(request.getComentarios())
                .dataPostagem(request.getDataPostagem())
                .build();
    }
}
