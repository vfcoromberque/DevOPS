package br.com.cwi.crescer.bascrescer.security.mapper;

import br.com.cwi.crescer.bascrescer.security.controller.request.UsuarioRequest;
import br.com.cwi.crescer.bascrescer.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequest request) {
        Usuario entity = new Usuario();
        entity.setNome(request.getNome());
        entity.setEmail(request.getEmail());
        entity.setApelido(request.getApelido());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setImg(request.getImg());
        return entity;
    }

    public static UsuarioResponse toResponse(Usuario entity) {
        return UsuarioResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .build();
    }

}
