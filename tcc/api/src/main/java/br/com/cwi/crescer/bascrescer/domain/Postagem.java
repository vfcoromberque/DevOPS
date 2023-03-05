package br.com.cwi.crescer.bascrescer.domain;

import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Postagem {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Enumerated(STRING)
    private Visualizacao visualizacao;

    private String titulo;

    private String img;

    private String conteudo;

    private LocalDateTime dataPostagem;

    @OneToMany(mappedBy = "postagem")
    private List<Comentario> comentarios;

}
