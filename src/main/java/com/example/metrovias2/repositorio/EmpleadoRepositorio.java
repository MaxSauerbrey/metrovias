package com.example.metrovias2.repositorio;

import com.example.metrovias2.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {

    }


