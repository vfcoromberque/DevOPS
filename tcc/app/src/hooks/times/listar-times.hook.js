import { listarTimes } from "../../api/time/listar-times.api";
import { useEffect, useState } from "react";

export function useGetTimes() {
  const [times, setTimes] = useState();
  const [isLoading, setIsLoading] = useState(true);
  const [hasError, setHasError] = useState(null);

  async function buscandoTimes() {
    try {
      setIsLoading(true);
      const response = await listarTimes();
      setTimes(response);
    } catch (error) {
      setIsLoading(false);
      setHasError("An error occured fetching the data");
    } finally {
      setIsLoading(false);
    }
  }

  useEffect(() => {
    buscandoTimes();
  }, []);

  return { times, isLoading, hasError };
}
