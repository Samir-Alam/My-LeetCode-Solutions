/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    private static Node construct(final int[][] grid, final int row, final int col, final int borderLen){
        for (int i = row; i < row + borderLen; i += 1){
            for (int j = col; j < col + borderLen; j += 1){
                if (grid[i][j] != grid[row][col]){
                    return new Node(
                        false,
                        false,
                        construct(grid, row, col, borderLen / 2),
                        construct(grid, row, col + borderLen / 2, borderLen / 2),
                        construct(grid, row + borderLen / 2, col, borderLen / 2),
                        construct(grid, row + borderLen / 2, col + borderLen / 2, borderLen / 2)
                    );
                }
            }
        }
        return new Node(grid[row][col] != 0, true);
    }
}