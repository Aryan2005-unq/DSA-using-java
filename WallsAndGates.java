import java.util.*;

public class Main {

    private static final int INF = 2147483647;
    private static final int[] direction = {0, 1, 0, -1, 0};
    public static void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<int[]> values = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    values.offer(new int[]{i, j});
                }
            }
        }

        while (!values.isEmpty()) {
            int[] gates = values.poll();
            int row = gates[0];
            int col = gates[1];

            for (int i = 0; i < 4; i++) {
                int newrow = row + direction[i];
                int newcol = col + direction[i + 1];

                if (newrow >= 0 && newcol >= 0 && newrow < m && newcol < n && rooms[newrow][newcol] == INF) {
                    rooms[newrow][newcol] = rooms[row][col] + 1;
                    values.offer(new int[]{newrow, newcol});
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] rooms = {
            {INF, -1,  0, INF},
            {INF, INF, INF, -1},
            {INF, -1, INF, -1},
            {0,   -1, INF, INF}
        };

        wallsAndGates(rooms);

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }
}
