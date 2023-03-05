package br.com.cwi.crescer.bascrescer.service;

import br.com.cwi.crescer.bascrescer.domain.Time;
import br.com.cwi.crescer.bascrescer.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class BuscarTimeService {

    @Autowired
    private TimeRepository timeRepository;


    public Time porId(Long timeId) {
        return timeRepository.findById(timeId)
                .orElseThrow(() -> new ResponseStatusException(UNPROCESSABLE_ENTITY, "Time não encontrado"));
    }
}
