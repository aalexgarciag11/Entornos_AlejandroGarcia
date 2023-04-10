package Cliente

class Cliente {

    var dni = ""
    var nombre = ""
    var apellido = ""
    var edad = 0
    var sexo = ""

    constructor(d:String, n:String, a:String, e:Int, s:String){
        this.dni = d
        this.nombre = n
        this.apellido = a
        this.edad = e
        this.sexo = s
    }
    constructor()

    override fun toString(): String {
        return "Cliente(dni=$dni, nombre=$nombre, apellido=$apellido, edad=$edad, sexo=$sexo"
    }



}