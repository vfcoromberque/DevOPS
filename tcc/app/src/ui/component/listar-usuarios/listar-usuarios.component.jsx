import "./listar-usuarios.style.css";
import { CardUsuario } from "../card-usuario/card-usuario.component";

export function ListarUsuarios({ lista, formInput, handleChange, tipo }) {
  return lista ? (
    <div className="user_list">
      {tipo !== "solicitacoes" ? (
        <input
          name="input"
          value={formInput.input}
          onChange={handleChange}
          type="text"
          placeholder="Pesquisar"
        />
      ) : null}
      <div className="user_card_list">
        {lista.map((usuario) => (
          <div key={Math.random(1)} className="user_card">
            <CardUsuario tipo={tipo} usuario={usuario}></CardUsuario>
          </div>
        ))}
      </div>
    </div>
  ) : null;
}
