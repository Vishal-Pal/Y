interface YapperCardProps{
    yapperId:string;
    yapperName:string;
    about:string;
}

export default function YapperCard({yapperId, yapperName, about}:YapperCardProps){
    return (<>
    <h2>"{yapperName}"</h2>
    <h3>@{yapperId}</h3>
    <p>{about}</p>
    </>);
}