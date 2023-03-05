package br.com.cwi.crescer.bascrescer.controller;

import br.com.cwi.crescer.bascrescer.controller.response.TimeResponse;
import br.com.cwi.crescer.bascrescer.service.ListarTimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private ListarTimesService listarTimesService;

    @GetMapping("/publico")
    @ResponseStatus(OK)
    public List<TimeResponse> listar() {
        return listarTimesService.listar();
    }
}
