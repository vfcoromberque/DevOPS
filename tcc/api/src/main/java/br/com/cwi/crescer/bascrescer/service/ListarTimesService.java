package br.com.cwi.crescer.bascrescer.service;

import br.com.cwi.crescer.bascrescer.mapper.TimeMapper;
import br.com.cwi.crescer.bascrescer.repository.TimeRepository;
import br.com.cwi.crescer.bascrescer.controller.response.TimeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarTimesService {

    @Autowired
    private TimeRepository timeRepository;


    public List<TimeResponse> listar() {
        return timeRepository.findAll().stream()
                .map(TimeMapper::toResponse)
                .collect(Collectors.toList());
    }

}
