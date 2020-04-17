package at.chif17.ipcalcapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import at.chif17.ipcalcapp.R;
import at.chif17.ipcalcapp.iputils.IPv4Address;
import at.chif17.ipcalcapp.iputils.Prefix;

public class MainActivity extends AppCompatActivity {

    private EditText etIp1;
    private EditText etIp2;
    private EditText etIp3;
    private EditText etIp4;
    private EditText etIpPrefix;
    private EditText etPrefixTo;

    private CheckBox cbBinaryAddresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etIp1 = findViewById(R.id.etIp1);
        etIp2 = findViewById(R.id.etIp2);
        etIp3 = findViewById(R.id.etIp3);
        etIp4 = findViewById(R.id.etIp4);
        etIpPrefix = findViewById(R.id.etIpPrefix);
        etPrefixTo = findViewById(R.id.etPrefixTo);

        cbBinaryAddresses = findViewById(R.id.cbBinaryAddress);
    }

    public void calculate(View view) {
        IPv4Address address = new IPv4Address(
            Integer.parseInt(String.valueOf(etIp1.getText())),
            Integer.parseInt(String.valueOf(etIp2.getText())),
            Integer.parseInt(String.valueOf(etIp3.getText())),
            Integer.parseInt(String.valueOf(etIp4.getText())),
            new Prefix(Integer.parseInt(String.valueOf(etIpPrefix.getText())))
        );

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("ip-address", address.toString());
        intent.putExtra("prefixTo", String.valueOf(etPrefixTo.getText()));
        intent.putExtra("binaryAddresses", cbBinaryAddresses.isChecked());

        startActivity(intent);
    }
}
