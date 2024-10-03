package co.edu.uniquindio.programacion3.pedido.Model;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Se carga el archivo FXML con la ruta corregida
        scene = new Scene(loadFXML("primary"), 780, 480);
        stage.setScene(scene);
        stage.show();
    }

    // Método para cambiar la raíz de la escena
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    // Método que carga el archivo FXML basado en su nombre
    private static Parent loadFXML(String fxml) throws IOException {
        // La ruta del FXML comienza con una barra "/"
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/co/edu/uniquindio/programacion3/pedido/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
