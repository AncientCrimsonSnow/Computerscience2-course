
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
	
	static int startport = 8000;
	static int Socketrange = 11;
	
	static Socket socket[] = new Socket[Socketrange];
	static ServerSocket serverSocket;
	
	static DataInputStream din[] = new DataInputStream[Socketrange];
	static DataOutputStream dout[] = new DataOutputStream[Socketrange];
	
	static BufferedReader br;
	
	static String msgin = "";
	static String msgout = "";
	
	static int callmate;

	public static void main(String[] args) throws Exception{
		if(socket[1] != null) {
			mover();
		}
		else {
			socket[0] = serverSocket.accept();
			
			dout[0] = new DataOutputStream(socket[0].getOutputStream());

				msgout = "Server is currently full, pls try again later";
				
				dout[0].writeUTF(msgout);
				dout[0].flush();
				
				serverSocket.close();
				socket[0] = null;
			}
		System.out.println("Server is now running on ports: " + (startport + 1) + "-" + (serverSocket.getLocalPort() + Socketrange-1));
				
		br = new BufferedReader(
				new InputStreamReader(System.in));
	
		callmate = 10;
		writer(callmate);
		
		
		Server myserver = new Server();
			myserver.start();

	}
	public static void reader(int i) throws IOException {
			
		while(!msgin.equals("end")) {
			msgin = din[i].readUTF();
			System.out.println(socket[i].getInetAddress()+ " " + socket[i].getPort() + ": " + msgin);
		}
		socket[i] = null;
		
	}
	
	public static void writer(int i) throws IOException {

		
			
		while(!msgin.equals("end")) {
			msgout = br.readLine();
				if(msgout=="/callmate") {
					setCallmate();
				}
				else {
					dout[i].writeUTF(msgout);
					dout[i].flush();
				}	
		}
	}
	public static void setCallmate() {
		
	}
	public static void mover() throws IOException{
		
		socket[0] = serverSocket.accept();
		din[0] = new DataInputStream(socket[0].getInputStream());
		dout[0] = new DataOutputStream(socket[0].getOutputStream());
		
		//filling up the ports from behind so that we know if port 8001 is reached we are full.
		
		int j = Socketrange-1;
		for(int i = 0; i < Socketrange-1; i++) {
			
			if(socket[j] != null) {
				
				socket[j] = socket[0];
				socket[0] = serverSocket.accept();
							
				din[j] = din[0];
				din[0] = null;
				
				dout[j] = dout[0];
				dout[0] = null;
				
				serverSocket.close();
				
				break;
			}
		}
		
	}
	
	@Override
	public void run() {
		try {
			reader(callmate);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
