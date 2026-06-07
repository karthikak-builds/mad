import android.Manifest;
import android.location.*;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        TextView tv = findViewById(R.id.tv);

        requestPermissions(
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        btn.setOnClickListener(v -> {

            LocationManager lm =
                    (LocationManager) getSystemService(LOCATION_SERVICE);

            Location loc =
                    lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            if (loc != null)
                tv.setText("Lat: " + loc.getLatitude() +
                           "\nLon: " + loc.getLongitude());
        });
    }
}
