package primosFinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidgk on 21/11/16.
 */
public class PrimosFinder {

  public static PrimosFinder create() {
    PrimosFinder primosFinder = new PrimosFinder();
    return primosFinder;
  }

  public List getPrimos(List<Integer> nrosToTest) {
    List primos = new ArrayList();
    nrosToTest.stream().forEach((value)->{
      int cant = 0;
      if (value == 0){
        cant = 3;
      }else{
        for (int i = 1; i <= value ; i++) {
          double resto = value%i;
          if(resto == 0){
            cant++;
          }
        }
      }
      if(cant <= 2){
        primos.add(value);
      }
    });
    return primos;
  }
}
