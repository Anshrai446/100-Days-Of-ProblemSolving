class Solution {

    Set<String> ans = new HashSet<>();

    public void dfs(String s, int index,
                    int leftCount, int rightCount,
                    int leftRemove, int rightRemove,
                    StringBuilder current) {
        if (rightCount > leftCount) {
            return;
        }
        if (index == s.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                leftCount == rightCount) {

                ans.add(current.toString());
            }

            return;
        }

        char ch = s.charAt(index);
        if (ch == '(') {
            if (leftRemove > 0) {
                dfs(s, index + 1,
                    leftCount, rightCount,
                    leftRemove - 1, rightRemove,
                    current);
            }
            current.append(ch);

            dfs(s, index + 1,
                leftCount + 1, rightCount,
                leftRemove, rightRemove,
                current);

            current.deleteCharAt(current.length() - 1);

        } else if (ch == ')') {

            // Option 1: remove ')'
            if (rightRemove > 0) {
                dfs(s, index + 1,
                    leftCount, rightCount,
                    leftRemove, rightRemove - 1,
                    current);
            }

            // Option 2: keep ')'
            if (leftCount > rightCount) {

                current.append(ch);

                dfs(s, index + 1,
                    leftCount, rightCount + 1,
                    leftRemove, rightRemove,
                    current);

                current.deleteCharAt(current.length() - 1);
            }

        } else {

            // Letter: always keep
            current.append(ch);

            dfs(s, index + 1,
                leftCount, rightCount,
                leftRemove, rightRemove,
                current);

            current.deleteCharAt(current.length() - 1);
        }
    }

    public List<String> removeInvalidParentheses(String s) {

        int leftRemove = 0;
        int rightRemove = 0;
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                leftRemove++;
            }

            else if (ch == ')') {

                if (leftRemove > 0) {
                    leftRemove--;
                } else {
                    rightRemove++;
                }
            }
        }
        dfs(s, 0, 0, 0,leftRemove, rightRemove, new StringBuilder());

        return new ArrayList<>(ans);
    }
}