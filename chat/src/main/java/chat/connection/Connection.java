package chat.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection {

    private String name;
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    Connection(Socket socket) {

        try {
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        this.socket = socket;
    }

    void sendHelloMessage(String name, boolean isClient) {
        try {
            if (!isClient) {
                out.flush();
                out.writeObject("!ack");
                out.flush();
            }

            out.flush();
            out.writeObject("!hello " + name);
            out.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    void helloRoutine(boolean isClient) throws ConnectionException {
        try {
            String message;

            if (isClient) {
                message = (String) this.in.readObject();

                if (!message.equals("!ack")) {
                    System.out.println("[LOG] Connection failed.");
                    socket.close();

                    throw new ConnectionException("Connection failed");
                }
            }

            message = (String) this.in.readObject();
            this.name = message.replace("!hello", "");

        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public String readMessage() {
        String message = "";

        if (!socket.isClosed()) {

            try {
                message = (String) in.readObject();
            } catch (IOException | ClassNotFoundException exception) {}
        }

        return message;
    }

    public void writeMessage(String message) {

        if (!socket.isClosed()) {

            try {
                out.writeObject(message);
                out.flush();
            } catch (IOException exception) {}

        }
    }

    public String getName() {
        return name;
    }

    void close() {
        try {
            socket.close();
        } catch (IOException e)  {
            e.printStackTrace();
        }
    }
}
