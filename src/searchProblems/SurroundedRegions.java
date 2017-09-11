package searchProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O''s into 'X''s in that surrounded region.
 * 
 * Example
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After capture all regions surrounded by 'X', the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */

public class SurroundedRegions {
    int n, m;

    public void surroundedRegions(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;

        for (int i = 0; i < n; i++) {
            bfs(board, i, 0);
            bfs(board, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            bfs(board, 0, j);
            bfs(board, n - 1, j);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'W') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfs(char[][] board, int sx, int sy) {
        if (board[sx][sy] != 'O') {
            return;
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(sx);
        qy.offer(sy);
        board[sx][sy] = 'W';
        while (!qx.isEmpty()) {
            int cx = qx.poll();
            int cy = qy.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m
                        && board[nx][ny] == 'O') {
                    board[nx][ny] = 'W';
                    qx.offer(nx);
                    qy.offer(ny);
                }
            }
        }
    }
}
