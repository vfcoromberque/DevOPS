import { listarAmigos } from "../../api/conexao/amigos.api";
import { useEffect, useState } from "react";

export function useGetAmigos(filtro) {
  const [amigos, setAmigos] = useState();
  const [isLoadingA, setIsLoading] = useState(true);
  const [hasErrorA, setHasError] = useState(null);

  async function buscandoAmigos() {
    try {
      setIsLoading(true);
      const response = await listarAmigos({ filtro });
      setAmigos(response);
    } catch (error) {
      setIsLoading(false);
      setHasError("An error occured fetching the data");
    } finally {
      setIsLoading(false);
    }
  }

  useEffect(() => {
    buscandoAmigos();
  }, []);

  return { amigos, isLoadingA, hasErrorA, buscandoAmigos };
}
