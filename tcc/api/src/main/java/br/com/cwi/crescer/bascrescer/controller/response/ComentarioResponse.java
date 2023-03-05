package br.com.cwi.crescer.bascrescer.controller.response;

import br.com.cwi.crescer.bascrescer.security.controller.response.UsuarioResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioResponse {

    private UsuarioResponse usuario;

    private String conteudo;

    private LocalDateTime dataComentario;

}
