import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // Replace with the actual server address
        int serverPort = 15679; // Replace with the actual server port
        Socket socket = new Socket(serverAddress, serverPort);

        BankClient newClient = new BankClient(socket);
        newClient.setVisible(true);
        String resultCheck = " ";
        String command = "STR";
        while(!command.equals("EXT")){
            if(newClient.command.equals("ADD")){
                if(newClient.checkLogin == true) {
                    command = "ADD," + newClient.num1.getText() + "," + newClient.outputNumber.getText() + "\n";
               }
               else{
                   command = "STR," + "no,go" + "\n";
              }
            }

            else if(newClient.command.equals("SUB")){
                if(newClient.checkLogin == true) {
                    command = "SUB," + newClient.num1.getText() + "," + newClient.outputNumber.getText() + "\n";
                }
                else{
                    command = "STR," + "no,go" + "\n";
                }
            }


            else if(newClient.command.equals("OPN")){
                // Create a BufferedReader to read data from the server
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // Read a line of text from the server
                String lineFromServer = in.readLine();
                newClient.checkLogin = true;
                String[] resCheck = resultCheck.split(",");
                newClient.outputNumber.setText(resCheck[2]);
                newClient.command = "NIC";
            }
            else if(newClient.command.equals("LDA")){
                String[] res = newClient.result.split(",");
                command = "LDA," + res[0] + "," + res[1] + "\n";
                System.out.println(command);

            }
            else if(newClient.command.equals("CUR")){
                JFrame frame = newClient.showPopup();
                frame.setSize(400, 400);
                frame.setTitle("Please Enter Your Account Details.");
                frame.setVisible(true);
                newClient.command = "STR";

            }

            else if(newClient.command.equals("STR")){
                command = "STR," + "Welcome," + " Member" + "\n";
                if(newClient.checkLogin == true){
                    command = "NIC,";
                }}
            else if(newClient.command.equals("NIC")){



            }

            else if(newClient.command.equals("BAD")){
                command = "BAD," + "\n"; }
            else if(newClient.command.equals("LOG")){
                command = "LOG," + "\n"; }


            newClient.sout.print(command);
            newClient.sout.flush();
            if(newClient.sin.hasNextLine())
            {
                String res = newClient.sin.nextLine();
                String[] result = res.split(",");


                if(!resultCheck.equals(res)){
                    System.out.println(result[1]);
                    if(result[0].equals ("OPN") && !resultCheck.equals(result)){
                        newClient.checkLogin = true;
                        newClient.outputNumber.setText(result[3]);
                        newClient.command = "NIC";
                        resultCheck = res;
                    }
                    if(result[0].equals ("ADDCOMPLETE") && !resultCheck.equals(result)){
                        newClient.checkLogin = true;
                        newClient.outputNumber.setText(result[1]);
                        newClient.command = "NIC";
                        resultCheck = res;
                    }
                    if(result[0].equals ("SUBCOMPLETE") && !resultCheck.equals(result)){
                        newClient.checkLogin = true;
                        newClient.outputNumber.setText(result[1]);
                        newClient.command = "NIC";
                        resultCheck = res;
                    }
                }
            }
        }
    }
}