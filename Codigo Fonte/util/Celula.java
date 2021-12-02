package util;

public class Celula {
	private Celula next = null;
	private Celula previous = null;
	private  int chave;
	private Object objeto;
	
	public Celula (Object objeto, int chave){
		this.objeto = objeto;
		this.chave = chave;
	}

	public Celula getNext() {
		return next;
	}

	public Celula getPrevious() {
		return previous;
	}

	public void setPrevious(Celula previous) {
		this.previous = previous;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

	public void setNext(Celula next) {
		this.next = next;
	}

}
