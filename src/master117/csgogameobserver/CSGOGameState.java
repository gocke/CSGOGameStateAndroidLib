package master117.csgogameobserver;

import org.json.JSONObject;

public class CSGOGameState
{
    public Provider Provider;
    public Map Map;
    public Round Round;
    public Player Player;
    public AllPlayers AllPlayers;

    public CSGOGameState(JSONObject gameDataJObject)
    {
    	try
    	{
	        if(gameDataJObject.has("provider"))
	            Provider = new Provider(gameDataJObject.optJSONObject("provider"));
	
	        if (gameDataJObject.has("map"))
	            Map = new Map(gameDataJObject.optJSONObject("map"));
	
	        if (gameDataJObject.has("round"))
	            Round = new Round(gameDataJObject.optJSONObject("round"));
	
	        if (gameDataJObject.has("player"))
	            Player = new Player(gameDataJObject.optJSONObject("player"));
	
	        if (gameDataJObject.has("allplayers"))
	            AllPlayers = new AllPlayers(gameDataJObject.optJSONObject("allplayers"));
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
}
