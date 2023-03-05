import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function curtirPostagem({ id }) {
  await axiosInstance.post(`${API_URL}/curtidas/postagem/${id}/curtir`);
}
