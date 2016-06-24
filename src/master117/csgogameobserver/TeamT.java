package master117.csgogameobserver;

import org.json.JSONObject;

public class TeamT
{
    public int Score;

    public TeamT(JSONObject teamTDataJToken)
    {
        try
		{
			Score = teamTDataJToken.optInt("score");
		} catch (Exception e)
		{
			
		}
    }
}
