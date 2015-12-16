package master117.csgogameobserver;

import org.json.JSONObject;

public interface ServerMessageReceiver
{
	public JSONObject receiveCSGOServerMessage(JSONObject jsonObject);
}
