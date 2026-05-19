import { BrowserRouter, Routes, Route } from "react-router";
import RootLayout from "./layouts/RootLayout";
import Home from "./routes/Home";
import About from "./routes/About";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/* Layout Route */}
        <Route element={<RootLayout />}>
          {/* Index Route (corresponds to /) */}
          <Route path="yapp" element={<Home />} />
          {/* Explicit Paths */}
          <Route path="about" element={<About />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
