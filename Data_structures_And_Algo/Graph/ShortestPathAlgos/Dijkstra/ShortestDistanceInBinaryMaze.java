package ShortestPathAlgos.Dijkstra;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Node {
    int d, r, c;

    Node(int d, int r, int c) {
        this.d = d;
        this.r = r;
        this.c = c;
    }
}

public class ShortestDistanceInBinaryMaze {

    public static int shortestPath(int[][] grid, int[] source, int[] d) {
        int[][] dist = new int[grid.length][grid[0].length];
        for (int a[] : dist)
            Arrays.fill(a, Integer.MAX_VALUE);
        dist[source[0]][source[1]] = 0;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, source[0], source[1]));

        int dx[] = { 1, 0, -1, 0 };
        int dy[] = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.r == d[0] && cur.c == d[1])
                return cur.d;

            int r = cur.r, c = cur.c;
            for (int i = 0; i < 4; i++) {
                int ar = r + dx[i];
                int ac = c + dy[i];

                if (ar < 0 || ar == grid.length || ac < 0 || ac == grid[0].length ||
                        grid[ar][ac] == 0 || dist[ar][ac] != Integer.MAX_VALUE)
                    continue;
                dist[ar][ac] = cur.d + 1;
                q.offer(new Node(cur.d + 1, ar, ac));
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int grid[][] = { { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0 },
                { 1, 0, 1, 0, 1 } };
        int[] src = {0,0}, dest = {3,4};
        System.out.println(shortestPath(grid, src, dest));
    }

}
