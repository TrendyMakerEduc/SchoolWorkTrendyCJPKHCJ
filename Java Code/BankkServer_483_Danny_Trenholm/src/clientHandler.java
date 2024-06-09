import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class clientHandler implements Runnable {

    Socket socket;
    PrintWriter out;
    Scanner in;
    String message;
    private static final String ACCOUNT_FILE_PATH = clientHandler.class.getResource("/account_data.txt").getPath();
    private static double accountBalance = 0.0;
    clientHandler(Socket socket){
        this.socket = socket;
    }
    private List<String> userInformation = new ArrayList<>();
    private String loadAccountData(String str1, String str2) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ACCOUNT_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
               String[] message = line.split(",");

                if(str1.equals(message[0]) && str2.equals(message[1])){
                    return str1 + "," + str2;
                }
            }
            return "STR, no, go";
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return "STR, no, go";
    }

    private static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public void run() {
        String resultCheck;
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream());
            while (in.hasNextLine()) {
                String result = "1";
                String message = in.nextLine();
                System.out.println(message);
                String[] command = message.split(",");

                if (command[0].equalsIgnoreCase("ADD")) {
                    if (isDouble(command[1])) {
                        Double result1 = Double.parseDouble(command[2]) + Double.parseDouble(command[1]);
                        result = "ADDCOMPLETE," + result1.toString();
                    }
                    command[0] = "STR";
                } else if (command[0].equalsIgnoreCase("SUB")) {
                    if (isDouble(command[1])) {
                        Double result1 = Double.parseDouble(command[2]) - Double.parseDouble(command[1]);
                        result = "SUBCOMPLETE," + result1.toString();
                    }
                    command[0] = "STR";
                } else if (command[0].equalsIgnoreCase("LDA")) {
                    System.out.println("AWESOME");
                    try (BufferedReader reader = new BufferedReader(new FileReader(ACCOUNT_FILE_PATH))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] message1 = line.split(",");

                            if (command[1].equals(message1[0]) && command[2].equals(message1[1])) {
                                result = "OPN," + command[1] + "," + command[2] + "," + message1[2];
                            }

                        }
                    } catch (IOException | NumberFormatException e) {
                        e.printStackTrace();
                    }
                }




                else if (command[0].equalsIgnoreCase("LOG")) {
                    System.out.println("Received");
                    result = command[0] + "," + command[1] + "," + command[2];
                }
                else if (command[0].equalsIgnoreCase("OPN")) {
                    System.out.println("Received");
                    result = "LOG" + command[0] + "," + command[1] + "," + command[2];
                }
                else if (command[0].equalsIgnoreCase("STR")) {
                    System.out.println("Received");
                    result = "STR" + command[0] + "," + command[1];
                }

                    out.println(result);
                    out.flush();

                    }
                }


         catch(IOException e){
        e.printStackTrace();}
    }
    }