import { axiosInstance } from "../base/axios-instance.api";
import { API_URL } from "../../constants/api.constant";

export async function login({ username, password }) {
  const response = await axiosInstance.post(
    `${API_URL}/login`,
    {},
    {
      auth: {
        username,
        password,
      },
    }
  );

  return response.data;
}
