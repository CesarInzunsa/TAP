package mx.edu.ittepic.tap_u5_ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //CALCULAR
        button.setOnClickListener {
            var valor1 = numero1.text.toString().toInt()
            var valor2 = numero2.text.toString().toInt()

            var opcionCalcular = spinner.selectedItemPosition
            var resultado = 0

            when(opcionCalcular){
                0 -> {
                    resultado = valor1 + valor2
                }
                1 -> {
                    resultado = valor1 - valor2
                }
                2 -> {
                    resultado = valor1 * valor2
                }
                3 -> {
                    resultado = valor1 / valor2
                }
            }

            AlertDialog.Builder(this).setTitle("RESULTADO").setMessage("SU CALCULO FUE: ${resultado}")
                .setPositiveButton("OK", {d,i->d.dismiss()}).show()

            numero1.setText("")
            numero2.setText("")

        }

        //REGRESAR
        button2.setOnClickListener {
            finish()
        }
    }
}