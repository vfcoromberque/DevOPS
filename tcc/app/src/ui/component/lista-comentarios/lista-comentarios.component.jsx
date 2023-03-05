import "./listar-comentarios.style.css";

export function ListaComentarios({ post }) {
  return (
    <div className="list_comments">
      {post.comentarios.map((comentario) => (
        <div key={Math.random(1)} className="comment">
          <div className="comment_user">
            <h4>{comentario.usuario.nome}:</h4>
            <h6>{comentario.dataComentario}</h6>
          </div>
          <h5>{comentario.conteudo}</h5>
        </div>
      ))}
    </div>
  );
}
