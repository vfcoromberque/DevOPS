package br.com.cwi.crescer.bascrescer.security.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditarUsuarioRequest {

    private String nome;

    private String apelido;

    private String img;

}
