import OrbitTable from "../components/OrbitTable";
import YapperCard from "../components/YapperCard";
import ogYapper from "../test/resources/mockData/yapper/ogYapper.json";
import otherYappers from "../test/resources/mockData/yapper/otherYappers.json";

export default function Home() {
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
