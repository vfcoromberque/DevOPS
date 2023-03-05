package br.com.cwi.crescer.bascrescer.security.controller;

import br.com.cwi.crescer.bascrescer.security.controller.request.EditarUsuarioRequest;
import br.com.cwi.crescer.bascrescer.security.controller.request.UsuarioRequest;
import br.com.cwi.crescer.bascrescer.security.controller.response.DetalharUsuarioResponse;
import br.com.cwi.crescer.bascrescer.security.controller.response.ListagemUsuarioResponse;
import br.com.cwi.crescer.bascrescer.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.bascrescer.security.service.DetatlharUsuarioService;
import br.com.cwi.crescer.bascrescer.security.service.EditarUsuarioService;
import br.com.cwi.crescer.bascrescer.security.service.IncluirUsuarioService;
import br.com.cwi.crescer.bascrescer.security.service.ListagemUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IncluirUsuarioService incluirUsuarioService;

    @Autowired
    private DetatlharUsuarioService detatlharUsuarioService;

    @Autowired
    private ListagemUsuarioService listagemUsuarioService;

    @Autowired
    private EditarUsuarioService editarUsuarioService;


    @GetMapping()
    @ResponseStatus(OK)
    public Page<ListagemUsuarioResponse> listar(@RequestParam(required = false, defaultValue = "") String text, Pageable pageable) {
        return listagemUsuarioService.listar(text, pageable);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public UsuarioResponse incluir(@Valid @RequestBody UsuarioRequest request) {
        return incluirUsuarioService.incluir(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public DetalharUsuarioResponse detalhar(@PathVariable Long id) {
        return detatlharUsuarioService.detalhar(id);
    }

    @PutMapping
    @ResponseStatus(OK)
    public void editar(@Valid @RequestBody EditarUsuarioRequest request) {
        editarUsuarioService.editar(request);
    }


}
