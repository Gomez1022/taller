package com.banco.repositorios;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.banco.entidades.Cuenta;



public class CuentaRepositorio implements Repositorio {
    private String cadenaConexion;

    public CuentaRepositorio() {
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            cadenaConexion = "jdbc:sqlite:banco.db";
            crearTabla();
        } catch (SQLException e) {
            System.err.println("Error de conexión con la base de datos: " + e);
        }

    }

    private void crearTabla() {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {

            String sql = "CREATE TABLE IF NOT EXISTS CUENTAS(\n" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "NUMERO_CUENTA TEXT NOT NULL UNIQUE,\n" +
                        "SALDO REAL NOT NULL,\n" +
                        "TIPO_CUENTA TEXT NOT NULL,\n" +
                        "ID_USUARIO INTEGER NOT NULL,\n" +
                        "FOREIGN KEY(ID_USUARIO) REFERENCES USUARIOS(ID)\n" +
                        ");";

            Statement sentencia = conexion.createStatement();
            sentencia.execute(sql);

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }

    @Override
    public void guardar(Object objeto) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)){
            Cuenta cuenta = (Cuenta) objeto;
            String sentenciaSQL = "INSERT INTO CUENTAS (NUMERO_CUENTA, SALDO, TIPO_CUENTA, ID_USUARIO) " +
                    "VALUES('" + cuenta.getNumeroCuenta() + "', " +
                    "" + cuenta.getSaldo() + ", " +
                    "'" + cuenta.getTipoCuenta() + "', " +
                    "" + cuenta.getIdUsuario() + ");";
            Statement sentencia=conexion.createStatement();
            sentencia.execute(sentenciaSQL);
        } catch (SQLException e) {
            System.out.println("Error de conexion"+e);
        }catch(Exception e){
            System.out.println("Error"+ e.getMessage());
        }
    }

    @Override
    public void eliminar(String cedula) {
 
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public void actualizar(Object objeto, String id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public Object buscar(String cedula) {
    
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public List<?> listar() {
    
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    @Override
    public void actualizarId(Object objeto, String id) {
       
        throw new UnsupportedOperationException("Unimplemented method 'actualizarId'");
    }
    
}
