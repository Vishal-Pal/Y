import { Outlet, Link } from "react-router";

export default function RootLayout() {
  return (
    <div className="app-container">
      <nav style={{ display: "flex", gap: "1rem", padding: "1rem", background: "#f0f0f0" }}>
        <Link to="/yapp">Home</Link>
        <Link to="/about">About</Link>
      </nav>
      <main style={{ padding: "1rem" }}>
        {/* Child routes render right here */}
        <Outlet />
      </main>
    </div>
  );
}