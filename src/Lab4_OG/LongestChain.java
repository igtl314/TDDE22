package Lab4_OG;

import java.util.Stack;

/**
 * The LongestChain class contains the necessary data to perform
 * breadth first searches in accordance with the laboration, and
 * determine the longest chain.
 *
 * @author Magnus Nielsen, Tommy Färnqvist
 */
class LongestChain {
    private Queue q; // queue used in the BFS
    private String goalWord; // goal word of the BFS
    public WordRec biggestChain;
    private int wordLength;
    private final char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'å',
            'ä', 'ö', 'é'};
    private int alphabetLength = alphabet.length;

    public LongestChain(int wordLength) {
        this.wordLength = wordLength;
        q = new Queue();
    }

    /**
     * IsGoal checks if w is the goal word.
     *
     * @param w - the word to compare with the goal word (String)
     * @return - true if w is the goal word, false otherwise (boolean)
     */
    private boolean isGoal(String w) {
        return w.equals(goalWord);
    }

    /**
     * makeChildren creates all words that differ in one letter from
     * the given word x. If the word is encountered for the first time
     * it will be added to the queue "q" for later processing.
     *
     * @param x - the word of origin (WordRec)
     * @return the goal word if it's found, null otherwise (WordRec)
     */
    private WordRec makeChildren(WordRec x) {
        int len = 0;
        char[] temp = x.getWord().toCharArray();
        for (int i = 0; i < wordLength; i++) {
            char oldTemp = temp[i];
            for (int c = 0; c < alphabetLength; c++) {
                if (alphabet[c] != temp[i]) {
                    temp[i] = alphabet[c];
                    String newString = WordList.contains(new String(temp));
                    if (newString != null && WordList.markAsUsedIfUnused(newString)) {
                        WordRec wr = new WordRec(newString, x);
                        if ((goalWord.isEmpty())) {
                            biggestChain = wr;
                        }
                        if (isGoal(newString)) {
                            return wr;
                        }
                        q.enqueue(wr);
                    }
                }
                temp[i] = oldTemp;
            }
        }
        return null;
    }


    /**
     * BreadthFirst perform a BFS from startWord to find the shortest
     * path to endWord. The shortest path will be returned as a chain
     * of word posts (WordRec). If there is no path between the two
     * words, null will be returned.
     *
     * @param startWord - the word from which we wish to begin the
     *                  search (String)
     * @param endWord   - the goal word, the end of the search (String)
     * @return - a chain of word posts that can be traversed if the
     * goal word is found, null otherwise (WordRec)
     */
		public WordRec breadthFirst(String startWord, String endWord) {
        WordList.eraseUsed();
        WordRec start = new WordRec(startWord, null);
        WordList.markAsUsedIfUnused(startWord);
        goalWord = endWord;
        q.empty();
        q.enqueue(start);
        try {
            while (true) {
                WordRec wr = makeChildren((WordRec) q.dequeue());
                if (wr != null) {
                    return wr;
                }
            }
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * CheckAllStartWords finds the shortest path from any word to
     * endWord. The longest of these shortest paths will be printed.
     *
     * @param endWord - the goal word, where we wish for all the paths
     *                to end
     */
    public void checkAllStartWords(String endWord) {
        breadthFirst(endWord, "");
        if (biggestChain != null) {
			System.out.println(endWord + ": " + biggestChain.chainLength() + " ord");
            biggestChain.printChain();

		}
    }


}
