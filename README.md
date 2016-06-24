## About ##

* This is a Library, for developing android apps for CSGO
* Version 1.0

## Install/Run Instructions ##

* Add .jar to your Project, maybe remove AppManifest.xml from it
* Create your own config according to: https://developer.valvesoftware.com/wiki/Counter-Strike:_Global_Offensive_Game_State_Integration
* remember to set Permission to use Internet: <uses-permission android:name="android.permission.INTERNET"/>

## Use Instructions ##

* Implement ServerMessageReceiver
* Create a CSGOGameObserver Object (with the CSGOClient Server port), 
* Start CSGOGameObserver
* Receive GameData in the handy CSGOGameData format


```
#!android

import master117.csgogameobserver.*;

public class MainActivity extends AppCompatActivity implements ServerMessageReceiver {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        CSGOGameObserver csgoGameObserver = new CSGOGameObserver(3000, this);
        csgoGameObserver.Start();
    }

    @Override
    public void receiveCSGOServerMessage(CSGOGameData csgoGameData) {
        System.out.println(jsonObject.toString());
        return null;
    }


```


JObject gameData contains a JSON Object that is structured similar to this:


```
#!JSON

{{
  "provider": {
    "name": "Counter-Strike: Global Offensive",
    "appid": 730,
    "version": 13514,
    "steamid": "123456789",
    "timestamp": 1449910114
  },
  "map": {
    "mode": "casual",
    "name": "de_overpass",
    "phase": "live",
    "round": 1,
    "team_ct": {
      "score": 0
    },
    "team_t": {
      "score": 1
    }
  },
  "round": {
    "phase": "live",
    "bomb": "planted"
  },
  "player": {
    "steamid": "123456789",
    "clan": "RWBY",
    "name": "master117 - Yang",
    "team": "T",
    "activity": "playing",
    "state": {
      "health": 28,
      "armor": 62,
      "helmet": true,
      "flashed": 0,
      "smoked": 0,
      "burning": 0,
      "money": 3700,
      "round_kills": 0,
      "round_killhs": 0
    },
    "weapons": {
      "weapon_0": {
        "name": "weapon_knife_tactical",
        "paintkit": "default",
        "type": "Knife",
        "state": "holstered"
      },
      "weapon_1": {
        "name": "weapon_glock",
        "paintkit": "gs_glock18_wrathys",
        "type": "Pistol",
        "ammo_clip": 20,
        "ammo_clip_max": 20,
        "ammo_reserve": 102,
        "state": "active"
      }
    },
    "match_stats": {
      "kills": 0,
      "assists": 1,
      "deaths": 0,
      "mvps": 0,
      "score": 1
    }
  },
  "auth": {
    "token": "abc123"
  }
}}

```

## How can I Contribution? ##

* Write any test you like
* Audit/Review the Code
* Send Mergerequests with additional features.
* Write a Documentation / Comments

## About me/Contact ##

* Johannes Gocke
* email: johannes_gocke@hotmail.de
* steam: http://steamcommunity.com/id/master117/