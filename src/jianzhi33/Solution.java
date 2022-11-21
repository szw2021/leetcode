package jianzhi33;

class Solution {
    public boolean verifyPostorder(int[] postorder) {

        return dfs(postorder, 0, postorder.length - 1);
    }

    private boolean dfs(int[] postorder, int l, int r) {
        if (l >= r) {
            return true;
        }

        int mid = l;
        int root = postorder[r];
        //todo <=
        while (postorder[mid] < root) {
            mid++;
        }

        int temp = mid;
        while (temp < r) {
            if (postorder[temp++] < root) {
                return false;
            }
        }
        //todo
        //return dfs(postorder, l, mid - 1) && dfs(postorder, mid + 1, r - 1);
        return dfs(postorder, l, mid - 1) && dfs(postorder, mid, r - 1);

    }
}