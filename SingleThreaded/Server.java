import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server{

    public void run() throws IOException{
        int port = 8010;
        try(ServerSocket socket = new ServerSocket(port)) {
            socket.setSoTimeout(10000);
            System.out.println("Server is listening on port "+ port);
            while(true){
                try{
                    Socket acceptedConnection = socket.accept();
                    System.out.println("Connection accepted on client "+ acceptedConnection.getRemoteSocketAddress());

                    PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(),true);
                    BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));

                    toClient.println("Hello from the server");
                    String line = fromClient.readLine();
                    System.out.println("Response from the Server is: "+ line);
                    
                }catch (SocketTimeoutException e) {
                    System.out.println("No connection received within 20 seconds.");
                    break;
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}