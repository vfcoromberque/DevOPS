package br.com.cwi.crescer.bascrescer.mapper;

import br.com.cwi.crescer.bascrescer.controller.response.ComentarioResponse;
import br.com.cwi.crescer.bascrescer.domain.Comentario;
import br.com.cwi.crescer.bascrescer.security.mapper.UsuarioMapper;

public class ComentarioMapper {
    public static ComentarioResponse toResponse(Comentario comentario) {
        return ComentarioResponse.builder()
                .usuario(UsuarioMapper.toResponse(comentario.getUsuario()))
                .conteudo(comentario.getConteudo())
                .dataComentario(comentario.getDataComentario())
                .build();
    }
}
