package br.com.cwi.crescer.bascrescer.controller;

import br.com.cwi.crescer.bascrescer.controller.response.IdResponse;
import br.com.cwi.crescer.bascrescer.security.controller.response.ListagemUsuarioResponse;
import br.com.cwi.crescer.bascrescer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/conexoes")
public class ConexaoController {

    @Autowired
    private SolicitarAmizadeService solicitarAmizadeService;

    @Autowired
    private AceitarAmizadeService aceitarAmizadeService;

    @Autowired
    private RecusarAmizadeService recusarAmizadeService;

    @Autowired
    private DesfazerAmizadeService desfazerAmizadeService;

    @Autowired
    private ListarAmizadesService listarAmizadesService;

    @Autowired
    private ListarSolicitacoesService listarSolicitacoesService;


    @GetMapping("/amigos")
    @ResponseStatus(OK)
    public Page<ListagemUsuarioResponse> amizades(@RequestParam(required = false, defaultValue = "") String text, Pageable pageable) {
        return listarAmizadesService.amizades(text, pageable);
    }

    @GetMapping("/solicitacoes")
    @ResponseStatus(OK)
    public List<ListagemUsuarioResponse> solicitacoes() {
        return listarSolicitacoesService.solicitacoes();
    }

    @PostMapping("/usuario/{id}")
    @ResponseStatus(CREATED)
    public IdResponse solicitar(@PathVariable Long id) {
        return solicitarAmizadeService.solicitar(id);
    }

    @PutMapping("/usuario/{id}/aceitar")
    @ResponseStatus(ACCEPTED)
    public IdResponse aceitar(@PathVariable Long id) {
        return aceitarAmizadeService.aceitar(id);
    }

    @DeleteMapping("/usuario/{id}/recusar")
    @ResponseStatus(NO_CONTENT)
    public void recusar(@PathVariable Long id) {
        recusarAmizadeService.recusar(id);
    }

    @DeleteMapping("/usuario/{id}/desfazer")
    @ResponseStatus(NO_CONTENT)
    public void desfazer(@PathVariable Long id) {
        desfazerAmizadeService.desfazer(id);
    }

}
