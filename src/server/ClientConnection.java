package server;

import sun.applet.Main;
import system.Connection;

import java.net.Socket;

public class ClientConnection implements Runnable {

    private Connection connection;

    protected ClientConnection(Socket client) {
        this.connection = new Connection(client);
    }

    @Override
    public void run() {

        System.out.println("Rodando o run");

        while(true)
            ServerMessageHandler
                    .handleIncomingMessage(connection.readMessage(), this);
    }

    public Connection getConnection() {
        return connection;
    }
}
