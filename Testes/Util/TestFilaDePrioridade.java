package Util;

import static org.junit.Assert.*;

import org.junit.Test;

import util.Celula;
import util.FilaDePrioridade;
import util.Iterador;

public class TestFilaDePrioridade {

	//Esse método testa o método inserirInicio da fila de prioridade
	@Test
	public void testInserirInicio() {
		FilaDePrioridade fila = new FilaDePrioridade();
		try{
			fila.inserirInicio("mesa", 3);
			fila.inserirInicio("cadeira", 1);
		}catch(RuntimeException e){
			fail();
		}
		
		try{
			Celula f =(Celula) fila.recuperarInicio();
			String s = (String) f.getObjeto();
			assertEquals(s, "cadeira");
		}catch(RuntimeException e){
			fail();
		}
	}
	
	@Test
	public void TestRemoverInicio(){
		try{
			FilaDePrioridade fila = new FilaDePrioridade();
			fila.inserirOrdenado("mesa", 3);
			fila.inserirOrdenado("cadeira", 6);
			fila.inserirOrdenado("vagnata", 2);
			Celula aux = (Celula) fila.removerInicio();
			assertNotNull(aux);
			assertEquals(aux.getObjeto(), "vagnata");
			Celula aux2 = (Celula) fila.removerInicio();
			assertNotNull(aux2);
			assertEquals(aux2.getObjeto(), "mesa");
			Celula aux3 = (Celula) fila.removerInicio();
			assertNotNull(aux3);
			assertEquals(aux3.getObjeto(), "cadeira");
		}catch(RuntimeException e){
			fail();
		}
		
	}
	

	//Testa a inserção ordenada dos objetos na fila de prioridade.
	@Test
	public void TestInserirOrdenado(){
		FilaDePrioridade fila1 = new FilaDePrioridade();
		
		fila1.inserirOrdenado("mesa", 10);
		fila1.inserirOrdenado("cadeira", 4);
		fila1.inserirOrdenado("winmonster", 6);
		fila1.inserirOrdenado("primeiro", 1);
		
		
		try{
			Celula aux = (Celula) fila1.recuperarInicio();
			assertEquals(aux.getObjeto().toString(), "primeiro");
		}catch(RuntimeException e){
			fail();
		}
		String []aux = new String[4];
		aux[0] = (String)fila1.getFirst().getObjeto();
		
		int i=0;
		Iterador it = fila1.iterador();
		while(it.temProximo()){
			aux[i]=(String)it.obterProximo();
			i++;
			
		}
		assertEquals("primeiro", aux[0]);
		assertEquals("cadeira", aux[1]);
		assertEquals("winmonster", aux[2]);
		assertEquals("mesa", aux[3]);
	

		
		
		
	}
}