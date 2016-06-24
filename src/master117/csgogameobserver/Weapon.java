package master117.csgogameobserver;

import org.json.JSONObject;

public class Weapon
{
    public String Name;
    public String PaintKit;
    public String Type;
    public int AmmoClip;
    public int AmmoClipMax;
    public int AmmoReserve;
    public String State;


    public Weapon(JSONObject weaponDataJToken)
    {
        try
		{
			Name = weaponDataJToken.optString("name");
	        PaintKit = weaponDataJToken.optString("paintkit");
	        Type = weaponDataJToken.optString("type");
	        AmmoClip = weaponDataJToken.optInt("ammo_clip");
	        AmmoClipMax = weaponDataJToken.optInt("ammo_clip_max");
	        AmmoReserve = weaponDataJToken.optInt("ammo_reserve");
	        State = weaponDataJToken.optString("state");
		} catch (Exception e)
		{

		}
    }
}
