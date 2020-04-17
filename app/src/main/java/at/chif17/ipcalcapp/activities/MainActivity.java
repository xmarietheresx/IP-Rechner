package at.chif17.ipcalcapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import at.chif17.ipcalcapp.R;
import at.chif17.ipcalcapp.iputils.IPv4Address;

import java.sql.ResultSet;

public class MainActivity extends AppCompatActivity {

    private EditText ip1;
    private EditText ip2;
    private EditText ip3;
    private EditText ip4;
    private EditText ipPrefix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ip1 = findViewById(R.id.etIp1);
        ip2 = findViewById(R.id.etIp2);
        ip3 = findViewById(R.id.etIp3);
        ip4 = findViewById(R.id.etIp4);
        ipPrefix = findViewById(R.id.etIpPrefix);
    }

    public void calculate(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }
}
