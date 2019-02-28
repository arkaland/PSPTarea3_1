package t3pspservidor;

import java.io.*;
import java.net.*;
import java.util.Random;

public class Servidor {

    public static void main(String args[]) {

        // Sin argumentos 
        if (args.length != 0) {
            System.err.println("Uso: Recepción por udp");

        } else {
            try {

                // Crea el  socket 
                DatagramSocket sSocket = new DatagramSocket(2000);

                // Crea el espacio para los mensajes 
                byte[] numero = new byte[100];
                DatagramPacket mensaje = new DatagramPacket(numero, numero.length);
                System.out.println("Esperando numero..");
                
                //GENERAMOS NUMERO DE 0 A 100
                Random rand = new Random(); 
                int numerito;
                       numerito = rand.nextInt(101); 

                while (true) {
                   // Recibe y muestra el mensaje 
                    sSocket.receive(mensaje);
                    String datos = new String(mensaje.getData(), 0, mensaje.getLength());
                    System.out.println("\tNumero recibido: " + datos);
                    
                    //LOGICA PARA DEVOLVER MENSAJE
                    int numeroservidor = Integer.valueOf(datos);
     
                    if (numeroservidor < numerito) 
                        System.out.println("El número indicado es MENOR que el número del servidor");
                    if (numeroservidor > numerito) 
                        System.out.println("El número indicado es MAYOR que el número del servidor");
                    if (numeroservidor == numerito)
                        System.out.println("HAS ACERTADO EL NUMERO!");    
                }

            } catch (SocketException e) {
                System.err.println("Socket: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("E/S: " + e.getMessage());
            }
        }

    }

}
