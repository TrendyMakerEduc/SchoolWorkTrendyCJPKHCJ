import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class BankServer {
    ServerSocket sSocket;
    Socket incoming;
    PrintWriter out;
    Scanner in;
    String message;

    private static final String ACCOUNT_FILE_PATH = "src/account_data.txt";
    private static double accountBalance = 0.0;

    public static void main(String[] args) throws IOException {
        BankServer newServer = new BankServer();
    }
    BankServer() throws IOException {
        sSocket = new ServerSocket(15679);

        while (true) {
            incoming = sSocket.accept();
            Runnable r = new clientHandler(incoming);
            Thread t = new Thread(r);
            t.start();


        }
    }

    private List<String> userInformation;
    public void loadAccountData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ACCOUNT_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                userInformation.add(line);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }


}

interface AccountInterface {
    String getAccountNumber();
    String getPassword();
    void setSocket(Socket socket);

}
