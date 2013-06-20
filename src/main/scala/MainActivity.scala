package org.seacourt.gps

import _root_.android.app.Activity
import _root_.android.os.Bundle

import _root_.android.view.View
import _root_.android.widget.Button
import _root_.android.widget.Toast

// http://www.androidhive.info/2012/07/android-gps-location-manager-tutorial/
class MainActivity extends Activity with TypedActivity
{
    var btnShowLocation : Button = null
    var gps : com.example.gpstracking.GPSTracker = null
    
    override def onCreate(bundle: Bundle)
    {
        super.onCreate(bundle)
        setContentView(R.layout.main)

        btnShowLocation = findViewById(R.id.btnShowLocation).asInstanceOf[Button]
        
        btnShowLocation.setOnClickListener( new View.OnClickListener()
        {
            override def onClick( arg0 : View )
            {
                gps = new com.example.gpstracking.GPSTracker(MainActivity.this)
                if ( gps.canGetLocation )
                {
                    val lon = gps.getLongitude()
                    val lat = gps.getLatitude()
                    
                    Toast.makeText(
                        getApplicationContext(),
                        "Your Location is - \nLat: " + lat + "\nLong: " + lon, Toast.LENGTH_LONG
                    ).show()
                }
                else
                {
                    gps.showSettingsAlert()
                }
            }
        } )

        //findView(TR.textview).setText("hello, world!")
    }
}
