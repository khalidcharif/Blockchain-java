package com.blockchain;

public class Classtest {

	public static void main(String[] args) {
		Blockchain blockchain = new Blockchain();
		blockchain.addBlock("200");
		blockchain.addBlock("300");
		blockchain.addBlock("400");
		blockchain.addBlock("500");
		for(int i=0; i<blockchain.getSizeBlockchain(); i++) {
			System.out.println(blockchain.getBlockchain().get(i).toString());
		}
		blockchain.getBlockchain().get(2).setData("5000");
		System.out.println(blockchain.isChainValid());
	}

}
