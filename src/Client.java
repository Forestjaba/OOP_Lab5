import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static BufferedReader reader;
    private static PrintWriter writer;
    private static Scanner scanner;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream(), true);
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose action:");
            System.out.println("1. Add client");
            System.out.println("2. Send message");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter client name: ");
                    String clientName = scanner.nextLine();

                    writer.println("/add " + clientName);
                    break;

                case "2":
                    System.out.print("Enter recipient name: ");
                    String recipient = scanner.nextLine();

                    System.out.print("Enter message: ");
                    String message = scanner.nextLine();

                    writer.println(recipient + ": " + message);
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

    }
}
