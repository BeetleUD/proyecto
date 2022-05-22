package proyecto;

import java.io.IOException;
//import javax.swing.JOptionPane;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket; // servidor
import java.net.ServerSocket; // cliente

 /*
 //--------------------------------------------------------------
 - Base para interfas y seleccion.
 - la consulta debe arrojar todo lo solicitado o un dato de busqueda en especifico(?)
 - Probar con una estructura tipo "TDA" (oculta en comentarios), adaptar el menu de una extructura de arbol binario (cont: es largo de desarrollar)
 - Se inicia prueba de conexio cliente servidor
 -

 Nota: Si se inicia el cliente sin servidor no ocurrira nada.
 //--------------------------------------------------------------
*/

public class cliente
{
    public static void main(String[]args)
    {
        final String HOST = ""; // direccion ip queda a definir --- la direccion estara precente en pruebas mas no en codigo para evitar el famoso "Doxxeo"
        final int PORT = 7327; // el numero de puerto queda a definir --- debe coincidir con el del servidor --- pero es provicional

        DataInputStream in; // puerto de entrada
        DataOutputStream out; // puerto de salida
        
        try
        {
            Socket sc = new Socket(HOST, PORT);
            
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF("Mensaje enviado");

            String mensaje = in.readUTF();

            System.out.println(mensaje);
            sc.close();
        
        } catch (IOException ex)
        {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
/*
        int opcion = 0;
		int opc = 0;
        Arbol arbol = new Arbol(); // aun no es seguro y esta sujeto a cambios

        do{
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "-----------------------------------------------\n"
                + "0.- Agregar                 \n"
                + "1.- Consultar               \n"
                + "2.- Actualizar              \n"
                + "3.- Eliminar                \n"
                + "4.- Salir                   \n"
                + "Elije una opcion: ", "Cliente-Servidor",JOptionPane.QUESTION_MESSAGE));
                
                switch(opcion)
                {
                    case 0: // agregar
                    String dato = JOptionPane.showInputDialog(null, "Ingresa el numero de control: ","Agregar",JOptionPane.QUESTION_MESSAGE);
                    String nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del alumno: ","Agregar",JOptionPane.QUESTION_MESSAGE);
                    arbol.insertar(dato, nombre);
                    break;
                    case 1: // consultar
                    dato = JOptionPane.showInputDialog(null,"Ingrese la matricula a buscar: ", "Consultar", JOptionPane.QUESTION_MESSAGE);
                    if(arbol.Buscar(dato.toUpperCase()))
                    {
                        JOptionPane.showMessageDialog(null, "Nodos encontrados: \n"+ arbol.buscardato(dato) , "Consultar", JOptionPane.DEFAULT_OPTION);
                    }else
                    JOptionPane.showMessageDialog(null, "No se encontro la matricula solicitada", "Consultar", JOptionPane.ERROR_MESSAGE);
                    break;
                    case 2: // actualizar
                    // en espera de indicaciones...
                    break;
                    case 3: // eliminar
                    dato= JOptionPane.showInputDialog(null,"Ingrese la matricula a eliminar: ", "Eliminar", JOptionPane.QUESTION_MESSAGE);
                    if(arbol.eliminar(dato.toUpperCase()))
                    {
                        JOptionPane.showMessageDialog(null, "La matricula "+ dato.toUpperCase ()+" fue eliminada exitosamente", "Eliminar", JOptionPane.DEFAULT_OPTION);
                    }else
                    JOptionPane.showMessageDialog(null, "No se encontro la matricula solicitada", "Eliminar", JOptionPane.ERROR_MESSAGE);
                    break;
                    case 4: // Salir
                    JOptionPane.showMessageDialog(null, "Finalizando aplicacion, por favor espere...", "Finalizando", JOptionPane.INFORMATION_MESSAGE);
                    break;
                    default:// Error
                    JOptionPane.showMessageDialog(null, "La opcion seleccionada no existe...", "Error", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            } catch (Exception e)
            {
                JOptionPane.showMessageDialog( null,"Error: Mismatch " + e.getMessage());
            }
        }while(opcion!=9);
*/