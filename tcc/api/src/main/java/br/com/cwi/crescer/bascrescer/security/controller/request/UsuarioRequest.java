package br.com.cwi.crescer.bascrescer.security.controller.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

    @NotBlank
    private String nome;

    @Email
    @NotNull
    private String email;

    private String apelido;

    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    private String senha;

    private String img;

    @NotNull
    private Long timeId;

}
