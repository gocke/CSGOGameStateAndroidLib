package master117.csgogameobserver;

import org.json.JSONObject;

public class Round
{
    public String Phase;
    public String Bomb;

    public Round(JSONObject roundDataJToken)
    {       
        try
		{
        	Phase = roundDataJToken.optString("phase");
			Bomb = roundDataJToken.optString("bomb");
		} catch (Exception e)
		{

		}
    }
}
