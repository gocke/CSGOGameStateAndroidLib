package master117.csgogameobserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.JSONObject;

public class CSGOGameObserver
{
	private int ServerPort;
	private ServerMessageReceiver serverMessageReceiver;
	
	public CSGOGameObserver(int tempPort, ServerMessageReceiver tempServerMessageReceiver)
	{
		ServerPort = tempPort;
		serverMessageReceiver = tempServerMessageReceiver;
	}
	
	public void Start()
	{
		try
		{
			ServerSocket serverSocket = new ServerSocket(ServerPort);
			
			while(true)
			{
				//Open server and listen
				Socket receivedSocket = serverSocket.accept();
				
				//receive JSONObject
				JSONObject jsonObject = StreamToJSONObject(receivedSocket.getInputStream());
				receivedSocket.close();
				
				//write response
				PrintStream output = new PrintStream(receivedSocket.getOutputStream());			
				output.println("200");
				output.flush();
				output.close();
				
				//close socket and reopen
				serverSocket.close();
				
				Thread messageReceivedThread = new Thread(new OneShotTask(jsonObject, serverMessageReceiver));
				messageReceivedThread.start();
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//This method reads a stream and turns it into a JSONObject, fuck JSONReader
	public JSONObject StreamToJSONObject(InputStream inputStream)
	{
		try
		{
			BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			StringBuilder responseStrBuilder = new StringBuilder();

			String inputStr;
			while ((inputStr = streamReader.readLine()) != null)
				responseStrBuilder.append(inputStr);

			return new JSONObject(responseStrBuilder.toString());
	       
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}

class OneShotTask implements Runnable 
{
	ServerMessageReceiver serverMessageReceiver;
    JSONObject jsonObject;
    OneShotTask(JSONObject tempJSONObject, ServerMessageReceiver tempServerMessageReceiver) 
    { 
    	jsonObject = tempJSONObject; 
    	
        serverMessageReceiver = tempServerMessageReceiver;
    }
    
    public void run() 
    {
    	serverMessageReceiver.receiveCSGOServerMessage(jsonObject);
    }
}

