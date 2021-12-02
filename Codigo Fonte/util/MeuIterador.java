package util;

/**
* Componente Curricular: Módulo Integrado de Programação
* Autor: Saulo Araujo
* Data:  11/10/2014
*
* Declaro que este código foi elaborado por mim de forma individual e
* não contém nenhum trecho de código de outro colega ou de outro autor, 
* tais como provindos de livros e apostilas, e páginas ou documentos 
* eletrônicos da Internet. Qualquer trecho de código de outra autoria que
* uma citação para o  não a minha está destacado com  autor e a fonte do
* código, e estou ciente que estes trechos não serão considerados para fins
* de avaliação. Alguns trechos do código podem coincidir com de outros
* colegas pois estes foram discutidos em sessões tutorias.
*/

/**

* Esta classe é usada para implementar um iterador para uma Lista encadeada. O
* iterador é usado para percorrer a lista.
* 
* @author Saulo Araujo
* 
*/
public class MeuIterador implements Iterador {

    private Celula referenciaPrimeiro;

    
   /**
   * Construtor da classe, que inicializa o "no" apontando o mesmo para a
   * referência do primeiro elemento da lista, sendo que este é passado
   * por parâmetro.
   * 
   * @param referenciaPrimeiro No - recebe a refrência do primeiro elemento.
   */
    public MeuIterador(Celula referenciaPrimeiro) {
        this.referenciaPrimeiro = referenciaPrimeiro;
    }

    /**
     * Método usado apra verificar se existe um próximo Objeto na lista.
     * 
     * @author Saulo araujo.
     * @return Verdadeiro se houver um proximo elemento, senão retorna falso.
     */
    @Override
    public boolean temProximo() {
        return (referenciaPrimeiro != null);
    }

    /**
    * Método que retorna o proximo objeto da lista.
    * @author Saulo Araujo
    * @return objeto da lista encadeada.
    */

    @Override
    public Object obterProximo() {
        if (temProximo() == false) {
            return null;
        } else {
            Object objeto = referenciaPrimeiro.getObjeto();
            referenciaPrimeiro = referenciaPrimeiro.getNext();
            return objeto;
        }
    }

}
