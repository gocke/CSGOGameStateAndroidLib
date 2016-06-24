package master117.csgogameobserver;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class AllPlayers
{
    public ArrayList<AllPlayer> AllPlayerList = new ArrayList<AllPlayer>();

    public AllPlayers(JSONObject allPlayersDataJToken)
    {
    	//To get all Players we iterate over the names	
    	JSONArray names = allPlayersDataJToken.names();
    	
    	for(int i = 0; i < names.length(); i++)
    	{
        	try
        	{    
        		AllPlayerList.add(new AllPlayer(names.getLong(i), allPlayersDataJToken.getJSONObject(Long.toString(names.getLong(i)))));   	
        	}
        	catch(Exception e)
        	{
    		
        	}
    	}
    }
}
