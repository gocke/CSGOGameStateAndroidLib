package master117.csgogameobserver;

import org.json.JSONObject;

public class AllPlayer
{
    public long Steamid;
    public String Clan;
    public String Name;
    public String Team;
    public String Activity;
    public State State;
    public MatchStats MatchStats;

    public AllPlayer(long tempSteamId, JSONObject allPlayerDataJToken)
    {
    	try
    	{
	        Steamid = tempSteamId;     
	
	        Clan = allPlayerDataJToken.optString("clan");
	        Name = allPlayerDataJToken.optString("name");
	        Team = allPlayerDataJToken.optString("team");
	
	        if (allPlayerDataJToken.has("state"))
	            State = new State(allPlayerDataJToken.optJSONObject("state"));
	        if (allPlayerDataJToken.has("match_stats"))
	            MatchStats = new MatchStats(allPlayerDataJToken.optJSONObject("match_stats"));
	    }
    	catch(Exception e)
    	{
    		
    	}
    }
}
