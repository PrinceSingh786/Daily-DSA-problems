class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] b) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (b[i][j] == '.') {

                    for (char num = '1'; num <= '9'; num++) {

                        if (isValid(b, i, j, num)) {
                            b[i][j] = num;

                            if (solve(b)) return true;

                            b[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValid(char[][] b, int r, int c, char num) {

        for (int i = 0; i < 9; i++) {
            if (b[r][i] == num || b[i][c] == num)
                return false;

            int row = 3 * (r / 3) + i / 3;
            int col = 3 * (c / 3) + i % 3;

            if (b[row][col] == num)
                return false;
        }
        return true;
    }
}