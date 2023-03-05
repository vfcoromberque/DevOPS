package br.com.cwi.crescer.bascrescer.security.controller.response;

import br.com.cwi.crescer.bascrescer.controller.response.TimeResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListagemUsuarioResponse {

    private Long id;

    private String nome;

    private String email;

    private String apelido;

    private String img;

    private TimeResponse time;

}
