package co.edu.escuelaing.arem.HttpServer;

import java.io.*;
import java.net.Socket;


/**
 * Se encarga de Escribir La informacion a mostrar En el servidor, en este caso paginas 
 * html y imagenes
 */
class ResourceWriter {

    private final Socket clientSocket;

    ResourceWriter(String resource, Socket clientSocket) {
        this.clientSocket = clientSocket;
        if (resource.toLowerCase().contains(".html")){htmlResource(resource);}
        else if (resource.toLowerCase().contains(".css")){cssResource(resource);}
        else if (resource.toLowerCase().contains(".png")){pngResource(resource);}
        else{
            errorType();
        }
    }
    /**
     * error para mostrar en pantalla de que no se puede procesar otro formato que nosea
     * .html o .png
     */
    private void errorType() {
        try {
            PrintWriter out;
            out = new PrintWriter(this.clientSocket.getOutputStream(), true);
            String outputLine = "HTTP/1.1 Erro Type Not Implemented\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>Error Type</title>\n"
                    + "</head>"
                    + "<body>"
                    + "<h1>erroType: solo se procesa archivos con .html o .png</h1>"
                    + "</body>"
                    + "</html>";

            out.println(outputLine);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Se encarga de mostrar en pantalla al no encontrar la direccion o archivo especificado
     */
    private void raise404() {
        try {
            PrintWriter out;
            out = new PrintWriter(this.clientSocket.getOutputStream(), true);
            String outputLine = "HTTP/1.1 404 Not Found\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>404 Not Found</title>\n"
                    + "</head>"
                    + "<body>"
                    + "<h1>Error 404: Contenido del archivo no correto o no encontrado</h1>"
                    + "</body>"
                    + "</html>";

            out.println(outputLine);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Se encarga de manejar las imagenes .png almacenado en resources
     * 
     * @param resource
     */
    private void pngResource(String resource) {

        try {
            File graphicResource= new File("src/main/resources" +resource);
            FileInputStream inputImage = new FileInputStream(graphicResource);
            byte[] bytes = new byte[(int) graphicResource.length()];
            inputImage.read(bytes);

            DataOutputStream binaryOut;
            binaryOut = new DataOutputStream(clientSocket.getOutputStream());
            binaryOut.writeBytes("HTTP/1.1 200 OK \r\n");
            binaryOut.writeBytes("Content-Type: image/png\r\n");
            binaryOut.writeBytes("Content-Length: " + bytes.length);
            binaryOut.writeBytes("\r\n\r\n");
            binaryOut.write(bytes);
            binaryOut.close();
        } catch (IOException ex){
            raise404();
            System.err.println("Error en la lectura de el archivo");
        }

    }
    /**
     * Se encarga de manejar el html almacenado en resources
     * @param resource
     */
    private void htmlResource(String resource) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("src/main/resources" + resource));
            StringBuilder outputLine = new StringBuilder();
            outputLine.append("HTTP/1.1 200 OK\r\n");
            outputLine.append("Content-Type: text/html\n");
            outputLine.append("\r\n\r\n");
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                outputLine.append(bfRead);
            }
            PrintWriter out = new PrintWriter(
                    this.clientSocket.getOutputStream(), true);


            out.println(outputLine.toString());
            out.close();

        }catch (IOException ex){
            raise404();
            System.err.println("Error en la lectura de el archivo");
        }
    }

    private void cssResource(String resource) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("src/main/resources" + resource));
            StringBuilder outputLine = new StringBuilder();
            outputLine.append("HTTP/1.1 200 OK\r\n");
            outputLine.append("Content-Type: text/css\n");
            outputLine.append("\r\n\r\n");
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                outputLine.append(bfRead);
            }
            PrintWriter out = new PrintWriter(
                    this.clientSocket.getOutputStream(), true);


            out.println(outputLine.toString());
            out.close();

        }catch (IOException ex){
            raise404();
            System.err.println("Error en la lectura de el archivo");
        }
    }

}
