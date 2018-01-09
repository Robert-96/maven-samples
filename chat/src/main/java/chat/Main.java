package chat;

import java.util.Scanner;

public class Main {

    public static void main(String [] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Name: ");
        String name = in.next().trim();

        System.out.println("Port: ");
        int port = in.nextInt();

        System.out.println("Server (yes/no): ");
        String server = in.next();

        Node node = new Node(name);

        if (server.equals("yes")) {
            System.out.println("[LOG] Server");
            node.startServer(port);
        } else {
            System.out.println("[LOG] Client");
            node.connectToNode(port);
        }
    }
}
