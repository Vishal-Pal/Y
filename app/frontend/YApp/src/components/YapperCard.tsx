export interface YapperCardProps{
    yapperId:string;
    yapperName:string;
}

export default function YapperCard({yapperId, yapperName}:YapperCardProps){
    return (<>
    <h2>"{yapperName}"</h2>
    <h3>@{yapperId}</h3>
    </>);
}