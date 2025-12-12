package com.EmpresaSockets.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.EmpresaSockets.cliente.ClienteEmpresa;

public class ServerEmpresa {
	
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(5000);
		System.out.println("Servidor escuchando en puerto 5000...");

		while (true) {
			Socket cliente = server.accept();
			new Thread(new ClienteEmpresa(cliente)).start();
		}
	}
}
