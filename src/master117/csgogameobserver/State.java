package master117.csgogameobserver;

import org.json.JSONObject;

public class State
{
    public int Health;
    public int Armor;
    public Boolean Helmet;
    public int Flashed;
    public int Smoked;
    public int Burning;
    public int Money;
    public int RoundKills;
    public int RoundKillHs;

    public State(JSONObject stateDataJToken)
    {
    	try
    	{
    		Health = stateDataJToken.optInt("health");
    		Armor = stateDataJToken.optInt("armor");
    		Helmet = stateDataJToken.optBoolean("helmet");
    		Flashed = stateDataJToken.optInt("flashed");
    		Smoked = stateDataJToken.optInt("smoked");
    		Burning = stateDataJToken.optInt("burning");
    		Money = stateDataJToken.optInt("money");
    		RoundKills = stateDataJToken.optInt("round_kills");
        	RoundKillHs = stateDataJToken.optInt("round_killhs");
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
}
