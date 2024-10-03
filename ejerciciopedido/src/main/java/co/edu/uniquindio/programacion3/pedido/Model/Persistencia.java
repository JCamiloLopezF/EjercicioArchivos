package co.edu.uniquindio.programacion3.pedido.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;

public class Persistencia {

    private String rutaArchivoPedidos = "";

    public void guardarPedido(Pedido pedido, Producto producto) throws IOException {
        rutaArchivoPedidos = obtenerRutaProperties();

        StringBuilder textoPedido = new StringBuilder();

        textoPedido.append(pedido.getCodigo()).append(",")
                   .append(pedido.getFechaPedido()).append(",")
                   .append(pedido.getTotal()).append(",")
                   .append(pedido.getIva() * 100).append("%").append("\n");

        pedido.agregarProducto(producto);
        textoPedido.append(producto.getNombre()).append(",").append(producto.getId()).append(",").append(producto.getPrecio()).append("\n");

        ArchivoUtil.guardarArchivo(rutaArchivoPedidos, textoPedido.toString(), true);
    }

    private String obtenerRutaProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("C:\\Users\\camil\\OneDrive\\Desktop\\Universidad\\Programación III\\Ejercicios\\ejerciciopedido\\rutas.properties")));
            return properties.get("rutaArchivoPedidos").toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public LinkedList<Producto> cargarProductos(Pedido pedido) throws IOException {
        rutaArchivoPedidos = obtenerRutaProperties();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(rutaArchivoPedidos);
    
        for (String linea : contenido) {
            // Ignorar líneas vacías
            if (linea.isEmpty()) {
                continue;
            }
    
            String[] datos = linea.split(",");
    
            // Verifica que haya suficientes datos
            if (datos.length < 3) {
                continue; // Ignora esta línea si no tiene suficiente información
            }
    
            String codigoProducto = datos[0];
            String nombreProducto = datos[1];
            double precio = Double.parseDouble(datos[2]);
    
            Producto producto = new Producto(codigoProducto, nombreProducto, precio);
            pedido.agregarProducto(producto);
        }
        return pedido.getListaProductos();
    }
    

}
