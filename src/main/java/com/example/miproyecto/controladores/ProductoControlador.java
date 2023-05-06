package com.example.miproyecto.controladores;

import com.example.miproyecto.entidades.Producto;
import com.example.miproyecto.servicios.ProductoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/producto")
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServ;

    @GetMapping("/lista")
    public String listar(ModelMap modelo) {
        List<Producto> productos = productoServ.listar();
        modelo.put("productos", productos);
        return "producto_lista.html";
    }

    @GetMapping("/registrar")
    public String registrar() {
        return "producto_form.html";
    }

    @PostMapping("/registro")
    public String registro(String nombre, String descripcion, Double precio, Integer cantidad) {
        productoServ.crearProducto(nombre, descripcion, precio, cantidad);
        return "redirect:/";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, ModelMap modelo) {
        modelo.put("producto", productoServ.consultarPorId(id));
        return "producto_modificar.html";
    }

    @PostMapping("modifica/{id}")
    public String modificar(@PathVariable Long id, String nombre, String descripcion, Double precio, Integer cantidad, ModelMap modelo) {
        //modelo.put("producto", productoServ.consultarPorId(id));
        productoServ.actualizarProducto(id, nombre, descripcion, precio, cantidad);
        return "redirect:/";
    }

    @GetMapping("/consulta")
    public String consulta(Long id, ModelMap modelo) {
        Producto producto = productoServ.consultarPorId(id);
        modelo.addAttribute("productos", producto);
        return "producto_lista.html";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(ModelMap modelo, @PathVariable Long id) {
        productoServ.eliminarProducto(id);
        return "redirect:/";
    }
}
