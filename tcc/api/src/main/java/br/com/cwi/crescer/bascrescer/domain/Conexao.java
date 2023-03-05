package br.com.cwi.crescer.bascrescer.domain;

import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Conexao {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "solicitador_id")
    private Usuario solicitador;

    @Enumerated(STRING)
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "solicitado_id")
    private Usuario solicitado;

}
