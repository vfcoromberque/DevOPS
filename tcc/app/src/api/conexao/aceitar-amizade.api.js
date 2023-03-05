import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function aceitarAmizade({ id }) {
  await axiosInstance.put(`${API_URL}/conexoes/usuario/${id}/aceitar`);
}
