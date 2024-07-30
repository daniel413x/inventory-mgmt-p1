import { useState } from "react";
import "./App.css";
import { Dashboard } from "./pages/Dashboard";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Login } from "./pages/Login";
import { Warehouses } from "./pages/Warehouses";
import { Inventory } from "./pages/Inventory";
import { Products } from "./pages/Products";
import { Sidebar } from "./components/Sidebar";

function App() {
  // TODO: set to false once implementing users
  const [isLoggedIn, setIsLoggedIn] = useState(true);

  return (
    <>
      {isLoggedIn && <Sidebar />}
      <BrowserRouter>
        <Routes>
          {isLoggedIn && <Route path="/" element={<Dashboard />} />}
          {!isLoggedIn && <Route path="/" element={<Login />} />}
          <Route path="/warehouses" element={<Warehouses />} />
          <Route path="/inventory" element={<Inventory />} />
          <Route path="/products" element={<Products />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
