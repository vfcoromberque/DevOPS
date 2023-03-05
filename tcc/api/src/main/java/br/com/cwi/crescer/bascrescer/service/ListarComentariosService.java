package br.com.cwi.crescer.bascrescer.service;

import br.com.cwi.crescer.bascrescer.controller.response.ComentarioResponse;
import br.com.cwi.crescer.bascrescer.domain.Postagem;
import br.com.cwi.crescer.bascrescer.mapper.ComentarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarComentariosService {

    @Autowired
    private BuscarPostagemService buscarPostagemService;

    public List<ComentarioResponse> listarComentarios(Long id) {

        Postagem postagem = buscarPostagemService.porId(id);

        return postagem.getComentarios().stream()
                .map(ComentarioMapper::toResponse)
                .collect(Collectors.toList());

    }
}
