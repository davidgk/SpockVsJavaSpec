package primosFinder;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

/**
 * Created by davidgk on 21/11/16.
 */
@RunWith(JavaSpecRunner.class)
public class PrimosFinderTest extends JavaSpec<PrimosFinderContext> {
  @Override
  public void define() {

    describe("Encontrar los nros primos de una lista", ()->{
      context().primosFinder(PrimosFinder::create);

        describe("con una lista de nros hasta el 6",()->{
            it("Se encuentran los valores 1,2,3,5 ",()->{
              List nrosToTest = Arrays.asList(1,2,3,4,5,6);
              List primos = context().primosFinder().getPrimos(nrosToTest);
              assert(primos.containsAll(Arrays.asList(1,2,3,5)));
            });
          it("y la lista incluye el 0 Se encuentran los valores 1,2,3,5 ",()->{
              List nrosToTest = Arrays.asList(0,1,2,3,4,5,6);
              List primos = context().primosFinder().getPrimos(nrosToTest);
              assert(primos.containsAll(Arrays.asList(1,2,3,5)));
            });
      });
    });

  }
}