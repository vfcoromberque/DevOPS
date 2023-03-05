import { useEffect } from 'react'
import useGlobalToastr from '../../../context/toastr/toastr.context'
import './toastr.style.css'
const TOASTR_DELAY = 5000

export function Toastr() {
    const [toastrMessage, setToastrMessage] = useGlobalToastr()

    useEffect(() => {
        if (toastrMessage) {
            setTimeout(() => {
                setToastrMessage(null)
            }, TOASTR_DELAY)
        }
    }, [toastrMessage, setToastrMessage])

    if (!toastrMessage) return
    const style = toastrMessage?.success ? '__sucesso' : '__erro'

    return (
        <div className={`toastr-style${style}`}>
            <p>{toastrMessage.message}</p>
        </div>
    )
}
