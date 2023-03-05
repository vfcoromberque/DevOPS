package br.com.cwi.crescer.bascrescer.service;

import br.com.cwi.crescer.bascrescer.controller.request.RealizarComentarioRequest;
import br.com.cwi.crescer.bascrescer.controller.response.IdResponse;
import br.com.cwi.crescer.bascrescer.domain.Comentario;
import br.com.cwi.crescer.bascrescer.domain.Postagem;
import br.com.cwi.crescer.bascrescer.mapper.RealizarComentarioMapper;
import br.com.cwi.crescer.bascrescer.repository.ComentarioRepository;
import br.com.cwi.crescer.bascrescer.repository.PostagemRepository;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import br.com.cwi.crescer.bascrescer.security.repository.UsuarioRepository;
import br.com.cwi.crescer.bascrescer.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.crescer.bascrescer.mapper.IdResponseMapper.toResponse;

@Service
public class RealizarComentarioService {

    @Autowired
    private BuscarPostagemService buscarPostagemService;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;


    public IdResponse realizarComentario(Long id, RealizarComentarioRequest request) {

        Comentario comentario = RealizarComentarioMapper.toEntity(request);

        Usuario usuario = usuarioAutenticadoService.get();

        comentario.setUsuario(usuario);

        Postagem postagem = buscarPostagemService.porId(id);

        comentario.setPostagem(postagem);

        comentarioRepository.save(comentario);

        usuario.adicionarComentario(comentario, postagem);

        usuarioRepository.save(usuario);

        postagemRepository.save(postagem);

        return toResponse(comentario.getId());

    }
}
