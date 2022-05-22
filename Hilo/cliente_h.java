package Hilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;

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
    }
}