package com.example.contestcakeapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var etNombre: EditText
    private lateinit var etApellido: EditText
    private lateinit var etEdad: EditText
    private lateinit var etConcurso: EditText
    private lateinit var cbEdad: CheckBox
    private lateinit var cbContest: CheckBox
    private lateinit var registrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setListeners()
    }

    private fun initViews() {
        etNombre = findViewById(R.id.nombre)
        etApellido = findViewById(R.id.apellido)
        etEdad = findViewById(R.id.editTextEdad)
        etConcurso = findViewById(R.id.editTextConcurso)
        cbEdad = findViewById(R.id.checkBoxAge)
        cbContest = findViewById(R.id.checkBoxContest)
        registrar = findViewById(R.id.registro)
    }

    private fun setListeners() {
        registrar.setOnClickListener { validarCampos() }
    }

    fun onCheck(view: View) {
        when (view.id) {
            R.id.checkBoxAge -> showEditTextAge(view)
            R.id.checkBoxContest -> showEditTextContest(view)
        }
    }

    private fun showEditTextAge(view: View) {
        if ((view as CheckBox).isChecked) {
            findViewById<View>(R.id.editTextEdad).visibility = View.VISIBLE
        } else {
            findViewById<View>(R.id.editTextEdad).visibility = View.GONE
        }
    }

    private fun showEditTextContest(view: View) {
        if ((view as CheckBox).isChecked) {
            findViewById<View>(R.id.editTextConcurso).visibility = View.VISIBLE
        } else {
            findViewById<View>(R.id.editTextConcurso).visibility = View.GONE
        }
    }

    private fun validarCampos() {
        val nombre = etNombre.text.toString()
        val apellido = etApellido.text.toString()
        val edad = etEdad.text.toString()
        var message = resources.getString(R.string.validate_str_success)
        if (nombre.isEmpty()) {
            message = resources.getString(R.string.error_name)
        }
        if (apellido.isEmpty()) {
            message = resources.getString(R.string.error_apellido)
        }
        if (edad.isEmpty()) {
            message = resources.getString(R.string.error_edad)
        } else if (edad.toInt() < 18) {
            message = resources.getString(R.string.error_menor)
        }
        showToast(message)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
