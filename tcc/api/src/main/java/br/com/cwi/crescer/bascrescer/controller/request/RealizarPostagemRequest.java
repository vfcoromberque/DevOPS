package br.com.cwi.crescer.bascrescer.controller.request;

import br.com.cwi.crescer.bascrescer.domain.Comentario;
import br.com.cwi.crescer.bascrescer.domain.Visualizacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RealizarPostagemRequest {

    @NotNull
    private Visualizacao visualizacao;

    @NotBlank
    private String titulo;

    private String img;

    @NotBlank
    private String conteudo;

    private LocalDateTime dataPostagem = LocalDateTime.now();

    private List<Comentario> comentarios = new ArrayList<>();

}
