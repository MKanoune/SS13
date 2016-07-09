import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketSharePriceProvider {

	
	public static void main(String[] args) {
		String host = "localhost";
		int port = 7777;
		
		try(Socket socket = new Socket(host, port)){
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			DataInputStream dataIn = new DataInputStream(in);
			DataOutputStream dataOut = new DataOutputStream(out);
			
			dataOut.writeUTF("hello");
			String antwort = "";
			while(true){
				String input = dataIn.readUTF();
				if(input.equals("end.")){
					break;
				}else{
					antwort+=input+"\n";
				}
			}
			
			System.out.println(antwort);
			
			
			
		}catch(Exception e){
			
		}
	}
}
