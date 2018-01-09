package chat.connection;

import java.net.Socket;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectionManager {

    private Queue<Connection> connections;

    public ConnectionManager() {
        this.connections = new ConcurrentLinkedQueue<>();
    }

    public Connection create(Socket socket, String name, boolean isClient) throws ConnectionException {
        Connection connection = new Connection(socket);

        connection.sendHelloMessage(name, isClient);
        connection.helloRoutine(isClient);

        this.connections.add(connection);

        return connection;
    }

    public void remove(Connection connection) {
        connection.close();

        this.connections.remove(connection);
    }

    public boolean contains(Connection connection) {
        return this.connections.contains(connection);
    }

    public void clear() {
        for (Connection connection : connections) {
            connection.close();
        }

        connections.clear();
    }
}
