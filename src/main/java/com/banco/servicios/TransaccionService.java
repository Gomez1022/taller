package com.banco.servicios;

import java.util.Map;

import com.banco.entidades.Transacciones;
import com.banco.repositorios.TransaccionRepositorio;

public class TransaccionService {
    private TransaccionRepositorio transaccionRepository;
    public TransaccionService(){
        transaccionRepository = new TransaccionRepositorio();
    }
    public void guardarTransaccion(Map datos){
        String fecha = (String) datos.get("fecha");
        String hora = (String) datos.get("hora");
        String tipoTransaccion = (String) datos.get("tipoTransaccion");
        double monto = (double) datos.get("monto");
        int idCuenta = (int) datos.get("idCuenta");
        String tipoCuentaDestino = "";
        if (datos.get("tipoCuentaDestino") == null){
            tipoCuentaDestino = "";
        } else {
            tipoCuentaDestino = (String) datos.get("tipoCuentaDestino");
        }

        Transacciones nuevaTransaccion = new Transacciones(fecha, hora, tipoTransaccion, monto, idCuenta, tipoCuentaDestino);
        transaccionRepository.guardar(nuevaTransaccion);
    }
}
