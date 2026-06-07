import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int task = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        LinearLayout container = findViewById(R.id.container);

        btn.setOnClickListener(v -> {

            int t = task++;

            new Thread(() -> {

                addText(container, "Task " + t + " Started");

                for (int i = 1; i <= 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) { }

                    addText(container, "Task " + t + " Step " + i);
                }

                addText(container, "Task " + t + " Completed");

            }).start();
        });
    }

    private void addText(LinearLayout container, String msg) {
        runOnUiThread(() -> {
            TextView tv = new TextView(this);
            tv.setText(msg);
            container.addView(tv);
        });
    }
}


<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="10dp">

    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Start Task" />

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:id="@+id/container"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical" />

    </ScrollView>

</LinearLayout>
