package prueba.chat.maquinas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class PruebaChatMaquinas {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        Socket cliente = null;

        ServerSocket ss;
        ss = new ServerSocket(8081);

        cliente = ss.accept();

        InputStream it;
        InputStreamReader e1;
        BufferedReader entrada;

        it = cliente.getInputStream();
        e1 = new InputStreamReader(it);
        entrada = new BufferedReader(e1);

        OutputStream ot;
        OutputStreamWriter s;
        PrintWriter salida;

        ot = cliente.getOutputStream();
        s = new OutputStreamWriter(ot);
        salida = new PrintWriter(s, true);

        String mensaje;
        double n;

        for (int i = 0; i < 4; i++) {
//            System.out.println("digte");
//            String dato = scan.nextLine();
//            salida.println(""+dato);
//            String m = entrada.readLine();
//            
//            if (m==null){
//                break;
//            }
//            
//            System.out.println(m);

            mensaje = entrada.readLine();
            System.out.println("Digit R");

            String op = scan.nextLine();

            n = Double.parseDouble(mensaje);

            if (n < 0) {
                break;

            }
            if (op.charAt(0) == 'r') {
                n = Math.sqrt(n);
                salida.println("Raiz= " + n);
            } else {
                n = Math.log(n) / Math.log(2);
                salida.println("Lg= " + n);
            }
        }
        entrada.close();
        salida.close();
        cliente.close();
    }

}
