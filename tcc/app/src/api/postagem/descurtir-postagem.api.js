import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function descurtirPostagem({ id }) {
  await axiosInstance.delete(`${API_URL}/curtidas/postagem/${id}/descurtir`);
}
