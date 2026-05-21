import YapperCard from "../components/YapperCard";
import ogYapper from "../test/resources/yapper/ogYapper.json";

export default function Home() {
    return (
        <>
            <h1>Welcome to YapIO</h1>
            <YapperCard {...ogYapper} />
        </>
    );
}
