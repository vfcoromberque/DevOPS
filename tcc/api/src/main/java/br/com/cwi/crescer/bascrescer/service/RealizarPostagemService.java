package br.com.cwi.crescer.bascrescer.service;

import br.com.cwi.crescer.bascrescer.controller.request.RealizarPostagemRequest;
import br.com.cwi.crescer.bascrescer.controller.response.IdResponse;
import br.com.cwi.crescer.bascrescer.domain.Postagem;
import br.com.cwi.crescer.bascrescer.repository.PostagemRepository;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import br.com.cwi.crescer.bascrescer.security.repository.UsuarioRepository;
import br.com.cwi.crescer.bascrescer.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.crescer.bascrescer.mapper.IdResponseMapper.toResponse;
import static br.com.cwi.crescer.bascrescer.mapper.RealizarPostagemMapper.toEntity;

@Service
public class RealizarPostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;


    public IdResponse realizarPostagem(RealizarPostagemRequest request) {

        Postagem postagem = toEntity(request);

        Usuario usuario = usuarioAutenticadoService.get();

        postagem.setUsuario(usuario);

        postagemRepository.save(postagem);

        usuario.adicionarPostagem(postagem);

        usuarioRepository.save(usuario);

        return toResponse(postagem.getId());

    }
}
