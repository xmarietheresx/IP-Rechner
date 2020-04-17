package at.chif17.ipcalcapp.iputils;

import android.support.annotation.NonNull;
import at.chif17.ipcalcapp.utils.IntegerUtils;

import java.util.Locale;

public class IPv4Address {

  int ipp1;
  int ipp2;
  int ipp3;
  int ipp4;
  Prefix prefix;

  public IPv4Address(int ipp1, int ipp2, int ipp3, int ipp4, Prefix prefix) throws IllegalArgumentException{

    if(!IntegerUtils.isBetween(0, 255, ipp1, ipp2, ipp3, ipp4)) throw new IllegalArgumentException("IPv4 address not in range of 0 - 255");

    this.ipp1 = ipp1;
    this.ipp2 = ipp2;
    this.ipp3 = ipp3;
    this.ipp4 = ipp4;
    this.prefix = prefix;
  }

  public int getIpp1() {
    return ipp1;
  }

  public int getIpp2() {
    return ipp2;
  }

  public int getIpp3() {
    return ipp3;
  }

  public int getIpp4() {
    return ipp4;
  }

  public Prefix getPrefix() {
    return prefix;
  }

  public String toBinaryString() {
    return String.format(Locale.ENGLISH, "%08d %08d %08d %08d",
        Integer.parseInt(Integer.toBinaryString(ipp1)),
        Integer.parseInt(Integer.toBinaryString(ipp2)),
        Integer.parseInt(Integer.toBinaryString(ipp3)),
        Integer.parseInt(Integer.toBinaryString(ipp4)),
        prefix
    );
  }

  @NonNull
  @Override
  public String toString() {
    return ipp1 + "." + ipp2 + "." + ipp3 + "." + ipp4 + "/" + prefix.getPrefix();
  }

  public static IPv4Address fromString(String address) throws IllegalArgumentException {
    String[] parts = address.split("[\\./]");

    int ipp1 = Integer.parseInt(parts[0]);
    int ipp2 = Integer.parseInt(parts[1]);
    int ipp3 = Integer.parseInt(parts[2]);
    int ipp4 = Integer.parseInt(parts[3]);
    Prefix prefix = new Prefix(Integer.parseInt(parts[4]));

    return new IPv4Address(ipp1, ipp2, ipp3, ipp4, prefix);
  }
}
