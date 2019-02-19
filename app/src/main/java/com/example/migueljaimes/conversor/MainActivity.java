package com.example.migueljaimes.conversor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //  Spinners
    private int medida,valor_1,valor_2;
    // Arrays Spinners
    private int medida_array,longitud_array,tiempo_array,dato_array;
    //Opc Seleccionada
    private int opcSpinnerPrincipal,opcSpinnerSub1,opcSpinnerSub2;
    //Valor
    private EditText valorCampoTexto;
    private double valorCampoUser;
    // Boton conversor
    Button buttonEmpezar,buttonConvertir;
    //Calculos
    Longitud longitud;
    Tiempo tiempo;
    Divisa divisa;
    //Resultado
    private TextView resultadoFinal;
    private double resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inicializador();
        buttonConvertir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CrearSubSpinner(opcSpinnerPrincipal);
            }
        });
    }

    private void Inicializador(){
        buttonConvertir = (Button) findViewById(R.id.convertir);
        valorCampoTexto = (EditText) findViewById(R.id.valor_1);
        valorCampoUser = 1;
        medida = R.id.medida_spinner;
        valor_1 = R.id.unidad_1_spinner;
        valor_2 = R.id.unidad_2_spinner;
        medida_array = R.array.medida_array;
        longitud_array = R.array.longitud_array;
        tiempo_array = R.array.tiempo_array;
        dato_array = R.array.dato_array;
        CrearSpinner(medida, medida_array);
        resultadoFinal = (TextView) findViewById(R.id.resultado);
        longitud = new Longitud();
        tiempo = new Tiempo();
        divisa = new Divisa();
        resultado = 0;
        Log.d("cambio: ",String.valueOf(valorCampoUser));
    }

    private void CrearSpinner(int id, int id_array) {

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
                opcSpinnerPrincipal = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void CrearSubSpinner1(int id, int id_array) {

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
                opcSpinnerSub1 =position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void CrearSubSpinner2(int id, int id_array) {

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
                opcSpinnerSub2 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }




    private void CrearSubSpinner(int opc){

        switch (opc){
            case 1:
                CrearSubSpinner1(valor_1,longitud_array);
                CrearSubSpinner2(valor_2,longitud_array);
                resultado = longitud.CalculoLongitud(opcSpinnerSub1,opcSpinnerSub2,valorCampoUser);
                break;
            case 2:
                CrearSubSpinner1(valor_1,tiempo_array);
                CrearSubSpinner2(valor_2,tiempo_array);
                resultado = tiempo.CalculoTiempo(opcSpinnerSub1,opcSpinnerSub2,valorCampoUser);
                break;
            case 3:
                CrearSubSpinner1(valor_1,dato_array);
                CrearSubSpinner2(valor_2,dato_array);
                resultado = divisa.CalculoDivisa(opcSpinnerSub1,opcSpinnerSub2,valorCampoUser);
                break;
        }
        resultadoFinal.setText(Double.toString(resultado));
    }

}
