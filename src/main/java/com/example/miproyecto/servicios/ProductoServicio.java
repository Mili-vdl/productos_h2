package com.example.miproyecto.servicios;

import com.example.miproyecto.entidades.Producto;
import com.example.miproyecto.repositorios.ProductoRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepo;

    @Transactional
    public void crearProducto(String nombre, String descripcion, Double precio, Integer cantidad) {
        Producto p = new Producto();
        p.setNombre(nombre);
        p.setDescripcion(descripcion);
        p.setPrecio(precio);
        p.setCantidad(cantidad);

        productoRepo.save(p);
    }

    @Transactional
    public void actualizarProducto(Long id, String nombre, String descripcion, Double precio, Integer cantidad) {
        Optional<Producto> respuesta = productoRepo.findById(id);

        if (respuesta.isPresent()) {
            Producto p = respuesta.get();

            p.setNombre(nombre);
            p.setDescripcion(descripcion);
            p.setPrecio(precio);
            p.setCantidad(cantidad);

            productoRepo.save(p);
        }
    }

    @Transactional
    public void eliminarProducto(Long id) {
        Optional<Producto> respuesta = productoRepo.findById(id);

        if (respuesta.isPresent()) {
            productoRepo.deleteById(id);
        }
    }

    public Producto consultarPorId(Long id) {
        Optional<Producto> respuesta = productoRepo.findById(id);
        Producto p = respuesta.get();
        return p;
    }

    public List<Producto> listar() {
        List<Producto> productos = productoRepo.findAll();
        return productos;
    }

}
