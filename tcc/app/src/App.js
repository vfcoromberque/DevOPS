import { RouterProvider } from "react-router-dom";
import "./App.css";
import { router } from "./router";
import { GlobalToastrProvider } from "./context/toastr/toastr.context";
import { GlobalUserProvider } from "./context/usuario/usuario.context";
import { Toastr } from "./ui/component";

function App() {
  return (
    <GlobalToastrProvider>
      <GlobalUserProvider>
        <div className="App">
          <RouterProvider router={router} />
        </div>
        <Toastr />
      </GlobalUserProvider>
    </GlobalToastrProvider>
  );
}

export default App;
