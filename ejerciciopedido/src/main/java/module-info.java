module co.edu.uniquindio.programacion3.pedido {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.programacion3.pedido.Model to javafx.fxml;
    exports co.edu.uniquindio.programacion3.pedido.Model;

    opens co.edu.uniquindio.programacion3.pedido.Controllers to javafx.fxml;
    exports co.edu.uniquindio.programacion3.pedido.Controllers;
}
