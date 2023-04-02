package com.banco.entidades;

public class Transacciones {
    private int id;
    private String fecha;
    private String hora;
    private String tipoTransaccion;
    private double monto;
    private int idCuenta;
    private String tipoCuentaDestino;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getTipoTransaccion() {
        return tipoTransaccion;
    }
    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public int getIdCuenta() {
        return idCuenta;
    }
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }
    public String getTipoCuentaDestino() {
        return tipoCuentaDestino;
    }
    public void setTipoCuentaDestino(String tipoCuentaDestino) {
        this.tipoCuentaDestino = tipoCuentaDestino;
    }
    public Transacciones(int id, String fecha, String hora, String tipoTransaccion, double monto, int idCuenta,
            String tipoCuentaDestino) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.idCuenta = idCuenta;
        this.tipoCuentaDestino = tipoCuentaDestino;
    }
    public Transacciones(String fecha, String hora, String tipoTransaccion, double monto, int idCuenta,
            String tipoCuentaDestino) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.idCuenta = idCuenta;
        this.tipoCuentaDestino = tipoCuentaDestino;
    }
}
