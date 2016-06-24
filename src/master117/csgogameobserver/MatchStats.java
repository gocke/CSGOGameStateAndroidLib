package master117.csgogameobserver;

import org.json.JSONObject;

public class MatchStats
{
    public int Kills;
    public int Assists;
    public int Deaths;
    public int MVPs;
    public int Score;


    public MatchStats(JSONObject matchStatsDataJToken)
    {
    	try
    	{
	        Kills = matchStatsDataJToken.optInt("kills");
	        Assists = matchStatsDataJToken.optInt("assists");
	        Deaths = matchStatsDataJToken.optInt("deaths");
	        MVPs = matchStatsDataJToken.optInt("mvps");
	        Score = matchStatsDataJToken.optInt("score");
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
}
