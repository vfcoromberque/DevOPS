package br.com.cwi.crescer.bascrescer.repository;

import br.com.cwi.crescer.bascrescer.domain.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time,Long> {
}
