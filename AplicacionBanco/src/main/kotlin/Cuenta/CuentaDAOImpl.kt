package Cuenta
import Cliente.*
import ConexionBD
import Constantes
import java.lang.Exception
import java.sql.PreparedStatement

class CuentaDAOImpl:CuentaDAO {
    private val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)

    override fun insertarCuenta(c:Cuenta):Boolean{
        conexion.conectar()
        var ps: PreparedStatement? = null
        var insertado: Boolean
        var result: Int? = null
        val query = Constantes.insert_Cuenta
        ps = conexion.getPreparedStatement(query)
        try {
            ps?.setString(1, c.dni_cliente)
            ps?.setString(2, c.isbn)
            ps?.setInt(3, c.cant_dinero)
            result = ps?.executeUpdate()
            insertado = true
        }catch (e: Exception){
            insertado = false
        }
        return insertado
    }

    override fun ingreso(c: Cuenta, d: Int): Boolean {
        conexion.conectar()
        var result: Int?= null
        val query = Constantes.ingresarDinero
        val ps = conexion.getPreparedStatement(query)
        try {
            ps?.setInt(1,d)
            ps?.setString(2,c.isbn)
            result = ps?.executeUpdate()
            println("Dinero añadido con exito. ")
        }catch (e: Exception){
            println("No se ha podido añadir el dinero")
        }finally {
            ps?.close()
            conexion.desconectar()
        }

        return result == 1
    }

    override fun retiro(c: Cuenta, d: Int): Boolean {
        conexion.conectar()
        var result: Int?= null
        val query = Constantes.retirarDinero
        val ps = conexion.getPreparedStatement(query)
        try {
            ps?.setInt(1,d)
            ps?.setString(2,c.isbn)
            result = ps?.executeUpdate()
            println("Dinero retirado con exito. ")
        }catch (e: Exception){
            println("No se ha podido retirar el dinero")
        }finally {
            ps?.close()
            conexion.desconectar()
        }

        return result == 1
    }

    override fun eliminarCuenta(c: Cuenta): Boolean {
        conexion.conectar()
        var result: Int?=null
        val query = Constantes.deleteCuenta
        var ps: PreparedStatement? = null

        try {
            conexion.conectar()
            val query = Constantes.deleteCuenta
            ps = conexion.getPreparedStatement(query)
            ps?.setString(1, c.isbn)
            result = ps?.executeUpdate()
            println("Cuenta eliminada con exito. ")
        } catch (e: Exception) {
            println("No se ha podido eliminar la cuenta.")
        } finally {
            ps?.close()
            conexion.desconectar()
        }
        return result == 1
    }

    override fun todasLasCuentas(): List<Cuenta> {
        conexion.conectar()
        val query = Constantes.select_cuenta
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val cuentas = ArrayList<Cuenta>()

        while(rs?.next() == true){
            val cuenta = Cuenta(rs.getString(Constantes.nombre_dniCliente)
            , rs.getString(Constantes.nombre_isbn), rs.getInt(Constantes.nombre_cantDinero))
            cuentas.add(cuenta)
        }

        st?.close()
        conexion.desconectar()
        return cuentas
    }

}