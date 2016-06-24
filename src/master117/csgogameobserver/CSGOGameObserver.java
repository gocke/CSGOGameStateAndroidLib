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
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(ServerPort);
			
			while(true)
			{
				//Open server and listen
				Socket receivedSocket = serverSocket.accept();
				
				//receive JSONObject
				JSONObject jsonObject = StreamToJSONObject(receivedSocket.getInputStream());
								
				//write response
				PrintStream output = new PrintStream(receivedSocket.getOutputStream());			
				output.println("200");
				output.flush();
				output.close();
				
				//close received socket
				receivedSocket.close();
				
				CSGOGameState csgoGameState = new CSGOGameState(jsonObject);
				Thread messageReceivedThread = new Thread(new OneShotTask(csgoGameState, serverMessageReceiver));
				messageReceivedThread.start();
			}		
		} 
		catch (IOException e)
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
			String jsonString = responseStrBuilder.toString().substring(responseStrBuilder.toString().indexOf('{'));
						
			return new JSONObject(jsonString);
	       
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
    CSGOGameState csgoGameState;
    
    OneShotTask(CSGOGameState tempCSGOGameState, ServerMessageReceiver tempServerMessageReceiver) 
    { 
    	csgoGameState = tempCSGOGameState; 
    	
        serverMessageReceiver = tempServerMessageReceiver;
    }
    
    public void run() 
    {
    	serverMessageReceiver.receiveCSGOServerMessage(csgoGameState);
    }
}

