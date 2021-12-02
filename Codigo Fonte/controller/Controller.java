package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.EscreverArquivo;
import util.FilaDePrioridade;
import util.HuffManCode;
import util.HuffmanNode;
import util.Iterador;

public class Controller {

	HuffManCode huffman = new HuffManCode();

	public StringBuffer  lerArquivo(String arq) throws IOException {
		BufferedReader ler = new BufferedReader(new FileReader(arq));
		String str = "";
		StringBuffer texto = null;
		while (ler.ready()) {
			str = ler.readLine();
			texto.append(str);
		}
		return texto;

	}

	public void escreveArquvioCompactado(String caminho, FilaDePrioridade fila, String code, String hashCode)
			throws FileNotFoundException, IOException {
		EscreverArquivo escreve = new EscreverArquivo();
		StringBuffer str = null;
		escreve.escritoBinario(caminho, code);
		escreve.escritorTxt(hashCode,caminho);		
		Iterador it  = fila.iterador();
		while(it.temProximo()){
			str.append(it.obterProximo().toString());
		}
		escreve.escritorTxt(fila.toString(), caminho);
		

	}

	public String compacta(String str) {
		String compactada;
		huffman.percorre(str);
		HuffmanNode tree = (HuffmanNode) huffman.criaArvore();
		compactada = huffman.encode(tree, str);

		return compactada;
	}

	public File descompacta(File arq) {
		return null;
	}
	// public boolean verificaHash(String str){
	// if(){
	//
	// }
	// return false;
	// }

}
