import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float font = 24;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView t1 = findViewById(R.id.textView1);
        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.button2);

        // Increase Font Size
        b1.setOnClickListener(view -> {
            t1.setTextSize(font);
            font = font + 4;

            if (font == 40)
                font = 20;
        });

        // Change Text Color
        b2.setOnClickListener(view -> {
            switch (i) {
                case 1:
                    t1.setTextColor(Color.BLUE);
                    break;

                case 2:
                    t1.setTextColor(Color.GREEN);
                    break;

                case 3:
                    t1.setTextColor(Color.RED);
                    break;

                case 4:
                    t1.setTextColor(Color.MAGENTA);
                    break;
            }

            i++;

            if (i == 5)
                i = 1;
        });
    }
}


<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="20dp">

    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Android Programming"
        android:textSize="24sp"
        android:padding="20dp" />

    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Increase Font Size" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Change Color"
        android:layout_marginTop="10dp" />

</LinearLayout>
