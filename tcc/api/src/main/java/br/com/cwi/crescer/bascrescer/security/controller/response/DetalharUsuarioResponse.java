package br.com.cwi.crescer.bascrescer.security.controller.response;

import br.com.cwi.crescer.bascrescer.controller.response.TimeResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetalharUsuarioResponse {

    private String nome;

    private String email;

    private String apelido;

    private LocalDate dataNascimento;

    private String img;

    private TimeResponse time;

}
