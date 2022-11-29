package com.example.miprimeraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_layout)

        val input = findViewById<TextInputLayout>(R.id.textField)

        val image = findViewById<ImageView>(R.id.img1)
        image.setImageResource(R.drawable.panamiguel)

        val btn1=findViewById<Button>(R.id.boton1)
        btn1.setOnClickListener {
            Glide.with(this)
                .load("https://pbs.twimg.com/profile_images/1424438237427236865/-ycW6ovT_400x400.jpg")
                .into(image)

            val textoInput = input.editText?.text.toString()
            if(textoInput == "")
            {
                Toast.makeText(this,"Ingresa tu numero",Toast.LENGTH_LONG)
                input.error = "Negativo, no metiste nada we"
            }else{
                input.isErrorEnabled = false
                textoInput.toInt()
                MaterialAlertDialogBuilder(this)
                    .setTitle("Juan")
                    .setMessage("El numero ingresado es: $textoInput")
                    .setNeutralButton("Cancelar"){ dialog, which ->
                        Toast.makeText(this,":(",Toast.LENGTH_LONG).show()
                    }
                    .setPositiveButton("Aceptar") { dialog, which ->
                        Toast.makeText(this,":)",Toast.LENGTH_LONG).show()
                    }
                    .show()
            }
        }

        /*val btn1=findViewById<Button>(R.id.btn1)
        val btn2=findViewById<Button>(R.id.btn2)
        val texto=findViewById<TextView>(R.id.txt1)

        initListeners(btn1,btn2,texto)*/
    }

    private fun initListeners(btn1: Button, btn2: Button, texto: TextView) {
        btn1.setOnClickListener { view ->
            Toast.makeText(this, "Hola pana miguel", Toast.LENGTH_LONG).show()
        }
        btn2.setOnClickListener { view ->
            texto.text="Hola pana miguel"
        }
    }
}