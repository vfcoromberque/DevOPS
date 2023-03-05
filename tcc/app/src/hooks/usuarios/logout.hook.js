import { USER_KEY } from "../../context/usuario/usuario.context";
import { logout } from "../../api/usuario/logout.api";
import useGlobalUser from "../../context/usuario/usuario.context";
import { useNavigate } from "react-router";

export function useLogout() {
  const [, setUser] = useGlobalUser();
  const navigate = useNavigate();

  async function handleLogout() {
    await logout();
    setUser(null);
    localStorage.removeItem(USER_KEY);
    navigate("/");
  }

  return { handleLogout };
}
