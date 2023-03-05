import "./screen-wrapper.style.css";
import logo from "../../../assets/logo.png";
import { useNavigate } from "react-router-dom";
import { Botao } from "../botao/botao.component";
import useGlobalUser, {
  USER_KEY,
} from "../../../context/usuario/usuario.context";
import { useLogout } from "../../../hooks/usuarios/logout.hook";

export function ScreenWrapper({ children }) {
  const navigate = useNavigate();
  const [user, setUser] = useGlobalUser();
  const { handleLogout } = useLogout();

  function onClickVoltar() {
    navigate(-1);
  }

  function onClickLogo() {
    navigate("/home");
  }

  function onClickLogout() {
    handleLogout();
    setUser(null);
    localStorage.removeItem(USER_KEY);
    navigate("/");
  }

  return (
    <div className="wrapper__screen">
      <div className="wrapper__header_topdetail"></div>
      <header className="container wrapper__header">
        <div onClick={onClickLogo} className="wrapper__header__logo">
          <img src={logo} alt="Logo Me-Leva-Ai"></img>
        </div>

        <nav className="wrapper__header__navbar">
          <Botao onClick={onClickVoltar} text="Voltar"></Botao>
          {user ? <Botao text="Logout" onClick={onClickLogout}></Botao> : null}
        </nav>
      </header>
      <div className="wrapper__header_bottomdetail"></div>

      <section className="wrapper__body">{children}</section>

      <footer className="wrapper__footer">
        <h5>2023/02 Bascrescer©</h5>
      </footer>
    </div>
  );
}
