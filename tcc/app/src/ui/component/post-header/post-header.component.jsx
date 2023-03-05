import "./post-header.style.css";

export function PostHeader({ usuario }) {
  return usuario ? (
    <div className="post_header">
      <div className="post_header_user">
        <div className="post_header_user_img">
          <img src={usuario.img} alt="" />
        </div>
        <h1>{usuario.nome}</h1>
      </div>
      <div className="post_header_team_img">
        <img src={usuario.time.img} alt="" />
      </div>
    </div>
  ) : null;
}
