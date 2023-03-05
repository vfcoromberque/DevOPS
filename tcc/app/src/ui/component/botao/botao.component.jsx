import './botao.style.css'

export function Botao({ text, onClick, disabled }) {
    return (
        <button onClick={onClick} className="button" disabled={disabled}>
            {text}
        </button>
    )
}
