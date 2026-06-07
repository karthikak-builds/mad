
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends Activity {

    EditText roll, name, marks;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roll = findViewById(R.id.roll);
        name = findViewById(R.id.name);
        marks = findViewById(R.id.marks);

        Button insert = findViewById(R.id.insert);
        Button delete = findViewById(R.id.delete);
        Button update = findViewById(R.id.update);
        Button view = findViewById(R.id.view);
        Button viewall = findViewById(R.id.viewall);

        db = openOrCreateDatabase("StudentDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(roll TEXT,name TEXT,marks TEXT)");

        insert.setOnClickListener(v -> {
            db.execSQL("INSERT INTO student VALUES('" + roll.getText() + "','" +
                    name.getText() + "','" + marks.getText() + "')");
            Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
        });

        delete.setOnClickListener(v -> {
            db.execSQL("DELETE FROM student WHERE roll='" + roll.getText() + "'");
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        });

        update.setOnClickListener(v -> {
            db.execSQL("UPDATE student SET name='" + name.getText() +
                    "', marks='" + marks.getText() +
                    "' WHERE roll='" + roll.getText() + "'");
            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
        });

        view.setOnClickListener(v -> {
            Cursor c = db.rawQuery(
                    "SELECT * FROM student WHERE roll='" + roll.getText() + "'",
                    null);

            if (c.moveToFirst()) {
                name.setText(c.getString(1));
                marks.setText(c.getString(2));
            }
        });

        viewall.setOnClickListener(v -> {
            Cursor c = db.rawQuery("SELECT * FROM student", null);

            String s = "";
            while (c.moveToNext()) {
                s += c.getString(0) + " "
                   + c.getString(1) + " "
                   + c.getString(2) + "\n";
            }

            Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        });
    }
}
