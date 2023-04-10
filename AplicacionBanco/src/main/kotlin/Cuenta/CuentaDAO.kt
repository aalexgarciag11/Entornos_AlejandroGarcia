package Cuenta
import Cliente.*

interface CuentaDAO {
    fun insertarCuenta(c: Cuenta):Boolean
    fun ingreso(c:Cuenta,d:Int):Boolean
    fun retiro(c:Cuenta,d:Int):Boolean
    fun eliminarCuenta(c: Cuenta):Boolean
    fun todasLasCuentas(): List<Cuenta>
}