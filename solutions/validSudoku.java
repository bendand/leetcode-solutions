class Solution {
    public boolean isValidSudoku(char[][] board) {
        // column, row, square hashmaps contain sets
        // so checks for duplicates can be performed
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        // nested for loop iterates through 2D array
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // we skip periods so only digits 1-9 are accumulated
                if (board[r][c] == '.') continue;

                // specific 3x3 square is calculated using int division
                String squareKey = (r / 3) + "," + (c / 3);

                // if row, column, or square already contains digit
                // return false, our sudoku is invalid
                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                    squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])) {
                    return false;
                }

                // else, add digit to set in row, col, and square's hashmaps
                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
            }
        }
        return true;
    }
}