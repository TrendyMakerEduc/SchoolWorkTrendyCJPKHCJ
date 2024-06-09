import java.io.IOException;

public class Main {
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
}