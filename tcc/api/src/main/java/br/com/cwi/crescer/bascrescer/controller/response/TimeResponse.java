package br.com.cwi.crescer.bascrescer.controller.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeResponse {

    private Long id;

    private String nome;

    private String img;

}
