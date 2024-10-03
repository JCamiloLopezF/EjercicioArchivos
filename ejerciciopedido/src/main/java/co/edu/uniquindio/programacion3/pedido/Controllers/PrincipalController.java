package co.edu.uniquindio.programacion3.pedido.Controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.programacion3.pedido.Model.Pedido;
import co.edu.uniquindio.programacion3.pedido.Model.Persistencia;
import co.edu.uniquindio.programacion3.pedido.Model.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrincipalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addProductoButton;

    @FXML
    private TextField codeTextField;

    @FXML
    private TextField codigoProductoTextField;

    @FXML
    private TextField nombreProductoTextField;

    @FXML
    private DatePicker pedidoDatePicker;

    @FXML
    private TextField precioProductoTextField;

    @FXML
    private Button verPedidoButton;

    private Pedido pedidoActual;

    @FXML
    private TextArea mostrarProductos;

    @FXML
    void addProductoAction(ActionEvent event) {
        agregarProducto();
    }

    @FXML
    void verPedidoAction(ActionEvent event) {
        LinkedList<Producto> productos = verPedido();
        if (productos != null) {
            mostrarProductos.clear();
            for (Producto producto : productos) {
                mostrarProductos.appendText("Código: " + producto.getId() + 
                                            ", Nombre: " + producto.getNombre() + 
                                            ", Precio: " + producto.getPrecio() + "\n");
            }
        }
    }
    

    @FXML
    void initialize() {
        assert addProductoButton != null : "fx:id=\"addProductoButton\" was not injected: check your FXML file 'primary.fxml'.";
        assert codeTextField != null : "fx:id=\"codeTextField\" was not injected: check your FXML file 'primary.fxml'.";
        assert codigoProductoTextField != null : "fx:id=\"codigoProductoTextField\" was not injected: check your FXML file 'primary.fxml'.";
        assert nombreProductoTextField != null : "fx:id=\"nombreProductoTextField\" was not injected: check your FXML file 'primary.fxml'.";
        assert pedidoDatePicker != null : "fx:id=\"pedidoDatePicker\" was not injected: check your FXML file 'primary.fxml'.";
        assert precioProductoTextField != null : "fx:id=\"precioProductoTextField\" was not injected: check your FXML file 'primary.fxml'.";
        assert verPedidoButton != null : "fx:id=\"verPedidoButton\" was not injected: check your FXML file 'primary.fxml'.";
    }

    private void agregarProducto() {
        Persistencia persistencia = new Persistencia();

        String codigoPedido = codeTextField.getText();
        LocalDate fechaPedido = pedidoDatePicker.getValue();


        Pedido pedido = new Pedido(codigoPedido, fechaPedido, 0);

        String nombreProducto = nombreProductoTextField.getText();
        String idProducto = codigoProductoTextField.getText();
        double precio = Double.parseDouble(precioProductoTextField.getText());

        Producto producto = new Producto(nombreProducto, idProducto, 0);
        try {
            persistencia.guardarPedido(pedido, producto);
        } catch (IOException e) {
            e.printStackTrace();
        }

        limpiarCamposProducto();
    }

    private LinkedList<Producto> verPedido() {
        Pedido pedido = new Pedido(null, null, 0);
        Persistencia persistencia = new Persistencia();

        try {
            persistencia.cargarProductos(pedido);
            return pedido.getListaProductos();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void limpiarCamposProducto() {
        codigoProductoTextField.clear();
        nombreProductoTextField.clear();
        precioProductoTextField.clear();
    }
}
