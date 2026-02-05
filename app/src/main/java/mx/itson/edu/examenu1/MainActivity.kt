package mx.itson.edu.examenu1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
        val c =findViewById<EditText>(R.id.etC)
        val f =findViewById<EditText>(R.id.etF)
        val k =findViewById<EditText>(R.id.etK)
        val resultado = findViewById<TextView>(R.id.tvResultado)
        val btnC =findViewById<Button>(R.id.btnGC)
        val btnF =findViewById<Button>(R.id.btnGF)
        val btnK =findViewById<Button>(R.id.btnGK)
        val btnClean = findViewById<Button>(R.id.btnClean)

        // Listener para botón de grados centígrados
        btnC.setOnClickListener {
            if(isInputF(c, f, k)){
                val r = FC(f.text.toString().toDouble())
                resultado.text = String.format("%.2f °C", r)
            } else if(isInputK(c, f, k)){
                val r = KC(k.text.toString().toDouble())
                resultado.text = String.format("%.2f °C", r)
            } else resultado.text = "Ingrese un solo valor a convertir diferente de °C"
        }

        // Listener para botón de grados fahrenheit
        btnF.setOnClickListener {
            if(isInputC(c, f, k)){
                val r = CF(c.text.toString().toDouble())
                resultado.text = String.format("%.2f °F", r)
            } else if(isInputK(c, f, k)){
                val r = KF(k.text.toString().toDouble())
                resultado.text = String.format("%.2f °F", r)
            } else resultado.text = "Ingrese un solo valor a convertir diferente de °F"
        }

        // Listener para botón de grados kelvin
        btnK.setOnClickListener {
            if(isInputC(c, f, k)){
                val r = CK(c.text.toString().toDouble())
                resultado.text = String.format("%.2f °K", r)
            } else if(isInputF(c, f, k)){
                val r = FK(f.text.toString().toDouble())
                resultado.text = String.format("%.2f °K", r)
            } else resultado.text = "Ingrese un solo valor a convertir diferente de °K"
        }

        btnClean.setOnClickListener {
            if (!c.text.isNullOrBlank()) c.text.clear()
            if (!f.text.isNullOrBlank()) f.text.clear()
            if (!k.text.isNullOrBlank()) k.text.clear()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

// Funciones para las distintas conversiones de grados
/**
 * °C a °F
 */
fun CF(c: Double) = c * 1.8 + 32
/**
 * °F a °C
 */
fun FC(f: Double) = (f - 32) / 1.8
/**
 * °C a °K
 */
fun CK(c: Double) = c + 273.15
/**
 * °K a °C
 */
fun KC(k: Double) = k - 273.15
/**
 * °F a °K
 */
fun FK(f: Double) = 5 * (f - 32) / 9 + 273.15

/**
 * °K a °F
 */
fun KF(k: Double) = 9 * (k - 273.15) / 5 + 32

// Funciones adicionales para validar la entrada de datos
/**
 * Verifica si existe una única entrada de grados Celsius.
 */
fun isInputC(inputC: EditText, inputF: EditText, inputK: EditText): Boolean{
    val c = inputC.text.isNullOrBlank()
    val f = inputF.text.isNullOrBlank()
    val k = inputK.text.isNullOrBlank()

    return !c && f && k // Único valor en °C
}
/**
 * Verifica si existe una única entrada de grados Fahrenheit.
 */
fun isInputF(inputC: EditText, inputF: EditText, inputK: EditText): Boolean{
    val c = inputC.text.isNullOrBlank()
    val f = inputF.text.isNullOrBlank()
    val k = inputK.text.isNullOrBlank()

    return c && !f && k // Único valor en °F
}
/**
 * Verifica si existe una única entrada de grados Kelvin.
 */
fun isInputK(inputC: EditText, inputF: EditText, inputK: EditText): Boolean{
    val c = inputC.text.isNullOrBlank()
    val f = inputF.text.isNullOrBlank()
    val k = inputK.text.isNullOrBlank()

    return c && f && !k // Único valor en °K
}