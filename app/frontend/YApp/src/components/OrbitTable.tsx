import OrbiteeCard from "./OrbiteeCard";
import type { YapperCardProps } from "./YapperCard";

interface OrbitTableProps{
    orbiterId: string;
    yappersArr:YapperCardProps[]
}

export default function OrbitTable({orbiterId, yappersArr}:OrbitTableProps){
    return (<>
                <table style={{ borderCollapse: "collapse", width: "100%" }}>
                <tbody>
                    <tr>
                        {yappersArr.map((yapper) => (
                            <td key={yapper.yapperId}>
                                <OrbiteeCard orbiterId={orbiterId} yapperCardProps={yapper} />
                            </td>
                        ))}
                    </tr>
                </tbody>
            </table>
    </>);
}