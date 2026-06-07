import android.Manifest;
import android.location.*;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        WebView web = findViewById(R.id.web);
        TextView tv = findViewById(R.id.tv);
        Button btn = findViewById(R.id.btn);

        web.loadUrl("https://google.com");

        requestPermissions(
            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);

        btn.setOnClickListener(v -> {
            LocationManager lm =
            (LocationManager)getSystemService(LOCATION_SERVICE);

            Location l =
            lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            if(l!=null)
                tv.setText("Lat:"+l.getLatitude()+
                           "\nLon:"+l.getLongitude());
        });
    }
}

<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>

    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <Button
        android:id="@+id/btn"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Get Location"/>

    <TextView
        android:id="@+id/tv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Location"/>

    <WebView
        android:id="@+id/web"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
</LinearLayout>
