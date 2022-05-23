package Proyecto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

/*
//--------------------------------------------------------------
- Usuarios identificados como idependientes deswde diferentes instancias.
 
Nota: Descripcion detallada mas adelante, guia mediante comentarios por referencia.
//--------------------------------------------------------------
*/

public class cliente_h extends Thread
{
    private DataInputStream in;
    private DataOutputStream out;

    public cliente_h (DataInputStream in, DataOutputStream out)
    {
        this.in = in;
        this.out = out;
    }

    public void run()
    {
        Scanner sn = new Scanner(System.in);

        int opcion;
        String mensaje;
        boolean salir = false;

        while (!salir)
        {
            // al principio la idea era utilizar JO, pero esa opcion queda descartada por la adaptacion de interfaces en ambos puntos
            try
            {
                System.out.println("----------------------------\n"
                + "0.- Agregar                 \n"
                + "1.- Consultar               \n"
                + "2.- Actualizar              \n"
                + "3.- Eliminar                \n"
                + "4.- Salir                   \n"
                + "----------------------------\n");

                opcion = sn.nextInt();
                out.writeInt(opcion); // check ---------
                
                switch(opcion)
                {
                    case 1: //  agregara tipo de dato - cliente
                    int aleatorio = RandomNum(1,10); // llama a RandomNum para generar un numero
                    System.out.println("Se a generado un numero: " + aleatorio + ".\n"); // confirma dato introducido
                    out.writeInt(aleatorio); // opcion
                    mensaje = in.readUTF();
                    System.out.println(mensaje);
                    break;
                    case 2: // consultara los tipos de datos - cliente
                    break;
                    case 3: // actializara el conjunto  - cliente
                    break;
                    case 4: // eliminara un elemento compuesto - cliente
                    break;
                    case 5: // saldra de la aplicacion - cliente
                    break;
                    default: // para recibir siempre el mensaje, pues permanece abierto para recibir la opcion
                    mensaje = in.readUTF(); 
                    System.out.println(mensaje);
                    break;
                }
            } catch (Exception e)
            {
                e.printStackTrace(); // check ---------
            }
        }
    }

    public int RandomNum (int min, int max) // asi nos ahorramos meter tanto dato, generandolos de manera aleatoria, por lo menos en pruebas
    {
        int num = (int)Math.floor(Math.random()*(max - min + 1) + (min));
        return num;
    }
}