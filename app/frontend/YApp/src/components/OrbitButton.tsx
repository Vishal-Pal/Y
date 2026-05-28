import { useState } from "react";
import Button from "./Button";

interface OrbitButtonProps {
    orbiteeId: string;
    orbiterId: string;
}

export default function OrbitButton({orbiteeId,orbiterId}: OrbitButtonProps) {
    const baseUrl = `http://localhost:8080/api/v1/yappers/${orbiteeId}/orbiters`;
    const [isActive, setIsActive] = useState<boolean>(true);

    const getLabel = (): string => {
        return isActive ? "Orbit" : "UnOrbit";
    };

    const handleClick = (): void => {
        const nextState = !isActive;
        isActive ? createOrbiter(orbiterId) : deleteOrbiter(orbiterId);
        setIsActive(nextState);
        alert(getLabel() + " Button Clicked! Hooray!!!!!! Less go vro :))");
    };

    const createOrbiter = async (orbiterId: string) => {
        const url = baseUrl;
        const res = await fetch(url, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({orbiterId}),
        });
        res.ok ? alert(`Orbited them`):alert(`Cannot orbit fam! Status: ${res.status}`);
    };

    const deleteOrbiter = async (orbiterId: string) => {
        const url = `${baseUrl}/${orbiterId}`;
        const res = await fetch(url, {
            method: "DELETE",
            headers: { "Content-Type": "application/json" }
        });
        res.ok ? alert(`Exited their orbit`):alert(`Cannot exit fam! Status: ${res.status}`);
    };

    return (
        <>
            <Button text={getLabel()} onClick={handleClick} />
        </>
    );
}
