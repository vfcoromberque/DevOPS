package br.com.cwi.crescer.bascrescer.security.domain;

import br.com.cwi.crescer.bascrescer.domain.Comentario;
import br.com.cwi.crescer.bascrescer.domain.Postagem;
import br.com.cwi.crescer.bascrescer.domain.Time;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String apelido;
    private LocalDate dataNascimento;
    private String senha;
    private String img;


    private boolean ativo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Time time;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "usuario")
    private List<Postagem> postagens;

    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuario(this);
    }

    public void adicionarComentario(Comentario comentario, Postagem postagem) {
        this.comentarios.add(comentario);
        comentario.setUsuario(this);
        postagem.getComentarios().add(comentario);
        comentario.setPostagem(postagem);
    }

    public void adicionarPostagem(Postagem postagem) {
        this.postagens.add(postagem);
        postagem.setUsuario(this);
    }

}
