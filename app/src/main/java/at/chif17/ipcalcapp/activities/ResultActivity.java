package at.chif17.ipcalcapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import at.chif17.ipcalcapp.R;
import at.chif17.ipcalcapp.iputils.IPv4Address;
import at.chif17.ipcalcapp.iputils.Prefix;

public class ResultActivity extends AppCompatActivity {

  private TextView tvIPAddressValue;
  private TextView tvSubnetMaskValue;
  private TextView tvNetworkAddressValue;
  private TextView tvNetworkBroadcastValue;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_result);

    tvIPAddressValue = findViewById(R.id.tvIPAddressValue);
    tvSubnetMaskValue = findViewById(R.id.tvSubnetMaskValue);
    tvNetworkAddressValue = findViewById(R.id.tvNetworkAddressValue);
    tvNetworkBroadcastValue = findViewById(R.id.tvNetworkBroadcastValue);

    Intent intent = getIntent();

    if (intent != null && intent.getStringExtra("ip-address") != null && intent.getStringExtra("prefixTo") != null) {
      IPv4Address address = IPv4Address.fromString(intent.getStringExtra("ip-address"));
      Prefix toPrefix = new Prefix(intent.getIntExtra("prefixTo", 24));

      calculateAddresses(address, toPrefix, intent.getBooleanExtra("binaryAddresses", false));
    } else finish();
  }

  private void calculateAddresses(IPv4Address address, Prefix toPrefix, boolean binary) {
    if (!binary) {
      tvIPAddressValue.setText(address.toString());
      tvSubnetMaskValue.setText(toPrefix.toSubnetMask());
    } else {
      tvIPAddressValue.setText(address.toBinaryString());
      tvSubnetMaskValue.setText(toPrefix.toSubnetMask());
    }
  }
}
