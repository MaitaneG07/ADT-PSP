package com.EmpresaSockets.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteEmpresa {
	private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClienteEmpresa() throws IOException {
        socket = new Socket("localhost", 5000);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public String enviarPeticion(String peticion) throws IOException {
        out.println(peticion);
        return in.readLine();
    }
}
