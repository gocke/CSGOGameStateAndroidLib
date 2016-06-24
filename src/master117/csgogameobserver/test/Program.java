package master117.csgogameobserver.test;
import master117.csgogameobserver.CSGOGameObserver;

public class Program
{
	public static void main(String[] args)
	{
		Receiver receiver = new Receiver();
		CSGOGameObserver csgoGameObserver = new CSGOGameObserver(3300, receiver);
		csgoGameObserver.Start();
	}
}
