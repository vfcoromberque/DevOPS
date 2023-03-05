import { listarSolicitacoes } from "../../api/conexao/solicitacoes.api";
import { useEffect, useState } from "react";

export function useGetSolicitacoes() {
  const [solicitacoes, setSolicitacoes] = useState();
  const [isLoading, setIsLoading] = useState(true);
  const [hasError, setHasError] = useState(null);

  async function buscandoSolicitacoes() {
    try {
      setIsLoading(true);
      const response = await listarSolicitacoes();
      setSolicitacoes(response);
    } catch (error) {
      setIsLoading(false);
      setHasError("An error occured fetching the data");
    } finally {
      setIsLoading(false);
    }
  }

  useEffect(() => {
    buscandoSolicitacoes();
  }, []);

  return { solicitacoes, isLoading, hasError, buscandoSolicitacoes };
}
