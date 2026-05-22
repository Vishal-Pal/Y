import OrbiteeCard from "./OrbiteeCard";
import type { YapperCardProps } from "./YapperCard";

interface OrbitTableProps{
    yappersArr:YapperCardProps[]
}

export default function OrbitTable({yappersArr}:OrbitTableProps){
    return (<>
                <table style={{ borderCollapse: "collapse", width: "100%" }}>
                <tbody>
                    <tr>
                        {yappersArr.map((yapper) => (
                            <td key={yapper.yapperId}>
                                <OrbiteeCard yapperCardProps={yapper} />
                            </td>
                        ))}
                    </tr>
                </tbody>
            </table>
    </>);
}