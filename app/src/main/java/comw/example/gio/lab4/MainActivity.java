package comw.example.gio.lab4;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_toast, btn_snackBar,btn_snackBarWithAct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_toast = findViewById(R.id.btn_toast);
        btn_snackBar = findViewById(R.id.btn_snackBar);
        btn_snackBarWithAct = findViewById(R.id.btn_snackBarWithAct);

        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "Toast";
                int duration = Toast.LENGTH_SHORT;
                Toast.makeText(getApplicationContext(), message, duration).show();
            }
        });
        btn_snackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = findViewById(R.id.main_layout_id);
                String message = "Snackbar Message";
                int duration = Snackbar.LENGTH_SHORT;

                showSnackBar(v, message, duration);
            }
        });
        btn_snackBarWithAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = findViewById(R.id.main_layout_id);
                String message = "Snackbar message with action";
                int duration = Snackbar.LENGTH_SHORT;

                showSnackBarAct(v, message, duration);
            }
        });
    }
    public void showSnackBar(View view, String message, int duration){
        Snackbar.make(view, message, duration).show();
    }
    public void showSnackBarAct(View v, String message, int duration){
        final Snackbar snackbar = Snackbar.make(v, message, duration);
        snackbar.setAction("Dismiss", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        });

        snackbar.show();
    }
}
