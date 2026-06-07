import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.editText);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(v -> {
            try {
                ContentValues cv = new ContentValues();
                cv.put(MediaStore.MediaColumns.DISPLAY_NAME, "data.txt");
                cv.put(MediaStore.MediaColumns.RELATIVE_PATH,
                        Environment.DIRECTORY_DOWNLOADS);

                Uri uri = getContentResolver().insert(
                        MediaStore.Files.getContentUri("external"), cv);

                OutputStream os = getContentResolver().openOutputStream(uri);
                os.write(et.getText().toString().getBytes());
                os.close();

                Toast.makeText(this,
                        "Saved in Downloads",
                        Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}


<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:padding="20dp"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <EditText
        android:id="@+id/editText"
        android:hint="Enter Text"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <Button
        android:id="@+id/button"
        android:text="Save"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

</LinearLayout>
