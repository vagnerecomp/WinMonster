package util;

public class MyIterator{
    
    private Celula atual;
    
    public MyIterator(Celula atual){
        this.atual = atual;
    }

    MyIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean temProximo() {
        return (atual != null);        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Celula obterProximo() { //O metodo obter proximo retorna o Objeto da celula em que referencia no momento.
        Celula aux = atual;
        while (temProximo()){ // temProximo retorna valores booleandos do estado da lista.
            atual = atual.getNext();
            return aux;
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}