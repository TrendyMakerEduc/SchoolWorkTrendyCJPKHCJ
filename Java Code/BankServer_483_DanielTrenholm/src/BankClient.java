import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class BankClient extends JFrame {

    public Socket socket;
    public Scanner sin;
    public PrintWriter sout;
    public String command = "STR";
    public JTextField num1 = new JTextField();
    public JTextPane outputNumber;

    public String result;
    public boolean checkLogin = false;
    public JPanel panel1;
    public JPanel panel2;
    public JButton EnterData;
    public JFrame showPopup() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(3, 2));
        JTextField accountNumberField = new JTextField();
        JTextField passwordField = new JTextField();
        EnterData = new JButton();
        panel.add(new JLabel("Account Number:"));
        panel.add(accountNumberField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(EnterData);
        EnterData.addActionListener(e -> {
        result = accountNumberField.getText() + "," + passwordField.getText();
        command = "LDA";
        frame.dispose();
        });
        return frame;
    }

    public static boolean isFloat(String value) {
        try {
            float floatValue = Float.parseFloat(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }





    //GUI Instance Class
    public BankClient(Socket socket){

        setTitle("Calculation of Marks, CSCI 483");
        setSize(500,500);
        setLayout(new BorderLayout());
        panel1 = makeFunctionPanel();
        panel2 = makeNiceLayout();
        add(panel1, BorderLayout.SOUTH );
        add(panel2, BorderLayout.NORTH);
        try {
            initThings(socket);
            // ... (Your existing code)
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Top Panel for Output
    public JPanel makeNiceLayout(){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 200));
        panel.setBackground(Color.black);
        JPanel CalculatorOutput = new JPanel();
        CalculatorOutput.setPreferredSize(new Dimension(400, 200));
        CalculatorOutput.setBackground(Color.WHITE);
        Border YellowBorder = BorderFactory.createLineBorder(Color.yellow, 8);

        CalculatorOutput.setBorder(YellowBorder);
        outputNumber = new JTextPane();
        Style outputSize =  outputNumber.getStyle(StyleContext.DEFAULT_STYLE);
        StyleConstants.setFontSize(outputSize, 24);
        outputNumber.setText("Account= 123, Pass= 123");
        CalculatorOutput.add(outputNumber);
        panel.add(CalculatorOutput);
        return panel;
    }
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

    //Actions Panel
    public JPanel makeFunctionPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.blue);
        panel.setPreferredSize(new Dimension(200, 200));
        panel.setLayout(new FlowLayout());
        JButton Deposit = new JButton("Deposit");
        JButton Withdraw = new JButton("Withdraw");
        Withdraw.addActionListener(e -> {
            command = "SUB";
        });
        Deposit.addActionListener(e -> {
            command = "ADD";
        });
        panel.add(Deposit);
        panel.add(Withdraw);
        JButton LoadAccount = new JButton("Load Account");


        LoadAccount.addActionListener(e ->{
            command = "CUR";
        });
        num1.setPreferredSize(new Dimension(50,50));
        panel.add(num1);
        JButton ExitButton = new JButton("EXIT");
        ExitButton.addActionListener(e ->{
            command = "EXT";
        });
        panel.add(LoadAccount);
        panel.add(ExitButton);

        return panel;
    }

    //Client Application
    public void initThings(Socket socket) throws IOException{
        this.socket = socket;
        sin = new Scanner(socket.getInputStream());
        sout = new PrintWriter(socket.getOutputStream());
        socket.setTcpNoDelay(true);
        socket.setSoTimeout(1000);
    }

    //Quit Application
    public void callQuit(Socket s, Scanner sn, PrintWriter pw){
        try {
            s.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        sn.close();
        pw.close();
        System.exit(0);
    }
}
