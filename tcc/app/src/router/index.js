import { Login, Register, Home, EditarPerfil, PerfilUsuario } from "../ui";

const { createBrowserRouter } = require("react-router-dom");

export const router = createBrowserRouter([
  {
    path: "/",
    element: <Login></Login>,
  },
  {
    path: "/register",
    element: <Register></Register>,
  },
  {
    path: "/home",
    element: <Home></Home>,
  },
  {
    path: "/editar-perfil",
    element: <EditarPerfil></EditarPerfil>,
  },
  {
    path: "/usuario/perfil",
    element: <PerfilUsuario></PerfilUsuario>,
  },
]);
