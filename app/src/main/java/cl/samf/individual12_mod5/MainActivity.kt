package cl.samf.individual12_mod5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
fun main(){
    var usuarios = mutableListOf<Usuario>()
    println("ingresar cantidad de usuarios")
    val cantidadusuarios = readln().toInt()
    for (i in 1..cantidadusuarios){
        println("Ingresa el Nombre")
        var nombre = readln()
        while(!validarNombre(nombre)){
            println("nombre invalido, ingresar un nombre valido")
            nombre = readln()
        }
        println("Ingresa el apellido")
        var apellido = readln()
        while (!validarApellido(apellido)){
            println("apellido invalido, ingresar un apellido valido")
            apellido = readln()
        }
        println("Ingresa edad")
        var edad = readln().toInt()
        while (!validarEdad(edad)) {
            println("edad no valida, ingresar una edad valida (numerica)")
            edad = readln().toInt()
        }
        println("Ingresa correo")
        var correo = readln()
        while (!validarCorreo(correo)) {
            println("correo no valido, ingresar un correo valido")
            correo = readln()
        }
        println("Ingresa Sistema de Salud, indicar Fonasa, Isapre, Particular")
        var sistemaSalud = readln()
        while (!validarSistemaSalud(sistemaSalud)) {
            println("Sistema de salud no valido, ingresar igual a lo indicado para que sea valido")
            sistemaSalud = readln()
        }
        var usuario = Usuario(nombre, apellido, edad, correo, sistemaSalud)
        usuarios.add(usuario)
    }
    for (u in usuarios){
        println(u)
    }
}
fun validarNombre(nombre: String) :Boolean{
    return nombre.length in 1..20 && nombre.all { it.isLetterOrDigit() }
}

fun validarApellido(apellido: String) :Boolean{
    val regex = Regex("^[a-zA-Z]+$")
    return regex.matches(apellido)
}

fun validarEdad(edad: Int) :Boolean{
    return true
}

fun validarCorreo(correo: String) :Boolean{
    val regex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
    return regex.matches(correo)
}

fun validarSistemaSalud(sistemaSalud: String) :Boolean{
    val opcionesValidas = listOf("Fonasa", "Isapre", "Particular")
    return sistemaSalud in opcionesValidas
}

data class Usuario (var nombre: String, var apellido: String, var edad: Int, var correo: String, var sistemaSalud: String){

}