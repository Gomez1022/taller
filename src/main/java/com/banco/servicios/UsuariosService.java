package com.banco.servicios;

import java.util.List;
import java.util.Map;

import com.banco.entidades.Usuarios;
import com.banco.repositorios.UsuariosRepositorio;
import com.banco.repositorios.Repositorio;

public class UsuariosService {
    private Repositorio repositorioCuenta;
    public UsuariosService(){
        repositorioCuenta = new UsuariosRepositorio();
    }
    public void guardarUsuarios(Map datos) {
        String nombre = (String) datos.get("nombre");
        String apellido = (String) datos.get("apellido");
        String cedula = (String) datos.get("cedula");

        Usuarios newCuenta = new Usuarios(nombre,apellido,cedula);
        repositorioCuenta.guardar(newCuenta);
    }
    public List<Usuarios> listarUsuarios() {
        return (List<Usuarios>) repositorioCuenta.listar();
    }

    public Usuarios buscarUsuarios(String cedula) throws Exception {
        Object cuenta = repositorioCuenta.buscar(cedula);
        if (cuenta == null) {
            throw new Exception("No se encontro la persona");
        }
        return (Usuarios) cuenta;
    }
    public void actualizarUsuarios(Map datos , String id) {
        id = (String) datos.get("id");
        String nombre = (String) datos.get("nombre");
        String apellido = (String) datos.get("apellido");
        String cedula = (String) datos.get("cedula");
        Usuarios newPerson = new Usuarios(nombre, apellido, cedula);
        repositorioCuenta.actualizar(newPerson, id);
    }
    public void eliminaUsuarios(String cedula) {
        repositorioCuenta.eliminar(cedula);
    }
}
