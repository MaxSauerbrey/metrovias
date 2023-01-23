package com.example.metrovias2.servicio;

import com.example.metrovias2.modelo.Empleado;
import com.example.metrovias2.modelo.Usuario;

import java.util.List;

public interface EmpleadoServicio {
    public List<Empleado> listarTodosLosEmpleados();

    public Empleado guardarEmpleado(Empleado empleado);

    public Empleado obtenerEmpleadoPorId (Long id);

    public Empleado actualizarEmpleado (Empleado empleado);

    public void eliminarEmpleado (Long id);
}
