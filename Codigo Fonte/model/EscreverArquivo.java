package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.BitSet;
import java.util.Scanner;

import util.HuffManCode;

public class EscreverArquivo {
	
	public static void escritorTxt(String str,String caminho) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminho));
		buffWrite.append(str);
		buffWrite.close();
	}

	public void escritoBinario(String caminho, String code) throws FileNotFoundException, IOException {
		try {
			FileOutputStream file = new FileOutputStream(caminho);
			ObjectOutputStream stream = new ObjectOutputStream(file);

			BitSet bit = new BitSet();
			char[] vetChar = code.toCharArray();
			bit.set(code.length() + 1, true);
			for (int i = code.length(); i > 0; i--) {
				if (vetChar[i] == '1') {
					bit.set(i, true);
				}
			}
			stream.writeObject(bit.toByteArray());
			stream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
