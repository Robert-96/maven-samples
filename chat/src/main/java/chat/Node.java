package chat;

import chat.connection.Connection;
import chat.connection.ConnectionException;
import chat.connection.ConnectionManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Node {

    private String name;
    private boolean terminate;

    private ConnectionManager connections;
    private ExecutorService executorService;

    Node(String name) {
        this.name = name;
        this.terminate = false;

        this.connections = new ConnectionManager();
        this.executorService = Executors.newFixedThreadPool(10);
    }

    private void closeNode() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    void startServer(int listenPort) {
        Runnable mainTask = () -> {
            System.out.println("[LOG] Server started.");

            ServerSocket providerSocket;

            try {
                providerSocket = new ServerSocket(listenPort, 10);

                while(!terminate) {
                    try {
                        Connection connection = connections.create(providerSocket.accept(), name, false);

                        System.out.println("[LOG] Connection accepted.");

                        Runnable task = () -> {
                            receiveMessages(connection);
                            sendMessages(connection);
                        };

                        this.executorService.submit(task);

                    } catch (IOException | ConnectionException exception) {
                        exception.printStackTrace();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        this.executorService.submit(mainTask);
    }

    void connectToNode(int port) {

        try {
            Socket requestSocket = new Socket("localhost", port);
            Connection connection = connections.create(requestSocket, name, true);
            System.out.println("[Log] Connected to a server.");

            receiveMessages(connection);
            sendMessages(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void sendMessages(Connection connection) {

        Runnable mainTask = () -> {

            Scanner console = new Scanner(System.in);
            String message = "";

            while(!message.equals("!bye") && connections.contains(connection)) {
                message = console.nextLine();
                connection.writeMessage(message);

                if(message.equals("!byebye")) {
                    terminate = true;
                    connections.clear();
                    closeNode();

                    System.exit(0);
                }
            }

            connections.remove(connection);
        };

        this.executorService.submit(mainTask);
    }

    private void receiveMessages(Connection connection) {

        Runnable mainTask = () -> {

            String message = "";

            while(!message.equals("!bye") && !message.equals("!byebye") && connections.contains(connection)) {
                message = connection.readMessage();
                System.out.println(connection.getName() + ": " + message);
            }

            connections.remove(connection);
        };

        this.executorService.submit(mainTask);
    }

}
