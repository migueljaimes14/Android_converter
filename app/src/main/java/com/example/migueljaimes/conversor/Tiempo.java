package com.example.migueljaimes.conversor;

public class Tiempo {
    public double CalculoTiempo(int Spinner1,int Spinner2,double valor){
        double resultado = 0;
        if (Spinner1 == 1){
            if (Spinner2 ==2)
            {
                resultado = valor / 3600;
            }
            else if (Spinner2 == 3)
            {
                resultado = valor / 86400;
            }
        }
        if(Spinner1 == 2){
            if (Spinner2 ==1)
            {
                resultado = valor * 3600;
            }
            else if (Spinner2 == 3)
            {
                resultado = valor / 24;
            }
        }
        if(Spinner1 == 3){
            if (Spinner2 ==1)
            {
                resultado = valor * 86400;
            }
            else if (Spinner2 == 2)
            {
                resultado = valor * 24;
            }
        }
        return resultado;
    }

}
