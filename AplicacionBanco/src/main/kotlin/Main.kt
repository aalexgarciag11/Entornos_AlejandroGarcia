import Cliente.*
import Cuenta.*



fun main(){
    var continuar = true
    var fn = Funcionalidades()
    while(continuar == true){
        var op = mostrarOpciones()
        when(op){
            1->{
                fn.iniciarSesion()
            }
            2->{
                fn.crearUsuario()
            }
            3->{
                when(mostrarOpcionesUsuario()){
                    1->{
                        fn.eliminarUsuario()
                    }
                }
            }
            4->{
                println("Identifiquese: ")
                var c = fn.iniciarSesion()
                fn.crearCuentaCorriente(c)
            }
            5->{
                when(mostrarOpcionesCuentaCorriente()){
                    1->{
                        fn.realizarIngreso(fn.seleccionarCuentas())
                    }
                    2->{
                        fn.realizarRetirada(fn.seleccionarCuentas())
                    }
                }
            }
        }
        Thread.sleep(2500)
        clearScreen()

    }
}

fun mostrarOpcionesCuentaCorriente():Int{
    println()
    println("1. Realizar ingreso")
    println("2. Realizar retirada")
    println()
    var op = readln().toInt()
    return op
}


fun mostrarOpciones():Int{
    println()
    println("Bienvenido al Banco de Alejandro.")
    println("Que desea realizar? ")
    println("1. Iniciar sesion")
    println("2. Crear usuario")
    println("3. Opciones de usuario")
    println("4. Crear cuenta corriente")
    println("5. Opciones cuenta corriente")
    println()
    var op = readln().toInt()
    return op
}

fun mostrarOpcionesUsuario():Int{
    println()
    println("1. Eliminar usuario")
    println()
    var op = readln().toInt()
    return op
}

fun clearScreen() {
    // Imprimir 50 líneas vacías
    for (i in 1..50) {
        println()
    }
}

