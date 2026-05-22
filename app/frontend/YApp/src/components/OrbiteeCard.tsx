import OrbitButton from "./OrbitButton";
import type { YapperCardProps } from "./YapperCard";
import YapperCard from "./YapperCard";

interface OrbiteeCardProps{
    yapperCardProps:YapperCardProps;
}

export default function OrbiteeCard({yapperCardProps}: OrbiteeCardProps) {
    return <>
    <YapperCard {...yapperCardProps} />
    <OrbitButton />
    </>;
}
