class Constantes {
    companion object{
        val url= "jdbc:mysql://localhost/banco"
        val user= "root"
        val password = ""
        val forname = "com.mysql.cj.jdbc.Driver"


        //Tabla cliente
        val nombre_dni = "dni"
        val nombre_cliente = "nombre"
        val nombre_apellido = "apellido"
        val nombre_edad = "edad"
        val nombre_sexo = "sexo"

        val select_allClientes = "SELECT * FROM cliente"
        val insert_Cliente = "INSERT INTO cliente VALUES(?,?,?,?,?)"
        val delete_Cliente = "DELETE FROM cliente WHERE dni = ?"

        //Tabla cuenta
        val nombre_dniCliente = "dni_cliente"
        val nombre_isbn = "isbn"
        val nombre_cantDinero = "cant_dinero"

        val insert_Cuenta = "INSERT INTO CUENTA VALUES (?,?,?)"
        val ingresarDinero = "UPDATE CUENTA SET CANT_DINERO = (CANT_DINERO+?) WHERE ISBN = ?"
        val retirarDinero = "UPDATE CUENTA SET CANT_DINERO = (CANT_DINERO-?) WHERE ISBN = ?"
        val deleteCuenta = "DELETE FROM CUENTA WHERE ISBN = ?"
        val select_cuenta = "SELECT * FROM CUENTA"
    }
}