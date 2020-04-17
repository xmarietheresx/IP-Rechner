package at.chif17.ipcalcapp.utils;

public class IntegerUtils {

  public static boolean isBetween(int min, int max, int... num) {
    for (int i : num) if (!(i >= min && i <= max)) return false;
    return true;
  }

}
