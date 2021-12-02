package util;

import util.MyIterator;

public class FilaDePrioridade implements IIFilaDePrioridade {
	private Celula first = null;
	private Celula last = null;
	private int contObjetos = 0;

	@Override
	public boolean estaVazia() {
		// TODO Auto-generated method stub
		return this.contObjetos == 0;
	}

	@Override
	public int obterTamanho() {
		// TODO Auto-generated method stub
		return this.contObjetos;
	}

	@Override
	public void inserirInicio(Object objeto, int chave) {
		// TODO Auto-generated method stub
		Celula nova = new Celula(objeto, chave);
		if (this.contObjetos == 0) {
			this.first = nova;
			this.last = nova;
			this.contObjetos++;
		} else if (nova.getChave() <= this.first.getChave()) {
			nova.setNext(this.first);
			this.first.setPrevious(nova);
			this.first = nova;
			this.contObjetos++;
		} else {
			throw new RuntimeException("Esse objeto possui menos prioridade");
		}

	}

	@Override
	public void inserirFinal(Object objeto, int chave) {
		// TODO Auto-generated method stub
		Celula nova = new Celula(objeto, chave);
		if (this.contObjetos == 0) {
			inserirInicio(objeto, chave);
		} else if (!(nova.getChave() < this.last.getChave())) {
			nova.setPrevious(this.last);
			this.last.setNext(nova);
			this.last = nova;
			this.contObjetos++;
		} else {
			throw new RuntimeException("Esse objeto tem mais prioridade que o ultimo.");
		}

	}

	@Override
	public void inserirOrdenado(Object objeto, int chave) {
		// TODO Auto-generated method stub
		Celula nova = new Celula(objeto, chave);
		// counter possui o mesmo valor que contObjetos até que uma nova célula
		// seja inserida na fila.
		int counter = this.contObjetos;
		if (this.contObjetos == 0) {
			this.first = nova;
			this.last = nova;
			this.contObjetos++;
		} else if (this.last.getChave() <= nova.getChave()) {
			inserirFinal(objeto, chave);
		} else if (this.first.getChave() >= nova.getChave()) {
			inserirInicio(objeto, chave);
			// Se counter for igual a contObjetos significa qua a nova celula
			// ainda não foi inserida na fila.
		} else if (counter == this.contObjetos) {
			MyIterator x = new MyIterator(this.first);
			Celula aux = this.first;

			while (x.temProximo()) {
				if (nova.getChave() > aux.getChave() && nova.getChave() < aux.getNext().getChave()) {
					nova.setNext(aux.getNext());
					nova.setPrevious(aux);
					aux.getNext().setPrevious(nova);
					aux.setNext(nova);
					this.contObjetos++;

				}

				if (counter != this.contObjetos) {
					break;
				}
				aux = x.obterProximo();
			}
		}

	}

	@Override
	public Object removerInicio() {
		// TODO Auto-generated method stub
		Celula aux = this.first;
		this.first = this.first.getNext();
		aux.setNext(null);
		this.contObjetos--;
		if (this.contObjetos == 0)
			return aux;
		this.first.setPrevious(null);
		return aux;
	}

	@Override
	public Object recuperarInicio() {
		// TODO Auto-generated method stub
		return this.first;
	}

	@Override
	public Iterador iterador() {
		// TODO Auto-generated method stub
		Iterador it = new MeuIterador(this.first);
		return it;
	}

	public Celula getFirst() {
		return first;
	}

	public void setFirst(Celula first) {
		this.first = first;
	}

	public Celula getLast() {
		return last;
	}

	public void setLast(Celula last) {
		this.last = last;
	}

	public int getContObjetos() {
		return contObjetos;
	}

	public void setContObjetos(int contObjetos) {
		this.contObjetos = contObjetos;
	}

}
