package br.com.cwi.crescer.bascrescer.domain;

import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "equipe")
public class Time {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;

    private String img;

    @OneToMany(mappedBy = "time")
    private List<Usuario> usuarios;

}
