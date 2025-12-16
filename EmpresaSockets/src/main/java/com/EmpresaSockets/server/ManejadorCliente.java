package com.EmpresaSockets.server;

import java.io.*;
import java.net.Socket;

import com.EmpresaSockets.modelo.vista.ProcesadorPeticion;

public class ManejadorCliente implements Runnable {
    private Socket socket;

    public ManejadorCliente(Socket socket) { this.socket = socket; }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String peticion = in.readLine();
            String respuesta = ProcesadorPeticion.procesar(peticion);
            out.println(respuesta);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
