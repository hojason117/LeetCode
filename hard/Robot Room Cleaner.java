/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    private class Offset {
        int offsets[];
        
        Offset(int horizontalOffset, int verticalOffset) {
            offsets = new int[]{horizontalOffset, verticalOffset};
        }
        
        @Override
        public boolean equals(Object target) {
            if (target instanceof Offset)
                return Arrays.equals(offsets, ((Offset)target).offsets);
            else
                return false;
        }
        
        @Override
        public int hashCode() {
            return offsets[0] + offsets[1];
        }
    }
    
    HashSet<Offset> visited = new HashSet<Offset>();
    
    public void cleanRoom(Robot robot) {
        startClean(robot);
    }
    
    private void startClean(Robot robot) {
        visitCurrent(robot, 0, 0);
        
        for(int i = 0; i < 4; i++) {
            int nextHorizontalOffset = (i % 2) * (1 - i / 2 * 2);
            int nextVerticalOffset = ((i + 1) % 2) * (1 - (i + 1) / 2 * 2);
            if(!visited.contains(new Offset(nextHorizontalOffset, nextVerticalOffset)) && robot.move()) {
                checkAllDirections(robot, nextHorizontalOffset, nextVerticalOffset, i);
                robot.move();
                robot.turnLeft();
            }
            else
                robot.turnRight();
        }
    }
    
    private void checkAllDirections(Robot robot, int horizontalOffset, int verticalOffset, int direction) {
        visitCurrent(robot, horizontalOffset, verticalOffset);
        
        robot.turnLeft();
        for(int i = -1; i <= 1; i++) {
            int nextHorizontalOffset = 0;
            int nextVerticalOffset = 0;
            switch(direction) {
            case 0:
                // -1 0 1
                nextHorizontalOffset = horizontalOffset + i;
                // 0 1 0
                nextVerticalOffset = verticalOffset + ((i + 1) % 2);
                break;
            case 1:
                // 0 1 0
                nextHorizontalOffset = horizontalOffset + ((i + 1) % 2);
                // 1 0 -1
                nextVerticalOffset = verticalOffset - i;
                break;
            case 2:
                // 1 0 -1
                nextHorizontalOffset = horizontalOffset - i;
                // 0 -1 0
                nextVerticalOffset = verticalOffset + ((i - 1) % 2);
                break;
            case 3:
                // 0 -1 0
                nextHorizontalOffset = horizontalOffset + ((i - 1) % 2);
                // -1 0 1
                nextVerticalOffset = verticalOffset + i;
                break;
            }
            int nextDirection = (direction + i + 4) % 4;
            
            if(!visited.contains(new Offset(nextHorizontalOffset, nextVerticalOffset)) && robot.move()) {
                checkAllDirections(robot, nextHorizontalOffset, nextVerticalOffset, nextDirection);
                robot.move();
                robot.turnLeft();
            }
            else
                robot.turnRight();
        }
    }
    
    private void visitCurrent(Robot robot, int horizontalOffset, int verticalOffset) {
        robot.clean();
        visited.add(new Offset(horizontalOffset, verticalOffset));
    }
}