package br.com.cwi.crescer.bascrescer.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RealizarComentarioRequest {

    @NotBlank
    private String conteudo;

    private LocalDateTime dataComentario = LocalDateTime.now();

}
