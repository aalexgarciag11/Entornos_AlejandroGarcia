package Cuenta

import kotlin.random.Random

class Cuenta {
    var dni_cliente = ""
    var isbn = ""
    var cant_dinero = 0

    constructor(d:String, c:Int){
        this.dni_cliente = d
        this.isbn = Random.nextInt(0,10000).toString()
        this.cant_dinero = c
    }

    constructor(d:String,i:String,c:Int){
        this.dni_cliente = d
        this.isbn = i
        this.cant_dinero = c
    }

    constructor()

    override fun toString(): String {
        return "Cuenta(Dni Cliente=$dni_cliente, isbn=$isbn, cantidad disponible=$cant_dinero)"
    }

}