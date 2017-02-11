public class Trie {

	public static void main(String[] args) {
		
		CharTrie test = new CharTrie();
		
		test.addLetter('d');
		
		System.out.println(test.findLetter('s')); // Will be false
		System.out.println(test.findLetter('d')); // Will be true
		
		test.addWord("abcdefghijklmnopqrstuvwxyz");
		
		System.out.println(test.findLetter('a')); // Will be true
		System.out.println(test.findWord("abcdefghijklmnopqrstuvwxyz")); // Will be true
		
	}
	
}

class CharTrie {
	
	TrieNode[] rootTrieNode = new TrieNode[26];
	
	// (int)letter - 97 gives the index of the letter
	public boolean findLetter(char letter) {
		
		return (rootTrieNode[helper.getIndex(letter)] != null);
		
	}
	
	public void addLetter(char letter) {
		
		if(findLetter(letter)) {
			return;
		}
		
		rootTrieNode[helper.getIndex(letter)] = new TrieNode();
	
	}
	
	public void addWord(String word) {
		
		int index = helper.getIndex(word.charAt(0));
		int charIndex = 0;
		
		// Creates a trie at the first index of the first letter if needed
		if(!findLetter(word.charAt(0))) {
			rootTrieNode[index] = new TrieNode();
			charIndex++;
		}
		
		// Pass the word - the first letter, to the trie method addLetters()
		rootTrieNode[index].addLetters(word.substring(charIndex,word.length()));

	}
	
	public boolean findWord(String word) {
				
		// Looks in the rootTrie for the first letter of the word
		if(!findLetter(word.charAt(0))) {
			return false;
		}
		
		// If there was only one letter in the word, we are done
		if(word.length() == 1) {
			return true;
		}
		
		int currentIndex = 1;
		int maxIndex = word.length();
		int currentTrieIndex = helper.getIndex(word.charAt(0));
		
		TrieNode[] parentTrie = null;
		TrieNode[] currentTrie = rootTrieNode[currentTrieIndex].trieNode;
		
		while(currentIndex != maxIndex) {
			
			currentTrieIndex = helper.getIndex(word.charAt(currentIndex));
			
			if(currentTrie[currentTrieIndex] == null) { // Look for the current letter of the word
				return false; // We could not find the current letter of that word
			}
			
			parentTrie = currentTrie;
			currentTrie = currentTrie[currentTrieIndex].trieNode;
			
			currentIndex++;
			
		}
		
		return true;
		
	}
	
}

class TrieNode {
	
	TrieNode[] trieNode;
	
	TrieNode() {
		trieNode = new TrieNode[26];
	}
	
	TrieNode(char newLetter) {
		trieNode = new TrieNode[26];
		addLetter(newLetter);
	}
	
	public void addLetter(char letter) {
		
		trieNode[helper.getIndex(letter)] = new TrieNode();
	
	}
		
	public void addLetters(String word) {
		
		int currentIndex = 0;
		int maxIndex = word.length();
		int currentTrieIndex;
		
		TrieNode[] parentTrie = null;
		TrieNode[] currentTrie = trieNode;
		
		while(currentIndex != maxIndex) {
			
			currentTrieIndex = helper.getIndex(word.charAt(currentIndex));
			
			if(currentTrie[currentTrieIndex] == null) { // If letter is not present add a trie to represent the letter
				currentTrie[currentTrieIndex] = new TrieNode(word.charAt(currentIndex));
			}
			
			parentTrie = currentTrie;
			currentTrie = currentTrie[currentTrieIndex].trieNode;
			
			currentIndex++;
			
		}
		
	}
	
}

class helper {
	
	public static int getIndex(char letter) {
		return (int)letter - 97;
	}
	
}

