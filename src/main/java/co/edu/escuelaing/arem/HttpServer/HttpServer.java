package co.edu.escuelaing.arem.HttpServer;

import co.edu.escuelaing.arem.sockets.ClientSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase Principal
 * 
 */
public class HttpServer {
    private static InputReader ir;
    public static void main(String[] args) throws IOException {
        while (true) {

            //ClientSocket
            try ( //ServerSocket
                    ServerSocket serverSocket = co.edu.escuelaing.arem.sockets.ServerSocket.getNewServerSocket(); //ClientSocket
                    Socket clientSocket = ClientSocket.getNewClientSocket(serverSocket)) {
                //Input Read
                InputReader ir = new InputReader(clientSocket);
                //Output
                ResourceWriter rw = new ResourceWriter(ir.getResource(),clientSocket);
                ir.closeIn();
            }
        }
    }
    public static void close() throws IOException{
        ir.closeIn();
    }



}
