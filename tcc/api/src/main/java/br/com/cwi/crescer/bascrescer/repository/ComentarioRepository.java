package br.com.cwi.crescer.bascrescer.repository;

import br.com.cwi.crescer.bascrescer.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario,Long> {
}
