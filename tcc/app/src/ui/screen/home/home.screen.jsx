import "./home.style.css";
import { ScreenWrapper } from "../../component";
import { InfoUsuario } from "../../component";
import { Feed } from "../../component";
import { Conexoes } from "../../component";

export function Home() {
  return (
    <ScreenWrapper>
      <div className="main_page">
        <div className="main_page_user_info">
          <InfoUsuario />
        </div>
        <div className="main_page_feed">
          <Feed />
        </div>
        <div className="main_page_connections">
          <Conexoes />
        </div>
      </div>
    </ScreenWrapper>
  );
}
