import java.util.Scanner;

/**
 * Created by ahmed on 6/19/17.
 */
public class Application {

    public static void main (String[] args) {

        boolean connectionState = false;

        SSHConnection sshConnection = new SSHConnection();

        connectionState = sshConnection.openConnection("192.168.1.108", 22, "grad", "123456789", 120000);

        if (connectionState == true) {
            System.out.println("Connected Successfully \n");

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Result: " + sshConnection.receiveData());

            Scanner scanner = new Scanner(System.in);
            String in = scanner.nextLine();

            // Send Command
            sshConnection.sendCommand(in + "\n");

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Result: " + sshConnection.receiveData());

            // Close connection
            sshConnection.close();
        } else {
            System.out.println("Can't connect \n");
        }
    }
}
