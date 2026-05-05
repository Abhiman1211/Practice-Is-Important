class Trie {
    Trie arr[] = new Trie[26];
    // Here for this there is no use to make Trie with a boolean flag
    String word = null;
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = buildTrie(words);
        Set<String> res = new HashSet<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                dfs(board, trie, res, i, j);
            }
        }

        return new ArrayList<>(res);
    }

    public Trie buildTrie(String[] words){
        Trie root = new Trie();

        for (String w : words){
            Trie p = root;
            for(char c : w.toCharArray()){
                int idx = c - 'a';
                if(p.arr[idx] == null){
                    p.arr[idx] = new Trie();
                }
                p = p.arr[idx];
            }
            // This add the entire word we made in the Node.word
            // To avoid the rebuild process
            p.word = w;
        }

        return root;
    }

    public void dfs(char[][] board, Trie node, Set<String> res, int i, int j){
        if(i<0 || j<0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || node.arr[board[i][j] - 'a'] == null){
            return;
        }

        // We check here did we reach the end of the word we have travered and now is it forming a 
        // valid word
        // If yes then we add that in the resulted set.
        // The reason to use Set here is avoid any duplication
        if(node.arr[board[i][j] - 'a'].word != null){
            res.add(node.arr[board[i][j] - 'a'].word);
        }

        // New next node track
        node = node.arr[board[i][j] - 'a'];

        // This is used to make sure after backtrack we put the original char at its place
        char c = board[i][j];

        // This indicates the visited block of the matrix
        board[i][j] = '#';

        
        dfs(board, node, res, i+1, j);
        dfs(board, node, res, i-1, j);
        dfs(board, node, res, i, j+1);
        dfs(board, node, res, i, j-1);

        // Puting the origial char at its place
        board[i][j] = c;
    }
}
