package br.com.cwi.crescer.bascrescer.service;

import br.com.cwi.crescer.bascrescer.domain.Postagem;
import br.com.cwi.crescer.bascrescer.repository.CurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumeroCurtidasService {

    @Autowired
    private BuscarPostagemService buscarPostagemService;

    @Autowired
    private CurtidaRepository curtidaRepository;


    public Long numeroCurtidas(Long id) {

        Postagem postagem = buscarPostagemService.porId(id);

        return curtidaRepository.countByPostagemIdEquals(postagem.getId());

    }
}
