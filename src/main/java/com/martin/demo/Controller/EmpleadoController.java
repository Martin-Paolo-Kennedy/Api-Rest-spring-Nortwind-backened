package com.martin.demo.Controller;

import com.martin.demo.Entity.Cliente;
import com.martin.demo.Entity.Empleado;
import com.martin.demo.Service.ClienteService;
import com.martin.demo.Service.EmpleadoService;
import com.martin.demo.util.AppSettings;
import com.martin.demo.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/url/empleado")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class EmpleadoController {
    @Autowired
    private EmpleadoService empService;

    @GetMapping
    @ResponseBody
    public List<Empleado> listaEmpleado() {
        return empService.listaEmpleado();
    }

    //http://localhost:8090/url/empleado/consultaEmpleadoPorParametros?firstName=Janet&lastName=Leverling
    @GetMapping("/consultaEmpleadoPorParametros")
    @ResponseBody
    public List<Empleado> listaConsultaEmpleado(
            @RequestParam(name = "firstName" , required = false, defaultValue = "") String firstName,
            @RequestParam(name = "lastName" , required = false, defaultValue = "") String lastName){

        List<Empleado> lstSalida = empService.listaEmpleadoPorNombreYApellidoLike("%"+ firstName + "%", "%"+ lastName + "%");

        return lstSalida;
    }

    @PostMapping("/registraEmpleado")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaEmpleado(@RequestBody Empleado obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            obj.setEmployeeID(0);
            Empleado objSalida =  empService.insertaActualizaEmpleado(obj);
            if (objSalida == null) {
                salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
            } else {
                salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
        }
        return ResponseEntity.ok(salida);
    }

    @PutMapping("/actualizaEmpleado")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaEmnpleado(@RequestBody Empleado obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Empleado objSalida =  empService.insertaActualizaEmpleado(obj);
            if (objSalida == null) {
                salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
            } else {
                salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
        }
        return ResponseEntity.ok(salida);
    }

    @DeleteMapping("/eliminaEmpleado/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaEmpleado(@PathVariable("id") int idEmpleado) {
        Map<String, Object> salida = new HashMap<>();
        try {
            empService.eliminaEmpleado(idEmpleado);
            salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(salida);
    }
}
