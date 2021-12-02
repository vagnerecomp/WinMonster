package util;

abstract class HuffmanTree implements Comparable<HuffmanTree>{
	
	public int frequency=0;
	
	public HuffmanTree(int freq){
		frequency=freq;
		
	}
	public int compareTo(HuffmanTree tree){
		return frequency - tree.frequency;	
	}

}	