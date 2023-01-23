package com.example.metrovias2.servicio;

import com.example.metrovias2.modelo.Empleado;
import com.example.metrovias2.modelo.Usuario;
import com.example.metrovias2.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio {

    @Autowired
    private EmpleadoRepositorio repositorio;

    @Override
    public List<Empleado> listarTodosLosEmpleados() {
        return repositorio.findAll();
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return repositorio.save(empleado);
    }

    @Override
    public Empleado obtenerEmpleadoPorId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Empleado actualizarEmpleado(Empleado empleado) {
        return repositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Long id) {
        repositorio.deleteById(id);
    }


}

