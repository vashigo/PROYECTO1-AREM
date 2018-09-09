package co.edu.escuelaing.arem.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Se encarga de Manejar La información que le llega del ClientSocket
 *
 */
public class InputReader {

    private String resource = "";
    private BufferedReader in;
    
    /**
     * Lee los encabezados y revisa por el get
     * @param cs Socket ClientSocket
     * @throws java.io.IOException
     */
    public InputReader(Socket cs) throws IOException {


        this.in = new BufferedReader(
                new InputStreamReader(cs.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if (!in.ready()) {
                break;
            }
            if(inputLine.contains("GET")){
                this.resource = inputLine.split(" ")[1];
                System.out.println("Me pidieron:"+ resource);
            }
            System.out.println("Recibí: " + inputLine);
        }


    }

    public String getResource() {
        return resource;
    }

    public void closeIn() throws IOException {
        this.in.close();
    }
}
