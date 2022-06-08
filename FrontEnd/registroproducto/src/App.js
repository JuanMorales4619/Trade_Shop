import "./App.css";
import Publication from "./Componets/Publication";
import Topbar from "./Componets/Navbar";
import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import Lobby from "./Componets/Lobby";
import Myproducts from "./Componets/Myproducts";



function App() {
  return (
    
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Topbar />}>
            <Route index element={<Lobby />} />
            <Route path="/create" element={<Publication />} />
            <Route path="/find" element={<Myproducts />} />
            <Route path="*" element={<Navigate replace to="/" />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
