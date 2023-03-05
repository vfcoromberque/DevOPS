package br.com.cwi.crescer.bascrescer.controller;

import br.com.cwi.crescer.bascrescer.controller.response.IdResponse;
import br.com.cwi.crescer.bascrescer.service.CurtirPostagemService;
import br.com.cwi.crescer.bascrescer.service.DescurtirPostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/curtidas")
public class CurtidaController {

    @Autowired
    private CurtirPostagemService curtirPostagemService;

    @Autowired
    private DescurtirPostagemService descurtirPostagemService;


    @PostMapping("/postagem/{id}/curtir")
    @ResponseStatus(CREATED)
    public IdResponse curtir(@PathVariable Long id) {
        return curtirPostagemService.curtir(id);
    }

    @DeleteMapping("/postagem/{id}/descurtir")
    @ResponseStatus(NO_CONTENT)
    public void descurtir(@PathVariable Long id) {
        descurtirPostagemService.descurtir(id);
    }

}
