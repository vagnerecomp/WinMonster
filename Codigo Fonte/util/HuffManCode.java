package util;

import java.util.PriorityQueue;

public class HuffManCode {
	int charsFreq[] = new int[256];

	public void percorre(String str) {
		for (char c : str.toCharArray())
			charsFreq[c]++;
	}

	public HuffmanTree criaArvore() {
		HuffmanTree tree = buildTree(charsFreq);
		return tree;
	}

	private static HuffmanTree buildTree(int[] charFreq) {
		FilaDePrioridade tree = new FilaDePrioridade();// mudar
														// para
														// fila
														// de
														// vagnoso
		for (int i = 0; i < charFreq.length; i++) {
			if (charFreq[i] > 0)
				tree.inserirOrdenado((char) i, charFreq[i]);
		}
		// percorre fila, cria arvore de cima pra baixo(logica de huffman)
		while (tree.obterTamanho() > 1) {
			HuffmanTree a = (HuffmanTree) tree.removerInicio();
			HuffmanTree b = (HuffmanTree) tree.removerInicio();

			// cria no da arvore
			int c = (a.frequency + b.frequency);
			// tree.offer(new HuffmanNode(a, b));
			tree.inserirInicio(null, c);
		}
		// return primeiro no da arvore
		return (HuffmanTree) tree.removerInicio();
	}

	public String encode(HuffmanTree tree, String str) {
		assert tree != null;
		String textCode = null;
		for (char c : textCode.toCharArray()) {
			textCode += (getCode(tree, new StringBuffer(), c));
		}
		return textCode;

	}

	public String decode(HuffmanTree tree, String str) {
		assert tree != null;
		String decodeText = "";
		HuffmanNode node = (HuffmanNode) tree;
		for (char code : str.toCharArray()) {
			if (code == 0) {// lado esquerdo
				if (node.left instanceof HuffmanLeaf) {
					decodeText += ((HuffmanLeaf) node.left).caract;
					node = (HuffmanNode) tree;
				} else {// continua esquerdo
					node = (HuffmanNode) node.left;
				}
			} else if (code == 1) {// lado direitro
				if (node.right instanceof HuffmanLeaf) {
					decodeText += ((HuffmanLeaf) node.right).caract;
					node = (HuffmanNode) tree;
				} else {// continua esquerdo
					node = (HuffmanNode) node.right;
				}
			}
		}
		return decodeText;
	}

	public static String getCode(HuffmanTree tree, StringBuffer prefix, char c) {
		assert tree != null;

		if (tree instanceof HuffmanLeaf) {
			HuffmanLeaf leaf = (HuffmanLeaf) tree;
			if (leaf.caract == c) {
				return prefix.toString();
			}
		} else if (tree instanceof HuffmanNode) {
			HuffmanNode node = (HuffmanNode) tree;
			// percorre esquerda
			prefix.append('0');
			String left = getCode(node.left, prefix, c);
			prefix.deleteCharAt(prefix.length() - 1);
			// percorre direitaleft
			prefix.append('1');
			String right = getCode(node.left, prefix, c);
			prefix.deleteCharAt(prefix.length() - 1);

			if (left == null)
				return right;
			else
				return left;
		}
		return null;

	}

}
