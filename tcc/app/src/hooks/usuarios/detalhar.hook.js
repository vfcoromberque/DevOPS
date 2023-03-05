import { detalharUsuario } from "../../api/usuario/detalhar.api";
import { useState } from "react";

export async function useDetalharUsuario(id) {
  const [response, setResponse] = useState();
  const [isLoading, setIsLoading] = useState(true);
  const [hasError, setHasError] = useState();

  async function useDetalhar() {
    try {
      setIsLoading(true);
      const response = await detalharUsuario({ id });
      setResponse(response.data);
    } catch (error) {
      setHasError(error);
    } finally {
      setIsLoading(false);
    }
  }

  useDetalhar();

  return { response, isLoading, hasError };
}
