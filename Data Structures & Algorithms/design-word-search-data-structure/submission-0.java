class WordDictionary {

    private class Node {
        Node arr[] = new Node[26];
        boolean flag = false;

        public boolean isEOW(){
            return flag;
        }

        public void setEOW(boolean val){
            flag = val;
        }
    }

    final private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            int idx = ch - 'a';

            if(curr.arr[idx] == null){
                curr.arr[idx] = new Node();
            }

            curr = curr.arr[idx];
        }

        curr.setEOW(true);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, Node curr){
        if(curr == null){
            return false;
        }

        if(i == word.length()){
            return curr.isEOW();
        }

        char ch = word.charAt(i);

        if(ch != '.'){
            int idx = ch - 'a';
            return dfs(word, i + 1, curr.arr[idx]);
        }

        for (int j = 0; j < 26; j++) {
            if (curr.arr[j] != null) {
                if (dfs(word, i + 1, curr.arr[j])) {
                    return true;
                }
            }
        }

        return false;
    }
}
