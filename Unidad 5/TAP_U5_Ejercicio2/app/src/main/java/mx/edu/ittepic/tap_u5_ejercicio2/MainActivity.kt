package mx.edu.ittepic.tap_u5_ejercicio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuprincipal.setOnItemClickListener { parent, view, position, id ->
            when(position){
                0 -> {
                    //Invocacion de un segundo activity desde el MainActivity
                    var ventana2 = Intent(this, MainActivity2::class.java)
                    startActivity(ventana2)
                }
                1 -> {
                    var ventana3 = Intent(this, MainActivity3::class.java)
                    startActivity(ventana3)
                }
                2 -> {
                    var ventana4 = Intent(this, MainActivity4::class.java)
                    startActivity(ventana4)
                }
                3 -> {
                    var ventana5 = Intent(this, MainActivity5::class.java)
                    startActivity(ventana5)
                }
                4 -> { mensaje() }
                5 -> { cerrar() }
            }
        }
    }

    //Construccion de un metodo
    fun mensaje(){
        AlertDialog.Builder(this).setTitle("ATENCION").setMessage("(C) DERECHOS RESERVADOS \nTECNOLOGICO DE TEPIC 2021")
            .setPositiveButton("OK", {d,i-> d.dismiss()}).show()
    }

    fun cerrar(){
        finish()
    }

    /*
    //Construccion de un metodo que retorna un valor
    fun otroMetodo():Int{
        var retorno = 9
        return retorno
    }
    */
}