import OrbiteeCard from "../components/OrbiteeCard";
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
            <table style={{ borderCollapse: "collapse", width: "100%" }}>
                <tbody>
                    <tr>
                        {otherYappers.map((yapper) => (
                            <td key={yapper.yapperId}>
                                <OrbiteeCard yapperCardProps={yapper} />
                            </td>
                        ))}
                    </tr>
                </tbody>
            </table>
        </>
    );
}
