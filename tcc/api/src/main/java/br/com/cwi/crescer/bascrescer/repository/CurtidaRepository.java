package br.com.cwi.crescer.bascrescer.repository;

import br.com.cwi.crescer.bascrescer.domain.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurtidaRepository extends JpaRepository<Curtida,Long> {

    Long countByPostagemIdEquals(Long id);

    Curtida findByUsuarioIdEqualsAndPostagemIdEquals(Long usuario, Long postagem);
}
