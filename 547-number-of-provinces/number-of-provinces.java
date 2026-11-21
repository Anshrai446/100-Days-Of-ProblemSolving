import java.util.*;
 
class Solution {
    private void dfs(int city, int[][] isConnected, int[] visited) {
        // Mark the current city as visited.
        visited[city] = 1;
 
        int n = isConnected.length;
 
        // Check every city connected to the current city.
        for (int nextCity = 0; nextCity < n; nextCity++) {
            // If there is a connection and the city is not visited, visit it.
            if (isConnected[city][nextCity] == 1 && visited[nextCity] == 0) {
                dfs(nextCity, isConnected, visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int provinces = 0;
        for (int city = 0; city < n; city++) {
            if (visited[city] == 0) {
                provinces++;
 
                // Visit all cities in this province.
                dfs(city, isConnected, visited);
            }
        }
 
        // Return the total province count.
        return provinces;
    }
}