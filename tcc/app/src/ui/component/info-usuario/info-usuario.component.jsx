import "./info-usuario.style.css";
import { useState, useEffect } from "react";
import useGlobalUser from "../../../context/usuario/usuario.context";
import { detalharUsuario } from "../../../api/usuario/detalhar.api";
import { Botao } from "../botao/botao.component";
import { useNavigate } from "react-router-dom";

export function InfoUsuario() {
  const navigate = useNavigate();
  const [user] = useGlobalUser();
  const [response, setResponse] = useState();
  const [isLoading, setIsLoading] = useState(true);
  const [, setHasError] = useState();

  async function getDetalheUsuario(id) {
    try {
      setIsLoading(true);
      const response = await detalharUsuario({ id });
      setResponse(response);
    } catch (error) {
      setHasError(error);
    } finally {
      setIsLoading(false);
    }
  }

  function onClickEditar() {
    navigate("/editar-perfil");
  }

  useEffect(() => {
    if (user) {
      getDetalheUsuario(user.id);
    }
  }, [user]);

  return isLoading ? (
    <h1>Carregando...</h1>
  ) : (
    <div className="user_info_tab">
      <div className="user_info_tab_user">
        <div className="user_info_tab_user_img">
          <img src={response.img} alt="" />
        </div>
        <div className="user_info_tab_user_text">
          {response.apelido ? (
            <div>
              <h1>{response.apelido}</h1>
              <h3>{response.nome}</h3>
            </div>
          ) : (
            <h1>{response.nome}</h1>
          )}
          <h3>{response.email}</h3>
          <h4>{response.dataNascimento}</h4>
        </div>
      </div>
      <div className="user_info_tab_team">
        <h1>{response.time.nome}</h1>
        <div className="user_info_tab_team_img">
          <img src={response.time.img} alt="" />
        </div>
      </div>
      <Botao text="Editar perfil" onClick={onClickEditar}></Botao>
    </div>
  );
}
