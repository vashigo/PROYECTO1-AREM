package co.edu.escuelaing.arem.sockets;

import java.io.IOException;

/**
 * Encargada de leer lo que le llega en el puerto predefinido
 * @author andres_vaz
 */
public class ServerSocket {



    public ServerSocket() {
    }

    public static java.net.ServerSocket getNewServerSocket(){
        java.net.ServerSocket serverSocket = null;
        try {
            serverSocket = new java.net.ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port:"+getPort()+".");
            System.exit(1);
        }
        return serverSocket;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
