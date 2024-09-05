package com.martin.demo.Controller;

import com.martin.demo.Entity.Categoria;
import com.martin.demo.Entity.Cliente;
import com.martin.demo.Service.CateogoriaService;
import com.martin.demo.Service.ClienteService;
import com.martin.demo.util.AppSettings;
import com.martin.demo.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/url/cliente")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ClienteController {
    @Autowired
    private ClienteService cliService;

    @GetMapping
    @ResponseBody
    public List<Cliente> listaCliente() {
        return cliService.listaCliente();
    }
    //http://localhost:8090/url/categoria/listaCategoriaPorNombreLike/Condiments
    @GetMapping("/listaClientePorNombreLike/{nom}")
    @ResponseBody
    public ResponseEntity<List<Cliente>> listaClientePorNombreLike(@PathVariable("nom") String nom) {
        List<Cliente> lista  = null;
        try {
            if (nom.equals("todos")) {
                lista = cliService.listaClientePorNombreLike("%");
            }else {
                lista = cliService.listaClientePorNombreLike("%" + nom + "%");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registraCliente")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaCliente(@RequestBody Cliente obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            obj.setCustomerID(0);
            Cliente objSalida =  cliService.insertaActualizaCliente(obj);
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

    @PutMapping("/actualizaCliente")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaCliente(@RequestBody Cliente obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Cliente objSalida =  cliService.insertaActualizaCliente(obj);
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

    @DeleteMapping("/eliminaCliente/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaCliente(@PathVariable("id") int idCliente) {
        Map<String, Object> salida = new HashMap<>();
        try {
            cliService.eliminaCliente(idCliente);
            salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(salida);
    }
}
