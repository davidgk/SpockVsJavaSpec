package primosFinder

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by davidgk on 23/11/16.
 */
class PrimosFinderSpec extends Specification {


  @Unroll("Dada la lista #lista obtengo como esperado los nros primos #listaResultado")
  void "Dada una lista de Enteros deseo hallar los nros Primos" () {
    given:
    PrimosFinder finder = PrimosFinder.create()
    when:
    def result = finder.getPrimos(lista)

    then:
    assert result.equals(listaResultado)
    where:
    lista                   |   listaResultado
    [1,2,3,4,5,6]           |  [1,2,3,5]
    [0,1,2,3,4,5,6]         |  [1,2,3,5]
    createListaLimited(40)  |  [1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37]

  }

  @Unroll("Dada la lista #lista obtengo como esperado los nros primos #listaResultado con algunas travesuras")
  void "Dada una lista de Enteros deseo hallar los nros Primos con algunas travesuras" () {
    given:
    def localizatePrimos = {getPrimos: { hacemosAlgoPrevio(it)}}

    PrimosFinder finder = [getPrimos: localizatePrimos] as PrimosFinder;//PrimosFinder.create()
    when:
    def result = finder.getPrimos(lista)

    then:
    assert result.equals(listaResultado)
    where:
    lista                   |   listaResultado
    [1,2,3,4,5,6]           |  [1,2,3,5]
    [0,1,2,3,4,5,6]         |  [1,2,3,5]
    createListaLimited(40)  |  [1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37]

  }


  def hacemosAlgoPrevio(value){
    PrimosFinder.create().getPrimos(value);
  }

  def createListaLimited(limit) {
    def lista = []
    for (int i = 1; i <= limit; i++) {
      lista << i
    }
    lista
  }
}
