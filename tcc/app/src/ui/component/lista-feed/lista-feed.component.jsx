import "./lista-feed.style.css";
import { useEffect } from "react";
import { useGetFeed } from "../../../hooks/postagens/listar-feed.hook";
import { FeedPost } from "../feed-post/feed-post.component";

export function ListaFeed() {
  const { feed, buscandoFeed } = useGetFeed();

  useEffect(() => {
    buscandoFeed();
  }, []);

  return feed ? (
    <div className="feed_list">
      {feed.map((post) => (
        <FeedPost key={Math.random(1)} post={post}></FeedPost>
      ))}
    </div>
  ) : null;
}
