package br.com.cwi.crescer.bascrescer.mapper;

import br.com.cwi.crescer.bascrescer.controller.response.IdResponse;

public class IdResponseMapper {
    public static IdResponse toResponse(Long id) {
        return IdResponse.builder()
                .id(id)
                .build();
    }
}
