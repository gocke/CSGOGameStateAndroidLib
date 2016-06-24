package master117.csgogameobserver;

import org.json.JSONObject;

public class Provider
{
    public String Name;
    public int Appid;
    public long Version;
    public long Steamid;
    public long Timestamp;

    public Provider(JSONObject providerData)
    {
    	try
    	{   		
    		Name = providerData.optString("name");
    		Appid = providerData.optInt("appid");
    		Version = providerData.optLong("version");
    		Steamid = providerData.optLong("steamid");
    		Timestamp = providerData.optLong("timestamp");
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
}
