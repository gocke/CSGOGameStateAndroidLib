package master117.csgogameobserver;

import org.json.JSONObject;

public class TeamCT
{
    public int Score;

    public TeamCT(JSONObject teamCTDataJToken)
    {
        try
		{
			Score = teamCTDataJToken.optInt("score");
		} catch (Exception e)
		{
			
		}
    }
}
