export interface ButtonProps{
    text:string;
    onClick: (event: React.MouseEvent<HTMLButtonElement>) => void;
}

export default function Button({ text, onClick }: ButtonProps) {
  return (
    <button onClick={onClick}>
      {text}
    </button>
  );
}