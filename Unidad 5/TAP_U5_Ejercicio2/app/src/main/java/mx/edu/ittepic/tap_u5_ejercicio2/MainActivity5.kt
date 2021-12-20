package mx.edu.ittepic.tap_u5_ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main5.*
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        abrir.setOnClickListener {
            if (abrirMemoriaInterna()){
                AlertDialog.Builder(this).setMessage("SE RECUPERO DATA").show()
            }
        }

        regresarArchivos2.setOnClickListener {
            finish()
        }

    }

    fun abrirMemoriaInterna() : Boolean{

        var data = ""

        try {
            var flujoEntrada = BufferedReader(InputStreamReader(openFileInput("almacen.txt")))
            data = flujoEntrada.readLine()
            resultado.setText(data)
            flujoEntrada.close()

        }catch (io:Exception){
            AlertDialog.Builder(this).setTitle("ATENCION").setMessage("ERROR! NO SE PUDO ABRIR ARCHIVO").show()
        }

        return false
    }
}