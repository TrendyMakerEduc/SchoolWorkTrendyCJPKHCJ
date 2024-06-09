import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculationServer {
    String message;
    ServerSocket sSocket;
    Socket s;
    PrintWriter out;
    Scanner in;

    public static void main(String[] args) throws IOException {
        CalculationServer server = new CalculationServer();

        server.sSocket = new ServerSocket(15679);
        server.s = server.sSocket.accept();
        server.out = new PrintWriter(server.s.getOutputStream());
        server.in = new Scanner(server.s.getInputStream());
        while(server.in.hasNextLine()) {
            double result = 1;
            server.message = server.in.nextLine();
            System.out.println(server.message);

            String[] command = server.message.split(",");
            System.out.println(command[0]);
            if (command[0].equalsIgnoreCase("ADD")) {
                result = Double.parseDouble(command[1]) + Double.parseDouble(command[2]);
                System.out.println("Received");
                command[0] = "STR";
            }
            else if (command[0].equalsIgnoreCase("SUB"))
                result = Double.parseDouble(command[1]) - Double.parseDouble(command[2]);
            else if (command[0].equalsIgnoreCase("DIV"))
                result = Double.parseDouble(command[1]) / Double.parseDouble(command[2]);
            else if (command[0].equalsIgnoreCase("MUL"))
                result = Double.parseDouble(command[1]) * Double.parseDouble(command[2]);
            else if (command[0].equalsIgnoreCase("RTP"))
                result = Double.parseDouble(command[1]) * Double.parseDouble(command[2]);
            if (command[0].equals("STR")){
                System.out.print(".");
            }

            else if (command[0].equalsIgnoreCase("EXT")) {
                server.sSocket.close();
                server.in.close();
                server.out.close();
                System.exit(0);
            }
            server.out.println(result);
            server.out.flush();
        }
    }

}
