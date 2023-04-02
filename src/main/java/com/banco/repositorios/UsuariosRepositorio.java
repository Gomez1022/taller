package com.banco.repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.banco.entidades.Usuarios;


public class UsuariosRepositorio implements Repositorio {
    private String cadenaConexion;

    public UsuariosRepositorio() {
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

            String sql = "CREATE TABLE IF NOT EXISTS USUARIOS (\n"
                        + "ID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                        + " NOMBRE TEXT NOT NULL,\n"
                        + " APELLIDO TEXT NOT NULL,\n"
                        + " CEDULA TEXT NOT NULL UNIQUE\n"
                        + ");";

            Statement sentencia = conexion.createStatement();
            sentencia.execute(sql);

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }

    @Override
    public void guardar(Object objeto) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)){
            Usuarios cuenta = (Usuarios) objeto;
            String sentenciaSQL ="INSERT INTO USUARIOS (NOMBRE, APELLIDO, CEDULA) " +
            " VALUES('" + cuenta.getNombre() + "', '" + cuenta.getApellido()
            + "', '" + cuenta.getCedula() + "');";
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
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSql = "DELETE FROM USUARIOS WHERE CEDULA = '" + cedula + "';";
            Statement sentencia = conexion.createStatement();
            sentencia.execute(sentenciaSql);
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    @Override
    public void actualizar(Object objeto,String id) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            Usuarios persona = (Usuarios) objeto;
            String sentenciaSql =  "UPDATE USUARIOS " +
            "SET NOMBRE = '" + persona.getNombre() + "', " +
            "APELLIDO = '" + persona.getApellido() + "', " +
            "CEDULA = '" + persona.getCedula() + "' " +
            "WHERE ID = " + id+";";
            Statement sentencia = conexion.createStatement();
            sentencia.execute(sentenciaSql);
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    @Override
    public Object buscar(String cedula) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSQL = "SELECT * FROM USUARIOS WHERE CEDULA = ?";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, cedula);
            ResultSet resultadoConsulta = sentencia.executeQuery();
            if (resultadoConsulta != null && resultadoConsulta.next()) {
                Usuarios cuenta = null;
                String nombre = resultadoConsulta.getString("nombre");
                String apellido = resultadoConsulta.getString("apellido");
                String cedularesultado = resultadoConsulta.getString("cedula");
                cuenta = new Usuarios(nombre, apellido, cedularesultado);
                return cuenta;
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }

    @Override
    public List<?> listar() {
        List<Usuarios> cuentas = new ArrayList<Usuarios>();

        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSql = "SELECT * FROM USUARIOS";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);
            ResultSet resultadoConsulta = sentencia.executeQuery();

            if (resultadoConsulta != null) {
                while (resultadoConsulta.next()) {
                    Usuarios cuenta = null;
                    int id = resultadoConsulta.getInt("ID");
                    String nombre = resultadoConsulta.getString("NOMBRE");
                    String apellido = resultadoConsulta.getString("APELLIDO");
                    String cedula = resultadoConsulta.getString("CEDULA");

                    cuenta = new Usuarios(id, nombre, apellido, cedula);
                    cuentas.add(cuenta);
                }
                return cuentas;
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }

    @Override
    public void actualizarId(Object objeto, String id) {
        throw new UnsupportedOperationException("Unimplemented method 'actualizarId'");
    }

}
