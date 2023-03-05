package br.com.cwi.crescer.bascrescer.controller;

import br.com.cwi.crescer.bascrescer.controller.request.RealizarComentarioRequest;
import br.com.cwi.crescer.bascrescer.controller.response.IdResponse;
import br.com.cwi.crescer.bascrescer.service.RealizarComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private RealizarComentarioService realizarComentarioService;

    @PostMapping("/postagem/{id}")
    @ResponseStatus(CREATED)
    public IdResponse realizarComentario(@PathVariable Long id, @Valid @RequestBody RealizarComentarioRequest request) {
        return realizarComentarioService.realizarComentario(id, request);
    }

}
