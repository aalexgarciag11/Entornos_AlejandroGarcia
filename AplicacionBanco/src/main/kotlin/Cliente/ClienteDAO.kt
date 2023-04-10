package Cliente

interface ClienteDAO {
    fun todosLosClientes():List<Cliente>
    fun insertarCliente(cliente:Cliente):Boolean
    fun deleteCliente(cliente:Cliente):Boolean
}