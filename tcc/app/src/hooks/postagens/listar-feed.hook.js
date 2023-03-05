import { listarFeed } from "../../api/postagem/listar-feed.api";
import { useEffect, useState } from "react";

export function useGetFeed() {
  const [feed, setFeed] = useState();
  const [isLoading, setIsLoading] = useState(true);
  const [hasError, setHasError] = useState(null);

  async function buscandoFeed() {
    try {
      setIsLoading(true);
      const response = await listarFeed();
      setFeed(response);
    } catch (error) {
      setIsLoading(false);
      setHasError("An error occured fetching the data");
    } finally {
      setIsLoading(false);
    }
  }

  useEffect(() => {
    buscandoFeed();
  }, []);

  return { feed, isLoading, hasError, buscandoFeed };
}
