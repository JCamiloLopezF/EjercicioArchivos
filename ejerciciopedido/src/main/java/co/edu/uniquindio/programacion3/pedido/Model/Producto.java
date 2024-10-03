package co.edu.uniquindio.programacion3.pedido.Model;

public class Producto {
    private String nombre;
    private String id;
    private double precio;

    
    public Producto(String nombre, String id, double precio) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %.2f", id, nombre, precio);
    }

}
