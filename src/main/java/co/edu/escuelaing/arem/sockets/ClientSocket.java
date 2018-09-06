package co.edu.escuelaing.arem.sockets;

import java.io.IOException;
import java.net.Socket;

/**
 * Encargado de enviar lo que el ServerSocket lee
 *
 * @author andres_vaz
 */
public class ClientSocket {

    public ClientSocket() {
    }
    /**
     * metodo Get
     * 
     * @param sc
     * @return 
     */
    public static java.net.Socket getNewClientSocket(java.net.ServerSocket sc){
        Socket clientSocket = null;
        try {
            System.out.println("Listo para recibir ...");
            clientSocket = sc.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        return clientSocket;
    }
}
