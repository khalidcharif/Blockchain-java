package com.blockchain;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
	private List<Block> blockchain = new ArrayList<>();

	public List<Block> getBlockchain() {
		return blockchain;
	}
	
	public int getSizeBlockchain() {
		return blockchain.size();
	}
	
	private Block getLatestBlock() {
		if(blockchain.isEmpty()) {
			createGenesisBlock();
		}
		return blockchain.get(blockchain.size() - 1);
	}
	
	private void createGenesisBlock() {
			blockchain.add(new Block(0, "0", "0"));
	}
	
	public void addBlock(String data) {
		Block previousBlock = getLatestBlock();
		Block newBlock = new Block(previousBlock.getIndex()+1,
						data, previousBlock.getHash());
		blockchain.add(newBlock);
	}
	
	public boolean isChainValid() {
		for(int i=1; i<blockchain.size(); i++) {
			Block currentBlock = blockchain.get(i);
			Block previousBlock = blockchain.get(i-1);
			if(currentBlock.getHash().equals(previousBlock.calculateTheHash()))
				return false;
			if(currentBlock.getPreviousHash().equals(previousBlock.getHash())) 
				return false;
			
		}
		return true;
	}

}
