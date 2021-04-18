package com.blockchain;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Blockchain {
	private List<Block> blockchain = new ArrayList<>();

	public List<Block> getBlockchain() {
		return blockchain;
	}
	
	private Block getLatestBlock() {
		if(blockchain.isEmpty()) {
			createGenesisBlock();
		}
		return blockchain.get(blockchain.size() - 1);
	}
	
	private void createGenesisBlock() {
			blockchain.add(new Block(0, "0", "first block"));
	}
	
	public void addBlock(String data) {
		Block previousBlock = getLatestBlock();
		Block newBlock = new Block(previousBlock.getIndex()+1,
						data, previousBlock.getHash());
		blockchain.add(newBlock);
	}
	
	public boolean isChainValid() {
		
	}

}
