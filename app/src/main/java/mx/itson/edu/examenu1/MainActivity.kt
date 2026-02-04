package mx.itson.edu.examenu1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Instanciar los elementos visuales
        val c=findViewById<EditText>(R.id.etC)
        val f=findViewById<EditText>(R.id.etF)
        val k=findViewById<EditText>(R.id.etK)
        val btnC=findViewById<Button>(R.id.btnGC)
        val btnF=findViewById<Button>(R.id.btnGF)
        val btnK=findViewById<Button>(R.id.btnGK)

        // Listener para botón de grados centígrados
        btnC.setOnClickListener {

        }

        // Listener para botón de grados fahrenheit
        btnF.setOnClickListener {

        }

        // Listener para botón de grados kelvin
        btnK.setOnClickListener {

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

// Funciones para las distintas conversiones de grados

// °C a °F
fun CF(c: Double) = c * 1.8 + 32
// °F a °C
fun FC(f: Double) = (f - 32) / 1.8

// °C a °K
fun CK(c: Double) = c + 273.15
// °K a °C
fun KC(k: Double) = k - 273.15

// °F a °K
fun FK(f: Double) = 5 * (f - 32) / 9 + 273.15
// °K a °F
fun KF(k: Double) = 9 * (k - 273.15) / 5 + 32