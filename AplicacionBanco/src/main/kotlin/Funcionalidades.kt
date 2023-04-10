import Cliente.*
import Cuenta.*

class Funcionalidades {
    var clienteDAOImpl = ClienteDAOImpl()
    var cuentaDAOImpl = CuentaDAOImpl()

    fun crearUsuario(){
        println("Introduce tu DNI: ")
        var dni = readln().toString()
        println("Introduce tu nombre: ")
        var nombre = readln().toString()
        println("Introduce tu apellido: ")
        var apellido = readln().toString()
        println("Introduce tu edad: ")
        var edad = readln().toInt()
        println("Introduce tu sexo (H/M): ")
        var sexo = readln().toString()
        var c = Cliente(dni,nombre,apellido,edad,sexo)
        var i = clienteDAOImpl.insertarCliente(c)
        if(i){
            println("Cuenta creada con exito.")
        }else{
            println("Fallo al crear la cuenta. ")
        }

    }

    fun iniciarSesion():Cliente{
        var solucion: Cliente = Cliente()
        println("Buenos dias.")
        println("Que cliente es usted? ")
        var clientes = clienteDAOImpl.todosLosClientes()
        for (i in clientes){
            println(i.toString())
        }
        println("Introduzca su dni: ")
        var dni = readln().toString()

        for (i in clientes){
            if(i.dni == dni){
                solucion = i
                println()
                println("Bienvenido ${i.nombre}")
            }
        }
        return solucion
    }

    fun eliminarUsuario(){
        println("Cual es tu DNI? ")
        var usuarios = clienteDAOImpl.todosLosClientes()
        for (i in usuarios){
            println(i.toString())
        }
        var dni = readln().toString()
        for(i in usuarios){
            if(dni == i.dni){
                var n = clienteDAOImpl.deleteCliente(i)
                if(n){
                    println("Usuario eliminado con exito. ")
                }
            }
        }

    }

    fun crearCuentaCorriente(c:Cliente){
        var cuenta = Cuenta(c.dni,0)
        var n = cuentaDAOImpl.insertarCuenta(cuenta)

        if(n){
            println("Cuenta creada.")
        }else{
            println("No se ha podido crear la cuenta.")
        }
    }

    fun eliminarCuentaCorriente(){
        println("Que cuenta desea eliminar? ")
        var cuentas = cuentaDAOImpl.todasLasCuentas()
        var cuentaEliminar = Cuenta()
        for (i in cuentas){
            println(i.toString())
        }
        println("Introduzca el isbn: ")
        var isbn = readln().toString()

        for (i in cuentas){
            if(isbn == i.isbn){
                cuentaEliminar = i
            }
        }
        cuentaDAOImpl.eliminarCuenta(cuentaEliminar)
    }

    fun realizarIngreso(c:Cuenta){
        println("Cuanto dinero desea ingresar: ")
        var dinero = readln().toInt()
        cuentaDAOImpl.ingreso(c, dinero)
    }

    fun realizarRetirada(c:Cuenta){
        println("Cuanto dinero desea retirar: ")
        var dinero = readln().toInt()
        cuentaDAOImpl.retiro(c, dinero)
    }

    fun seleccionarCuentas():Cuenta{
        var cuenta = Cuenta()
        var cuentas = cuentaDAOImpl.todasLasCuentas()
        for (i in cuentas){
            println(i.toString())
        }
        println("Introduzca el isbn: ")
        var isbn = readln().toString()

        for (i in cuentas){
            if(isbn == i.isbn){
                cuenta = i
            }
        }

        return cuenta
    }

}