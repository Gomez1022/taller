package com.banco.repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.banco.entidades.Cuenta;
import com.banco.entidades.Transacciones;

public class TransaccionRepositorio implements Repositorio {

    private String cadenaConexion;

    public TransaccionRepositorio() {
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

            String sql = "CREATE TABLE IF NOT EXISTS TRANSACCIONES(\n" +
                            "ID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                            "FECHA TEXT NOT NULL,\n" +
                            "HORA TEXT NOT NULL,\n" +
                            "TIPO_TRANSACCION TEXT NOT NULL,\n" +
                            "MONTO REAL NOT NULL,\n" +
                            "ID_CUENTA INTEGER NOT NULL,\n" +
                            "TIPO_CUENTA_DESTINO TEXT,\n" +
                            "FOREIGN KEY(ID_CUENTA) REFERENCES CUENTAS(ID)\n" +
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
            Transacciones transaccion = (Transacciones) objeto;
            String sentenciaSQL ="INSERT INTO TRANSACCIONES (FECHA, HORA, TIPO_TRANSACCION, MONTO, ID_CUENTA, TIPO_CUENTA_DESTINO)" +
            "VALUES('" + transaccion.getFecha() + "', " +
            "'" + transaccion.getHora() + "', " +
            "'" + transaccion.getTipoTransaccion() + "', " +
            "" + transaccion.getMonto() + ", " +
            "" + transaccion.getIdCuenta() + ", " +
            "'" + transaccion.getTipoCuentaDestino() + "');";
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
