package at.chif17.ipcalcapp.iputils;

import at.chif17.ipcalcapp.utils.IntegerUtils;

public class IPv4Address {

  int ipp1;
  int ipp2;
  int ipp3;
  int ipp4;
  int prefix;

  public IPv4Address(int ipp1, int ipp2, int ipp3, int ipp4, int prefix) throws IllegalArgumentException{

    if(!IntegerUtils.isBetween(0, 255, ipp1, ipp2, ipp3, ipp4)) throw new IllegalArgumentException("IPv4 address not in range of 0 - 255");
    if(!IntegerUtils.isBetween(0, 32, prefix)) throw new IllegalArgumentException("IP prefix not in range of 0 - 32");

    this.ipp1 = ipp1;
    this.ipp2 = ipp2;
    this.ipp3 = ipp3;
    this.ipp4 = ipp4;
    this.prefix = prefix;
  }
}
