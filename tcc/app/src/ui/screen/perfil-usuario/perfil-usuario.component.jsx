import "./perfil-usuario.style.css";
import { ScreenWrapper } from "../../component";
import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";

export function PerfilUsuario() {
  const location = useLocation();
  const [usuario, setUsuario] = useState({});

  useEffect(() => {
    const usuario = location.state?.usuario;
    setUsuario(usuario);
  });

  return usuario ? (
    <ScreenWrapper>
      <div>
        <img src={usuario.img} alt="" />
        <h1>{usuario.nome}</h1>
      </div>
    </ScreenWrapper>
  ) : null;
}
