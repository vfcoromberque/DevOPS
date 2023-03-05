package br.com.cwi.crescer.bascrescer.security.mapper;

import br.com.cwi.crescer.bascrescer.mapper.TimeMapper;
import br.com.cwi.crescer.bascrescer.security.controller.response.ListagemUsuarioResponse;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;

public class ListagemUsuarioMapper {

    public static ListagemUsuarioResponse toResponse(Usuario usuario) {
        return ListagemUsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .apelido(usuario.getApelido())
                .img(usuario.getImg())
                .time(TimeMapper.toResponse(usuario.getTime()))
                .build();
    }
}
