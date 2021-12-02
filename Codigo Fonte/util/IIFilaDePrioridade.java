package util;

public interface IIFilaDePrioridade {
	   public boolean estaVazia();

	    public int obterTamanho();

	    public void inserirFinal(Object objeto, int chave);
	    
	    public void inserirInicio(Object objeto, int chave);
	    
	    public void inserirOrdenado(Object Objeto, int chave);

	    public Object removerInicio();

	    public Object recuperarInicio();   
	    
	    public Iterador iterador();

}
