package com.example.migueljaimes.conversor;

public class Divisa {
    public double CalculoDivisa(int Spinner1,int Spinner2, double valor){
        double resultado = 0;
        if (Spinner1 == 1){
            if (Spinner2 ==2)
            {
                resultado = valor * 0.88;
            }
            else if (Spinner2 == 3)
            {
                resultado = valor * 110.77;
            }
        }
        if(Spinner1 == 2){
            if (Spinner2 ==1)
            {
                resultado = valor * 1.13;
            }
            else if (Spinner2 == 3)
            {
                resultado = valor * 125.20;
            }
        }
        if(Spinner1 == 3){
            if (Spinner2 ==1)
            {
                resultado = valor * 0.0080;
            }
            else if (Spinner2 == 2)
            {
                resultado = valor * 0.0090;
            }
        }
        return resultado;
    }
}
