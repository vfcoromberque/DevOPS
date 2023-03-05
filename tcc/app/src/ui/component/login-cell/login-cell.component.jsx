import React from "react";
import "./login-cell.style.css";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import useGlobalUser from "../../../context/usuario/usuario.context.js";
import { login } from "../../../api/usuario/login.api";
import { Botao } from "../botao/botao.component";
import { SimpleForm } from "../form-simples/form-simples.component";

export function LoginCell() {
  const [formInput, setFormInput] = useState({ username: "", password: "" });
  const navigate = useNavigate();
  const [user, setUser] = useGlobalUser();

  function handleChange(event) {
    const { name, value } = event.target;

    setFormInput((oldFormInput) => ({ ...oldFormInput, [name]: value }));
  }

  function onClickRegister() {
    navigate("/register");
  }

  async function handleSubmit(event) {
    event.preventDefault();

    try {
      const user = await login({
        username: formInput.username,
        password: formInput.password,
      });
      setUser(user);
    } catch (error) {
      console.log("erro");
    }
  }

  useEffect(() => {
    if (user) {
      navigate("/home");
    }
  });

  return (
    <div className="login_cell">
      <h1>Login</h1>
      <SimpleForm
        formInput={formInput}
        handleChange={handleChange}
        handleSubmit={handleSubmit}
      ></SimpleForm>
      <div className="login_cell_register">
        <Botao text="Registrar" onClick={onClickRegister}></Botao>
      </div>
    </div>
  );
}
