package br.com.cwi.crescer.bascrescer.service;

import br.com.cwi.crescer.bascrescer.controller.response.PostagemResponse;
import br.com.cwi.crescer.bascrescer.mapper.PostagemMapper;
import br.com.cwi.crescer.bascrescer.repository.PostagemRepository;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import br.com.cwi.crescer.bascrescer.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarFeedService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private PostagemRepository postagemRepository;


    public Page<PostagemResponse> listarFeed(Pageable pageable) {

        Usuario usuario = usuarioAutenticadoService.get();

        return postagemRepository.findFeedUsuario(usuario, pageable)
                .map(PostagemMapper::toResponse);
    }
}
