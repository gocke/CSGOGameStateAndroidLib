package master117.csgogameobserver;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Weapons
{
    public ArrayList<Weapon> WeaponList = new ArrayList<Weapon>();  

    public Weapons(JSONObject weaponsDataJToken)
    {        
    	//To get all weapons we iterate over the names
    	JSONArray names = weaponsDataJToken.names();
    	for(int i = 0; i < names.length(); i++)
    	{
        	try
        	{
        		WeaponList.add(new Weapon(weaponsDataJToken.getJSONObject(names.getString(i))));   	
        	}
        	catch(Exception e)
        	{
    		
        	}
    	}
    }
    

}
