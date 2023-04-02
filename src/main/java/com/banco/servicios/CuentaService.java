package com.banco.servicios;

import java.util.Map;

import com.banco.entidades.Cuenta;
import com.banco.repositorios.CuentaRepositorio;
import com.banco.repositorios.Repositorio;

public class CuentaService {
    private Repositorio repositorioCuenta;
    public CuentaService(){
        repositorioCuenta = new CuentaRepositorio();
    }
    public void guardarCuenta(Map datos) {
        String numeroCuenta = (String) datos.get("numeroCuenta");
        double saldo = (double) datos.get("saldo");
        String tipoCuenta = (String) datos.get("tipoCuenta");
        int idUsuario = (int) datos.get("idUsuario");

        Cuenta newCuenta = new Cuenta(numeroCuenta,saldo,tipoCuenta,idUsuario);
        repositorioCuenta.guardar(newCuenta);
    }
}
