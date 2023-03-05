package br.com.cwi.crescer.bascrescer.service;

import br.com.cwi.crescer.bascrescer.domain.Conexao;
import br.com.cwi.crescer.bascrescer.repository.ConexaoRepository;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

import static br.com.cwi.crescer.bascrescer.domain.Situacao.AMIZADE;
import static br.com.cwi.crescer.bascrescer.domain.Situacao.SOLICITADO;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidarConexaoService {

    @Autowired
    private ConexaoRepository conexaoRepository;


    public void validarSolicitacao(Usuario solicitador, Usuario solicitado) {

        if(Objects.equals(solicitado, solicitador))
            throw new ResponseStatusException(BAD_REQUEST, "Não é possivel ser amigo de si mesmo.");

        Conexao conexao = conexaoRepository.findBySolicitadoIdAndSolicitadorIdAndSituacao
                (solicitado.getId(), solicitador.getId(), SOLICITADO);

        if(nonNull(conexao))
            throw new ResponseStatusException(BAD_REQUEST, "Essa solicitação ja se encontrava pendente.");

        Conexao conexaoInversa = conexaoRepository.findBySolicitadoIdAndSolicitadorIdAndSituacao
                (solicitador.getId(), solicitado.getId(), SOLICITADO);

        if(nonNull(conexaoInversa))
            throw new ResponseStatusException(BAD_REQUEST, "Você ja possui uma solicitação pendente deste usuário.");

        Conexao conexaoAmizade = conexaoRepository.findBySolicitadoIdAndSolicitadorIdAndSituacao
                (solicitado.getId(), solicitador.getId(), AMIZADE);

        Conexao conexaoAmizadeInversa = conexaoRepository.findBySolicitadoIdAndSolicitadorIdAndSituacao
                (solicitador.getId(), solicitado.getId(), AMIZADE);

        if(nonNull(conexaoAmizade) || nonNull(conexaoAmizadeInversa))
            throw new ResponseStatusException(BAD_REQUEST, "Você ja é amigo deste usuario.");

    }

    public void validarAceitacao(Conexao conexao) {

        if(isNull(conexao))
            throw new ResponseStatusException(BAD_REQUEST, "Não é possivel aceitar uma solicitacao inexistente.");

    }

    public void validarRecusa(Conexao conexao) {

        if(isNull(conexao))
            throw new ResponseStatusException(BAD_REQUEST, "Não é possivel recusar uma solicitacao inexistente.");

    }

    public void validarFimAmizade(Conexao conexao) {

        if(isNull(conexao))
            throw new ResponseStatusException(BAD_REQUEST, "Não é possivel desfazer uma amizade que não existe.");

    }
}
