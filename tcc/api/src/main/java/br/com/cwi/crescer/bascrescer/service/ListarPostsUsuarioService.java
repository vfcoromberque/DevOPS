package br.com.cwi.crescer.bascrescer.service;

import br.com.cwi.crescer.bascrescer.controller.response.PostagemResponse;
import br.com.cwi.crescer.bascrescer.mapper.PostagemMapper;
import br.com.cwi.crescer.bascrescer.repository.PostagemRepository;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import br.com.cwi.crescer.bascrescer.security.service.BuscarUsuarioService;
import br.com.cwi.crescer.bascrescer.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarPostsUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private PostagemRepository postagemRepository;


    public Page<PostagemResponse> listarPostsUsuario(Long id, Pageable pageable) {

        Usuario usuario = usuarioAutenticadoService.get();

        Usuario DonoPerfil = buscarUsuarioService.porId(id);

        return postagemRepository.findPostagensPermitidas(usuario, DonoPerfil, pageable)
                .map(PostagemMapper::toResponse);
    }
}
