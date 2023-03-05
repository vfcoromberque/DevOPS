package br.com.cwi.crescer.bascrescer.mapper;

import br.com.cwi.crescer.bascrescer.domain.Time;
import br.com.cwi.crescer.bascrescer.controller.response.TimeResponse;

public class TimeMapper {
    public static TimeResponse toResponse(Time time) {
        return TimeResponse.builder()
                .id(time.getId())
                .nome(time.getNome())
                .img(time.getImg())
                .build();
    }
}
