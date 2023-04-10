package Cliente

import Constantes
import ConexionBD
import java.lang.Exception
import java.sql.PreparedStatement

class ClienteDAOImpl: ClienteDAO {
    private val conexion = ConexionBD(Constantes.url, Constantes.user, Constantes.password)

    override fun todosLosClientes(): List<Cliente> {
        conexion.conectar()
        val query = Constantes.select_allClientes
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val clientes = ArrayList<Cliente>()

        while(rs?.next() == true){
            val cliente = Cliente(rs.getString(Constantes.nombre_dni), rs.getString(Constantes.nombre_cliente),
            rs.getString(Constantes.nombre_apellido), rs.getInt(Constantes.nombre_edad),
                rs.getString(Constantes.nombre_sexo))
            clientes.add(cliente)
        }

        st?.close()
        conexion.desconectar()
        return clientes
    }

    override fun insertarCliente(cliente:Cliente):Boolean{
        conexion.conectar()
        var ps: PreparedStatement? = null
        var insertado: Boolean
        var result:Int?= null
        val query = Constantes.insert_Cliente
        ps = conexion.getPreparedStatement(query)
        try {
            ps?.setString(1,cliente.dni)
            ps?.setString(2,cliente.nombre)
            ps?.setString(3,cliente.apellido)
            ps?.setInt(4,cliente.edad)
            ps?.setString(5,cliente.sexo)
            result = ps?.executeUpdate()
            insertado = true
        }catch (e: Exception){
            insertado = false
        }
        return insertado
    }

    override fun deleteCliente(cliente:Cliente):Boolean{
        var ps: PreparedStatement? = null
        var result: Int? = null
        var delete: Boolean

        try{
            conexion.conectar()
            val query = Constantes.delete_Cliente
            ps = conexion.getPreparedStatement(query)
            ps?.setString(1,cliente.dni)
            result = ps?.executeUpdate()
            delete = true
        }catch (e: Exception){
            delete = false
        }finally {
            ps?.close()
            conexion.desconectar()
        }

        return delete
    }

}














