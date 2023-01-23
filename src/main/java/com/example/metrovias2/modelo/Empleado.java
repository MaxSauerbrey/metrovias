package com.example.metrovias2.modelo;

import jakarta.persistence.*;

    @Entity
    @Table(name = "empleado")
    public class Empleado {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "nombre")
        private String nombre;

        @Column(name = "apellido")
        private String apellido;
        private String horarioEntrada;
        private String horarioSalida;

        public Empleado() {
        }

        public Empleado(Long id, String nombre, String apellido, String horarioEntrada, String horarioSalida) {
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.horarioEntrada = horarioEntrada;
            this.horarioSalida = horarioSalida;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getHorarioEntrada() {
            return horarioEntrada;
        }

        public void setHorarioEntrada(String horarioEntrada) {
            this.horarioEntrada = horarioEntrada;
        }

        public String getHorarioSalida() {
            return horarioSalida;
        }

        public void setHorarioSalida(String horarioSalida) {
            this.horarioSalida = horarioSalida;
        }

        @Override
        public String toString() {
            return "Empleado{" +
                    "id=" + id +
                    ", nombre='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' +
                    ", horarioEntrada='" + horarioEntrada + '\'' +
                    ", horarioSalida='" + horarioSalida + '\'' +
                    '}';
        }
    }

