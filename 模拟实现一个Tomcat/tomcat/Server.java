package Exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.activation.UnsupportedDataTypeException;
public class Server {
	ServerSocket ser;
	public Server()
	{
		try{
			ser = new ServerSocket(8080);
			System.out.println("tomcat¿ªÊ¼Æô¶¯");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void start()
	{
		try {
			Socket client = ser.accept();
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"ISO-8859-1");
			BufferedReader br = new BufferedReader(isr);
			String str = "";
			while(!(str = br.readLine()).equals("")){
				System.out.println(str);
			}
			OutputStream os = client.getOutputStream();
			File file = new File("webapps/index.html");
			os.write("HTTP/1.1 200 OK".getBytes("iso-8859-1"));
			os.write(13);
			os.write(10);
			os.write("Content-Type: text/html;charset=utf-8".getBytes("iso-8859-1"));
			os.write(13);
			os.write(10);
			os.write(("Content-Length: "+file.length()).getBytes("iso-8859-1"));
			os.write(13);
			os.write(10);
			os.write("".getBytes("GBK"));
			os.write(13);
			os.write(10);
			FileInputStream fis = new FileInputStream(file);
			byte[] b = new byte[(int)file.length()];
			fis.read(b);
			fis.close();
			os.write(b);
			os.flush();
			os.close();
		} catch (UnsupportedDataTypeException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		Server s = new Server();
		s.start();
	}
}