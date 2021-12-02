package util;

public class HuffmanNode extends HuffmanTree{

	public final HuffmanTree left,right; // subArvores
		
	public HuffmanNode(HuffmanTree l, HuffmanTree r) {
		super(l.frequency+r.frequency);
		left = l;
		right = r;
	}	
}
