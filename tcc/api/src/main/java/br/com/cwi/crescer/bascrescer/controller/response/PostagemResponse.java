package br.com.cwi.crescer.bascrescer.controller.response;

import br.com.cwi.crescer.bascrescer.domain.Visualizacao;
import br.com.cwi.crescer.bascrescer.security.controller.response.DetalharUsuarioResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostagemResponse {

    private Long id;

    private DetalharUsuarioResponse usuario;

    private String titulo;

    private String img;

    private String conteudo;

    private LocalDateTime dataPostagem;

    private List<ComentarioResponse> comentarios;

    private Visualizacao visualizacao;

}
