package br.com.cwi.crescer.bascrescer.mapper;

import br.com.cwi.crescer.bascrescer.controller.response.PostagemResponse;
import br.com.cwi.crescer.bascrescer.domain.Postagem;
import br.com.cwi.crescer.bascrescer.security.mapper.DetalharUsuarioMapper;

import java.util.stream.Collectors;

public class PostagemMapper {

    public static PostagemResponse toResponse(Postagem postagem) {
        return PostagemResponse.builder()
                .id(postagem.getId())
                .usuario(DetalharUsuarioMapper.toResponse(postagem.getUsuario()))
                .titulo(postagem.getTitulo())
                .img(postagem.getImg())
                .conteudo(postagem.getConteudo())
                .dataPostagem(postagem.getDataPostagem())
                .comentarios(null)
                .visualizacao(postagem.getVisualizacao())
                .comentarios(postagem.getComentarios().stream()
                        .map(ComentarioMapper::toResponse)
                        .collect(Collectors.toList()))
                .build();
    }

}
