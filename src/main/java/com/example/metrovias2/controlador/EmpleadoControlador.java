package com.example.metrovias2.controlador;

import com.example.metrovias2.modelo.Empleado;
import com.example.metrovias2.servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
    public class EmpleadoControlador {

        @Autowired
        private EmpleadoServicio servicio;

        /*
            Obtengo el listado de los estudiantes
         */
        @GetMapping({"/empleados"})
        public String listarEmpleados(Model modelo) {
            modelo.addAttribute("empl",servicio.listarTodosLosEmpleados());
            return "empleados"; //retorna al archivo html empleados
        }

        @GetMapping("/empleados/nuevo")
        public String crearEmpleadoFormulario(Model modelo) {
            Empleado empleado = new Empleado();
            modelo.addAttribute("empleado", empleado);
            return "crear_empleado";
        }

        @PostMapping("/empleados")
        public String guardarEmpleado (@ModelAttribute("empleado")Empleado empleado ){
            servicio.guardarEmpleado(empleado);
            return "redirect:/";
        }

        @GetMapping("/empleados/editar/{id}")
        public String editar(@PathVariable Long id, Model modelo) {
            modelo.addAttribute("empleado",servicio.obtenerEmpleadoPorId(id));
            return "editar_empleado";
        }

        @PostMapping("/empleados/{id}")
        public String actualizarEmpleado(@PathVariable Long id, @ModelAttribute ("empleado") Empleado empleado, Model model) {
            Empleado empleadoEncontrado = servicio.obtenerEmpleadoPorId(id);
            empleadoEncontrado.setId(id);
            empleadoEncontrado.setNombre(empleado.getNombre());
            empleadoEncontrado.setApellido(empleado.getApellido());
            empleadoEncontrado.setHorarioEntrada(empleado.getHorarioEntrada());
            empleadoEncontrado.setHorarioSalida(empleado.getHorarioSalida());
            servicio.actualizarEmpleado(empleadoEncontrado);
            return "redirect:/";
        }

        @DeleteMapping("/estudiantes/{id}")
        public String eliminarEmpleado (@PathVariable Long id){
            servicio.eliminarEmpleado(id);
            return "redirect:/";
        }
}
