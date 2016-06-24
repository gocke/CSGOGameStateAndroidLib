package master117.csgogameobserver.test;
import master117.csgogameobserver.CSGOGameState;
import master117.csgogameobserver.ServerMessageReceiver;

public class Receiver implements ServerMessageReceiver
{

	@Override
	public void receiveCSGOServerMessage(CSGOGameState arg0)
	{
		// TODO Auto-generated method stub
		if(arg0.Player != null && arg0.Player.Name != null)
			System.out.println(arg0.Player.Name);
	}
}
