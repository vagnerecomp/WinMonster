package controllerTest;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import controller.Controller;

public class ControllerTeste {
	Controller control = new Controller();

	//testLerArquivo tem uma StringBuffer que recebe valor nulo em primeiro momento e tenta iniciálizá-la com
	//o retorno do método lerArquivo() do controller. O teste falha se essa variável for nula após a chamada do método.
	@Test
	public void testLerArquivo() {
		StringBuffer str = null;
		try{
			str = control.lerArquivo("arquivo.txt");
			assertNotNull(str);
			
			
		}catch(IOException e){
			fail();
			
		}
		
	}
	
	
	
	

}
