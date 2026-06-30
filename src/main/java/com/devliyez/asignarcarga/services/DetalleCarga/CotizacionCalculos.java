package com.devliyez.asignarcarga.services.DetalleCarga;

import com.devliyez.asignarcarga.model.DetalleCarga;

import java.util.ArrayList;
import java.util.List;
import com.devliyez.asignarcarga.repository.DetalleCargaRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CotizacionCalculos {

    private final DetalleCargaRepository detalleCargaRepository;

    public List<Double> asignarValores(Long cargaid){

        //Buscar valores volumen y peso de los detalles
        List<DetalleCarga> detalles_carga = detalleCargaRepository.findByCargaId(cargaid);

        List<Double> pesos_contador = new ArrayList<>();
        List<Double> volumen_contador = new ArrayList<>();

        for(Integer i = 0; i < detalles_carga.size() ;i++){
            pesos_contador.add(detalles_carga.get(i).getPeso());
        }

        for(Integer i = 0 ; i <detalles_carga.size() ; i++){
            volumen_contador.add(detalles_carga.get(i).getVolumen());
        }

        //SUMAR a una variable double
        Double pesos_total = 0.0;
        Double volumen_total = 0.0;

        for(Integer i = 0; i < volumen_contador.size(); i++){
            volumen_total += volumen_contador.get(i);
        }

        for(Integer i = 0; i < pesos_contador.size(); i++){

            pesos_total += pesos_contador.get(i);
        }

        List<Double> valores = new ArrayList<>();
        valores.add(volumen_total);//0 : volumen
        valores.add(pesos_total);//1 : peso
        return valores;
    }

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
