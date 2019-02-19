package com.example.migueljaimes.conversor;

public class Longitud {

    public double CalculoLongitud(int Spinner1,int Spinner2,double valor){
        double resultado = 0;
        if (Spinner1 == 1){
            if (Spinner2 ==2)
            {
                resultado = valor * 1000;
            }
            else if (Spinner2 == 3)
            {
                resultado = valor / 1.609;
            }
        }
        if(Spinner1 == 2){
            if (Spinner2 ==1)
            {
                resultado = valor/1000;
            }
            else if (Spinner2 == 3)
            {
                resultado = valor /1609.344;
            }
        }
        if(Spinner1 == 3){
            if (Spinner2 ==1)
            {
                resultado = valor * 1.609;
            }
            else if (Spinner2 == 2)
            {
                resultado = valor * 1609.344;
            }
        }
        return resultado;
    }

}
