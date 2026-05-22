import { useState } from "react";
import Button from "./Button";

export default function OrbitButton() {
    const [isActive, setIsActive] = useState<boolean>(false);

    const getLabel = () : string => {
        return isActive ? "Unorbit":"Orbit";
    }

    const handleClick = () : void => {
        const nextState = !isActive;
        setIsActive(nextState);
        alert(getLabel() + " Button Clicked! Hooray!!!!!! Less go vro :))")
    }

    return (
        <>
            <Button
                text={getLabel()}
                onClick={handleClick}
            />
        </>
    );
}
