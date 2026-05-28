import OrbitButton from "./OrbitButton";
import type { YapperCardProps } from "./YapperCard";
import YapperCard from "./YapperCard";

interface OrbiteeCardProps{
    orbiterId: string;
    yapperCardProps:YapperCardProps;
}

export default function OrbiteeCard({orbiterId, yapperCardProps}: OrbiteeCardProps) {
    return <>
    <YapperCard {...yapperCardProps} />
    <OrbitButton orbiteeId={yapperCardProps.yapperId} orbiterId={orbiterId}/>
    </>;
}
