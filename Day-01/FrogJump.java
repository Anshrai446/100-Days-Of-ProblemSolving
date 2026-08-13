class FrogJump {

    static int solve(int[] height, int currIndx) {

        if (currIndx == height.length - 1) {
            return 0;
        }

        int way1 = Math.abs(height[currIndx] - height[currIndx + 1])
                + solve(height, currIndx + 1);

        int way2 = Integer.MAX_VALUE;

        if (currIndx + 2 < height.length) {
            way2 = Math.abs(height[currIndx] - height[currIndx + 2])
                    + solve(height, currIndx + 2);
        }

        return Math.min(way1, way2);
    }

    static int minCost(int[] height) {
        return solve(height, 0);
    }

    public static void main(String[] args) {
        int[] height = {10, 30, 40, 20};

        System.out.println(minCost(height));
    }
}