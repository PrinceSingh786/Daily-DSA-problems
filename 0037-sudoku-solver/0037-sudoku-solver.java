class Solution {
    int[] row = new int[9], col = new int[9], box = new int[9];

    public void solveSudoku(char[][] b) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (b[i][j] != '.') {
                    int x = 1 << (b[i][j] - '1');
                    row[i] |= x; col[j] |= x; box[i/3*3+j/3] |= x;
                }
        solve(b, 0);
    }

    boolean solve(char[][] b, int pos) {
        if (pos == 81) return true;

        int r = pos / 9, c = pos % 9;
        if (b[r][c] != '.') return solve(b, pos + 1);

        int k = r/3*3+c/3, mask = ~(row[r] | col[c] | box[k]);

        for (int x = mask & 511; x != 0; x &= x - 1) {
            int bit = x & -x;
            b[r][c] = (char) ('1' + Integer.numberOfTrailingZeros(bit));
            row[r] |= bit; col[c] |= bit; box[k] |= bit;

            if (solve(b, pos + 1)) return true;

            row[r] ^= bit; col[c] ^= bit; box[k] ^= bit;
            b[r][c] = '.';
        }
        return false;
    }
}