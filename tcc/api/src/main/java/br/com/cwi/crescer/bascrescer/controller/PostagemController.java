package br.com.cwi.crescer.bascrescer.controller;

import br.com.cwi.crescer.bascrescer.controller.request.RealizarPostagemRequest;
import br.com.cwi.crescer.bascrescer.controller.response.ComentarioResponse;
import br.com.cwi.crescer.bascrescer.controller.response.IdResponse;
import br.com.cwi.crescer.bascrescer.controller.response.PostagemResponse;
import br.com.cwi.crescer.bascrescer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    @Autowired
    private RealizarPostagemService realizarPostagemService;

    @Autowired
    private ListarComentariosService listarComentariosService;

    @Autowired
    private NumeroCurtidasService numeroCurtidasService;

    @Autowired
    private ListarFeedService listarFeedService;

    @Autowired
    private ListarPostsUsuarioService listarPostsUsuarioService;


    @GetMapping("/feed")
    @ResponseStatus(OK)
    public Page<PostagemResponse> listarFeed(Pageable pageable) {
        return listarFeedService.listarFeed(pageable);
    }

    @GetMapping("/usuario/{id}")
    @ResponseStatus(OK)
    public Page<PostagemResponse> listarPostsUsuario(@PathVariable Long id, Pageable pageable) {
        return listarPostsUsuarioService.listarPostsUsuario(id, pageable);
    }

    @GetMapping("/{id}/comentarios")
    @ResponseStatus(OK)
    public List<ComentarioResponse> listarComentarios(@PathVariable Long id) {
        return listarComentariosService.listarComentarios(id);
    }

    @GetMapping("/{id}/curtidas")
    @ResponseStatus(OK)
    public Long numeroCurtidas(@PathVariable Long id) {
        return numeroCurtidasService.numeroCurtidas(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public IdResponse realizarPostagem(@Valid @RequestBody RealizarPostagemRequest request) {
        return realizarPostagemService.realizarPostagem(request);
    }

}
