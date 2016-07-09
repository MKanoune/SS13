import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {
		SharePriceCache cache = new SharePriceCache();
		try(ServerSocket serverSocket = new ServerSocket(7777)){
			Socket clientSocket = serverSocket.accept();
			InputStream in = clientSocket.getInputStream();
			OutputStream out = clientSocket.getOutputStream();
			
			DataInputStream dataIn = new DataInputStream(in);
			DataOutputStream dataOut = new DataOutputStream(out);
			
			String nachricht = dataIn.readUTF();
			if(nachricht.equals("hello")){
				for(int i = 0; i< cache.shares.size();i++){
					dataOut.writeUTF(cache.shares.get(i).getName()+"@"+cache.shares.get(i).getPrice());
				}
				dataOut.writeUTF("end.");
			}
		}catch(Exception e){
			
		}
	}
}
