class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        int[][] d = new int[m][n];
        int x = 0, y = 0, cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    x = i;
                    y = j;
                } else if (c == 'L') {
                    d[i][j] = cnt++;
                }
            }
        }

        if (cnt == 0) return 0;

        boolean[][][][] vis = new boolean[m][n][energy + 1][1 << cnt];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y, energy, (1 << cnt) - 1});
        vis[x][y][energy][(1 << cnt) - 1] = true;

        int[] dirs = {-1, 0, 1, 0, -1};
        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();
                int i = cur[0], j = cur[1];
                int e = cur[2], mask = cur[3];

                if (mask == 0) return moves;
                if (e == 0) continue;

                for (int k = 0; k < 4; k++) {
                    int ni = i + dirs[k];
                    int nj = j + dirs[k + 1];

                    if (ni < 0 || ni >= m || nj < 0 || nj >= n) continue;
                    if (classroom[ni].charAt(nj) == 'X') continue;

                    int ne = e - 1;
                    if (classroom[ni].charAt(nj) == 'R') ne = energy;

                    int nmask = mask;

                    if (classroom[ni].charAt(nj) == 'L') {
                        nmask &= ~(1 << d[ni][nj]);
                    }

                    if (!vis[ni][nj][ne][nmask]) {
                        vis[ni][nj][ne][nmask] = true;
                        q.offer(new int[]{ni, nj, ne, nmask});
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}