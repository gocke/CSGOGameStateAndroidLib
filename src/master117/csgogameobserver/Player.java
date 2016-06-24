package master117.csgogameobserver;

import org.json.JSONObject;

public class Player
{
    public long Steamid;
    public String Clan;
    public String Name;
    public String Team;
    public String Activity;
    public State State;
    public Weapons Weapons;
    public MatchStats MatchStats;

    public Player(JSONObject playerDataJToken)
    {
    	try
    	{
	        Steamid = playerDataJToken.optLong("steamid");
	        Clan = playerDataJToken.optString("clan");
	        Name = playerDataJToken.optString("name");
	        Team = playerDataJToken.optString("team");
	        Activity = playerDataJToken.optString("activity");
	
	        if (playerDataJToken.has("state"))
	            State = new State(playerDataJToken.optJSONObject("state"));
	        if (playerDataJToken.has("weapons"))
	            Weapons = new Weapons(playerDataJToken.optJSONObject("weapons"));
	        if (playerDataJToken.has("match_stats"))
	            MatchStats = new MatchStats(playerDataJToken.optJSONObject("match_stats"));
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
}