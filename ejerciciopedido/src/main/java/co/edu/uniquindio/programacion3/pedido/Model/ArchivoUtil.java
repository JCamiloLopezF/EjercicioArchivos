package co.edu.uniquindio.programacion3.pedido.Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoUtil {

    /**
     * Este método guarda contenido en un archivo especificado.
     * @param ruta la ruta donde se guarda el archivo.
     * @param contenido el contenido que se desea guardar.
     * @param flagAnexarContenido true para anexar, false para sobrescribir.
     * @throws IOException si ocurre un error al manejar el archivo.
     */
    public static void guardarArchivo(String ruta, String contenido, boolean flagAnexarContenido) throws IOException {
        FileWriter archivo = new FileWriter(ruta, flagAnexarContenido);

        BufferedWriter bfw = new BufferedWriter(archivo);
        bfw.write(contenido);
        bfw.close();
        archivo.close();

    }

    /**
     * Este método lee el contenido de un archivo y lo devuelve como una lista de cadenas.
     * @param ruta la ruta del archivo a leer.
     * @return una lista de líneas leídas del archivo.
     * @throws IOException si ocurre un error al manejar el archivo.
     */
    public static ArrayList<String> leerArchivo(String ruta) throws IOException {
        ArrayList<String> contenido = new ArrayList<String>();
        FileReader fr = new FileReader(ruta);
        BufferedReader bfr = new BufferedReader(fr);
        String linea = "";
        while ((linea = bfr.readLine()) != null) {
            contenido.add(linea);
        }
        bfr.close();
        fr.close();
        return contenido;
    }
}
