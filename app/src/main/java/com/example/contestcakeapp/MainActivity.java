package com.example.contestcakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etNombre, etApellido, etEdad, etConcurso;
    CheckBox cbEdad, cbContest;
    RadioButton rb1, rb2;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        setListeners();
    }

    private void initViews() {
        etNombre = findViewById(R.id.nombre);
        etApellido = findViewById(R.id.apellido);
        etEdad = findViewById(R.id.editTextEdad);
        etConcurso = findViewById( R.id.editTextConcurso);
        cbEdad = (CheckBox) findViewById(R.id.checkBoxAge);
        cbContest = (CheckBox) findViewById(R.id.checkBoxContest);
        rb1= (RadioButton) findViewById(R.id.hombre);
        rb2 = (RadioButton) findViewById(R.id.mujer);
        registrar = (Button) findViewById(R.id.registro);
    }

    private void setListeners() {
        registrar.setOnClickListener( view -> validarCampos() );
    }

    public void OnCheck(View view) {
        switch (view.getId()) {
            case R.id.checkBoxAge:
                showEditTextAge(view);
                break;
            case R.id.checkBoxContest:
                showEditTextContest(view);
                break;
        }
    }

    private void showEditTextAge(View view) {
        if (((CheckBox)view).isChecked()) {
            findViewById(R.id.editTextEdad).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.editTextEdad).setVisibility(View.GONE);
        }
    }
    private void showEditTextContest(View view) {
        if (((CheckBox)view).isChecked()) {
            findViewById(R.id.editTextConcurso).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.editTextConcurso).setVisibility(View.GONE);
        }
    }

    private void validarCampos(){
        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String edad = etEdad.getText().toString();
        String otroConcurso = etConcurso.getText().toString();
        String message = getResources().getString(R.string.validate_str_success);
        if (nombre.isEmpty()){
            message = getResources().getString(R.string.error_name);
        }
        if (apellido.isEmpty()){
            message = getResources().getString(R.string.error_apellido);
        }
        if (edad.isEmpty()){
            message = getResources().getString(R.string.error_edad);
        } else if (Integer.parseInt(edad)<18){
            message = getResources().getString(R.string.error_menor);
        }

        showToast(message);
    }

    private void showToast(String message) {
        Toast.makeText(this, message,Toast.LENGTH_LONG).show();
    }

}