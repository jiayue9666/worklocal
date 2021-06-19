import java.io.IOException;
import java.net.ServerSocket;

public class socket_server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket=new ServerSocket(83);
        while (true){
            socket.accept();
        }

    }


}
