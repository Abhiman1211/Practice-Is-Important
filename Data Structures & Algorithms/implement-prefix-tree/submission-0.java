class PrefixTree {

    private class Node {
        Node arr[] = new Node[26];
        Boolean flag = false;

        public boolean isEOW() {
            return flag;
        }

        public void setEOW(boolean eowValue){
            flag = eowValue;
        }
    }
    
    private final Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
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
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            int idx = ch - 'a';

            if(curr.arr[idx] == null){
                return false;
            }

            curr = curr.arr[idx];
        }

        return curr != null && curr.isEOW();
    }

    public boolean startsWith(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            int idx = ch - 'a';

            if(curr.arr[idx] == null){
                return false;
            }

            curr = curr.arr[idx];
        }

        return curr != null;
    }
}
