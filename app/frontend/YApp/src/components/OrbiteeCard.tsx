import type { ButtonProps } from "./Button";
import Button from "./Button";
import type { YapperCardProps } from "./YapperCard";
import YapperCard from "./YapperCard";

interface OrbiteeCardProps{
    yapperCardProps:YapperCardProps;
    buttonProps:ButtonProps;
}

export default function OrbiteeCard({yapperCardProps, buttonProps}: OrbiteeCardProps) {
    return <>
    <YapperCard {...yapperCardProps} />
    <Button {...buttonProps} />
    </>;
}
