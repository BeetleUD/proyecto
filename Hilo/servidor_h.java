package Hilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class servidor_h extends Thread
{
    private DataInputStream in;
    private DataOutputStream out;
    private String usuario;

    public servidor_h (DataInputStream in, DataOutputStream out, String usuario)
    {
        this.in = in;
        this.out = out;
        this.usuario = usuario;
    }

    public void run()
    {
    }
}