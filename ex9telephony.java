import android.Manifest;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        EditText phone = findViewById(R.id.phone);
        EditText msg = findViewById(R.id.msg);
        Button btn = findViewById(R.id.btn);

        requestPermissions(
                new String[]{Manifest.permission.SEND_SMS}, 1);

        btn.setOnClickListener(v -> {
            SmsManager.getDefault().sendTextMessage(
                    phone.getText().toString(),
                    null,
                    msg.getText().toString(),
                    null,
                    null);

            Toast.makeText(this,
                    "SMS Sent",
                    Toast.LENGTH_SHORT).show();
        });
    }
}
<uses-permission android:name="android.permission.SEND_SMS"/>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <EditText
        android:id="@+id/phone"
        android:hint="Phone Number"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <EditText
        android:id="@+id/msg"
        android:hint="Message"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <Button
        android:id="@+id/btn"
        android:text="Send SMS"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
</LinearLayout>
