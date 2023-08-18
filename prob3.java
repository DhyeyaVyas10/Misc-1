// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes


class Solution { // dfs
    private int sum;

    public int depthSum(List<NestedInteger> nestedList) {
        sum = 0;
        helper(1, nestedList);
        return sum;
    }

    public void helper(int lvl, List<NestedInteger> nestedList) {
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger n = nestedList.get(i);
            if (n.isInteger()) { // when is single number integer, add to sum
                sum += n.getInteger() * lvl;
            } else { // when nested list, dfs inside list until it's single number integer
                helper(lvl + 1, n.getList());
            }
        }
    }
}