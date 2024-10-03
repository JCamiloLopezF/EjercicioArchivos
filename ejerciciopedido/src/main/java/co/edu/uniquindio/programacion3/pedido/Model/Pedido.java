package co.edu.uniquindio.programacion3.pedido.Model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Pedido {
    private String codigo;
    private LocalDate fechaPedido;
    private double total;
    private double iva = 0.15;
    private LinkedList<Producto> listaProductos;

    public Pedido(String codigo, LocalDate fechaPedido, double total) {
        this.codigo = codigo;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.iva = iva;
        this.listaProductos = new LinkedList<>();
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public LinkedList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(LinkedList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s,%s,%.2f,%.2f", codigo, fechaPedido.toString(), total, iva * 100)).append("\n");
        for (Producto producto : listaProductos) {
            stringBuilder.append(producto.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

}
