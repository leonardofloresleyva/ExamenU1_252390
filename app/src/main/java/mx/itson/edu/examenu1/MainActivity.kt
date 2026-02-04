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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}