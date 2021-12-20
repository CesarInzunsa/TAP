package mx.edu.ittepic.tap_u5_ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        button3.setOnClickListener {
            var txt1 = texto1.text.toString()
            var txt2 = texto2.text.toString()
            var resultado = txt1+" "+txt2
            textView.setText(resultado)
        }

    }

    //Sirve para agregar al activity un menu contextual
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuoculto, menu)
        return true
    }

    //Sirve para realizar acciones con los items del menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.regresarmenu -> {
                finish()
            }
            R.id.acercademenu -> {
                Toast.makeText(this, "C CESAR INZUNSA", Toast.LENGTH_LONG).show()
            }
        }
        return true
    }
}