import { listarUsuarios } from "../../api/usuario/usuarios.api";
import { useEffect, useState } from "react";

export function useGetUsuarios(filtro) {
  const [usuarios, setUsuarios] = useState();
  const [isLoadingU, setIsLoading] = useState(true);
  const [hasErrorU, setHasError] = useState(null);

  async function buscandoUsuarios() {
    try {
      setIsLoading(true);
      const response = await listarUsuarios({ filtro });
      setUsuarios(response);
    } catch (error) {
      setIsLoading(false);
      setHasError("An error occured fetching the data");
    } finally {
      setIsLoading(false);
    }
  }

  useEffect(() => {
    buscandoUsuarios();
  }, []);

  return { usuarios, isLoadingU, hasErrorU, buscandoUsuarios };
}
