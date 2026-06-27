package com.devliyez.asignarcarga.services.DetalleCarga;

import java.util.ArrayList;
import java.util.List;

public class CotizacionCalculos {


    public List<Double> valoresTotales(List<Double> volumen, List<Double> pesos){

        Double volumen_total = 0.0;
        Double peso_total = 0.0;

        for(Integer i = 0; i < volumen.size(); i++){

            volumen_total += volumen.get(i);
        }

        for(Integer i = 0; i < pesos.size(); i++){

            peso_total += pesos.get(i);
        }

        List<Double> valores = new ArrayList<>();
        valores.add(volumen_total);
        valores.add(peso_total);
        return valores;
    }

    private double cotizar(double pesoTotal, double volumenTotal) {
        double costoBase = 100.00;
        double precioPorKg = 0.50;
        double precioPorVolumen = 2.00;

        return costoBase + (pesoTotal * precioPorKg) + (volumenTotal * precioPorVolumen);
    }





}
