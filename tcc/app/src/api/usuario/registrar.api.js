import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function registrar({
  nome,
  email,
  apelido,
  dataNascimento,
  senha,
  img,
  timeId,
}) {
  const response = await axiosInstance.post(`${API_URL}/usuarios`, {
    nome,
    email,
    apelido,
    dataNascimento,
    senha,
    img,
    timeId,
  });

  return response.data;
}
