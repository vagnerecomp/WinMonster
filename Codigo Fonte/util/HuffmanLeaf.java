package util;

public class HuffmanLeaf extends HuffmanTree{
	public final char caract;
	public HuffmanLeaf(int freq, char crct){
		super(freq);
		caract = crct;
	}
}