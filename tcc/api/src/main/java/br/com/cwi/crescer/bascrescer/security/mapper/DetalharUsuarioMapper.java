package br.com.cwi.crescer.bascrescer.security.mapper;

import br.com.cwi.crescer.bascrescer.mapper.TimeMapper;
import br.com.cwi.crescer.bascrescer.security.controller.response.DetalharUsuarioResponse;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;

public class DetalharUsuarioMapper {
    public static DetalharUsuarioResponse toResponse(Usuario usuario) {
        return DetalharUsuarioResponse.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .apelido(usuario.getApelido())
                .dataNascimento(usuario.getDataNascimento())
                .img(usuario.getImg())
                .time(TimeMapper.toResponse(usuario.getTime()))
                .build();
    }
}
