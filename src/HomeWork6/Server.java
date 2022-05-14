package HomeWork6;

import java.io.IOException;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(5000);
            System.out.println("Сервер создан. Жду клиента...");
            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился ");
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                server.close();
                System.out.println("Сервер закрыт");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
