import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Calculator extends JFrame {

    Socket socket;
    Scanner sin;
    PrintWriter sout;
    String command = "STR";
    JTextField num1;
    JTextField num2;
    JTextPane outputNumber;


    //GUI Instance Class
    Calculator(){
        setTitle("Calculation of Marks, CSCI 483");
        setSize(500,500);
        setLayout(new BorderLayout());
        add(makeFunctionPanel(), BorderLayout.SOUTH );
        add(makeNiceLayout(), BorderLayout.NORTH);




    }

    public static void main(String[] args) throws IOException {
        String resultCheck = " ";
        Calculator client = new Calculator();
        client.initThings();
        String command = " ";
        client.setVisible(true);
        while(!command.equals( "EXT")){
            if(client.command.equals("ADD")){
                command = "ADD," + client.num1.getText() + "," + client.num2.getText() + "\n";
            }
            else if(client.command.equals("SUB")){
                command = "SUB," + client.num1.getText() + "," + client.num2.getText() + "\n";
            }
            else if(client.command.equals("MUL")){
                command = "MUL," + client.num1.getText() + "," + client.num2.getText() + "\n";
            }
            else if(client.command.equals("DIV")){
                command = "DIV,"+ client.num1.getText() + "," + client.num2.getText() + "\n";
            }
            else if(client.command.equals("EQL")){
                command = "EQL," + client.num1.getText() + "," + client.num2.getText() + "\n";
            }
            else if(client.command.equals("RTP")){
                command = "RTP," + client.num1.getText() + "," + client.num2.getText() + "\n";
            }
            else if(client.command.equals("EXT")){
                command = "EXT," + client.num1.getText() + "," + client.num2.getText() + "\n";
                client.callQuit(client.socket, client.sin, client.sout);
            }
            else if(client.command.equals("STR")){
                command = "STR," + "Welcome" + "\n"; }

            client.sout.print(command);
            client.sout.flush();
            if(client.sin.hasNextLine())
            {
                String result = client.sin.nextLine();

                if(!resultCheck.equals(result)){
                    client.outputNumber.setText(result);
                    System.out.println(result);
                    resultCheck = result;
                }
            }
        }
    }

    //Top Panel for Output
    private JPanel makeNiceLayout(){
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
        outputNumber.setText("Hello, Welcome to the \nCalculator.Input Your numbers \nbelow and choose a \nfunction");
        CalculatorOutput.add(outputNumber);
        panel.add(CalculatorOutput);
        return panel;
    }

    //Actions Panel
    private JPanel makeFunctionPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.blue);
        panel.setPreferredSize(new Dimension(200, 200));
        panel.setLayout(new FlowLayout());
        JButton Add = new JButton("Add");
        JButton Subtract = new JButton("Subtract");
        JButton Multiply = new JButton("Multiply");
        JButton Divide = new JButton("Divide");
        JButton raiseToPower = new JButton("Raise to Power");
        panel.add(Add);
        panel.add(Subtract);
        panel.add(Multiply);
        panel.add(Divide);
        panel.add(raiseToPower);
        JPanel InputFields = new JPanel();
        panel.add(InputFields);
        InputFields.setBackground(Color.red);
        InputFields.setPreferredSize(new Dimension(400, 100));
        InputFields.setLayout(new FlowLayout());
        JTextArea num1Text = new JTextArea("Number 1");
        num1Text.setSize(10,20);
        num1 = new JTextField(10);
        InputFields.add(num1Text);
        InputFields.add(num1);
        num1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                num1.getText();
            }
        });
        JTextArea num2Text = new JTextArea("Number 2");
        InputFields.add(num2Text);
        num2 = new JTextField(10);
        InputFields.add(num2);
        num2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        JButton EqualsButton = new JButton("Equals");
        InputFields.add(EqualsButton);
        Subtract.addActionListener(e -> {
            command = "SUB";
        });
        Add.addActionListener(e -> {
            command = "ADD";
        });
        Multiply.addActionListener(e -> {
            command = "MUL";
        });
        Divide.addActionListener(e -> {
            command = "DIV";
        });
        raiseToPower.addActionListener(e -> {
            command = "RTP";
        });
        EqualsButton.addActionListener(e ->{
            command = "EQL";
        });
        JButton ExitButton = new JButton("EXIT");
        ExitButton.addActionListener(e ->{
            command = "EXT";
        });

        return panel;
    }

    //Client Application
    public void initThings() throws IOException{
        socket = new Socket("localhost", 15679);
        sin = new Scanner(socket.getInputStream());
        sout = new PrintWriter(socket.getOutputStream());
        socket.setTcpNoDelay(true);
        socket.setSoTimeout(1000);
    }

    //Quit Application
    void callQuit(Socket s, Scanner sn, PrintWriter pw){
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
