package master117.csgogameobserver;

import org.json.JSONObject;

public class Map
{
    public String Mode;
    public String Name;
    public String Phase;
    public int Round;
    public TeamCT TeamCT;
    public TeamT TeamT;

    public Map(JSONObject mapDataJToken)
    {
    	try
    	{
	        Mode = mapDataJToken.optString("mode");
	        Name = mapDataJToken.optString("name");
	        Phase = mapDataJToken.optString("phase");
	        Round = mapDataJToken.optInt("round");
	
	        if (mapDataJToken.has("team_ct"))
	            TeamCT = new TeamCT(mapDataJToken.optJSONObject("team_ct"));
	        if (mapDataJToken.has("team_t"))
	            TeamT = new TeamT(mapDataJToken.optJSONObject("team_t"));
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
}
