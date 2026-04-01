class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxs = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxs[i] = new HashSet<>();
        }

        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){

                char value = board[r][c];
                if(value == '.'){
                    continue;
                }

                int boxIdx = r/3 * 3 + c/3;

                if(rows[r].contains(value) || cols[c].contains(value) || boxs[boxIdx].contains(value)){
                    return false;
                }

                rows[r].add(value);
                cols[c].add(value);
                boxs[boxIdx].add(value);
            }
        }

        return true;
    }
}
