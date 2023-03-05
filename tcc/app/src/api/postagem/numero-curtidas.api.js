import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function numeroCurtidas(id) {
  const response = await axiosInstance.get(
    `${API_URL}/postagens/${id}/curtidas`
  );
  return response.data;
}
