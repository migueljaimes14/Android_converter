package com.example.migueljaimes.conversor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int medidaId,botonId,valor_1,valor_2,medida_array,longitud_array,tiempo_array,dato_array,valorSelecionado;
    private Button botonConvertir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        medidaId = R.id.medida_spinner;
        valor_1 = R.id.unidad_1_spinner;
        valor_2 = R.id.unidad_2_spinner;
        medida_array = R.array.medida_array;
        longitud_array = R.array.longitud_array;
        tiempo_array = R.array.tiempo_array;
        dato_array = R.array.dato_array;
        botonId = R.id.convertir;
        CreateSpinner(medidaId,medida_array);
        botonConvertir = findViewById(botonId);
        botonConvertir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                seleccionSubSpinner(valorSelecionado);
            }
        });
    }


    private void CreateSpinner(int id, int id_array) {

        android.widget.Spinner spinner = (android.widget.Spinner) findViewById(id);
        // Crear un ArrayAdapter usando la matriz de cadenas y un diseño de giro predeterminado
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                id_array, android.R.layout.simple_spinner_item);
        // Especifique el diseño que se utilizará cuando aparezca la lista de opciones
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Aplicar cambios
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valorSelecionado = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void seleccionSubSpinner(int opc){
        switch (opc){
            case 0:
                CreateSpinner(valor_1,longitud_array);
                CreateSpinner(valor_2,longitud_array);
                break;
            case 1:
                CreateSpinner(valor_1,tiempo_array);
                CreateSpinner(valor_2,tiempo_array);
                break;
            case 2:
                CreateSpinner(valor_1,dato_array);
                CreateSpinner(valor_2,dato_array);
                break;
        }
    }


}
