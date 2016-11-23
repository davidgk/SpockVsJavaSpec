package primosFinder;

import ar.com.dgarcia.javaspec.api.TestContext;

import java.util.function.Supplier;

/**
 * Created by davidgk on 21/11/16.
 */
public interface PrimosFinderContext extends TestContext {

  PrimosFinder primosFinder();
  void primosFinder(Supplier<PrimosFinder> primosFinderSupplier);

}
