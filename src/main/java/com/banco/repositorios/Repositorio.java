package com.banco.repositorios;

import java.util.List;

public interface Repositorio {
    public void guardar(Object objeto);
    public void eliminar(String cedula);
    public void actualizar(Object objeto, String id);
    public Object buscar(String cedula);
    public List<?> listar();
    public void actualizarId(Object objeto, String id);
}
