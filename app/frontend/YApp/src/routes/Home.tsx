import { useEffect, useState } from "react";
import OrbitTable from "../components/OrbitTable";
import YapperCard, { type YapperCardProps } from "../components/YapperCard";

export default function Home() {
    const [yappers, setYappers] = useState<YapperCardProps[]>([]);
    const [loading, setLoading] = useState(true);
    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch("http://localhost:8080/api/v1/yappers");
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                const result = await response.json();
                setYappers(result);
            } catch (err) {
                //setError(err);
            } finally {
                setLoading(false);
            }
        };

        fetchData();
    }, []);

    if (loading) return <p>Loading...</p>;

    const [ogYapper, ...otherYappers] = yappers;

    return (
        <>
            <h1>Welcome to YapIO</h1>
            <YapperCard {...ogYapper} />
            <br></br>
            <br></br>
            <OrbitTable yappersArr={otherYappers} />
        </>
    );
}
