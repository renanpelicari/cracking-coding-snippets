import java.util.*;

public class 02_LikedList_Snippets {

    /**
     * =============================================================================
     * 3.0.1.1.
     * How to implement a Custom Stack
     * =============================================================================
     */
    static class CustomStack {

        LinkedList<Integer> stack;

        public CustomStack(LinkedList<Integer> stack) {
            this.stack = stack;
        }

        // add on top
        void push(Integer element) {
            stack.addLast(element);
        }

        // get and remove from top
        Integer pop() {
            if (stack.size() > 0) {
                Integer last = stack.getLast();
                stack.removeLast();
                return last;
            }
            return null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();

            for (Integer integer : stack) {
                sb.append(integer).append(", ");
            }
            return sb.toString();
        }
    }

    /**
     * =============================================================================
     * 3.0.1.2.
     * How to use Stack from java.util.Stack
     * =============================================================================
     */
    public static void stackExample() {

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        stack.push(2);
        stack.push(7);
        stack.push(8);
        System.out.println(stack);
        Integer pop = stack.pop();
        System.out.println("removed: " + pop);
        System.out.println(stack);
    }


    /**
     * =============================================================================
     * 3.0.2.1.
     * How to implement a Custom Queue
     * =============================================================================
     */
    static class CustomQueue {
        LinkedList<Integer> queue;

        public CustomQueue(LinkedList<Integer> queue) {
            this.queue = queue;
        }

        // add on top
        void enqueue(Integer element) {
            queue.addLast(element);
        }

        // get and remove from begining
        Integer dequeue() {
            if (queue.size() > 0) {
                Integer first = queue.getFirst();
                queue.removeFirst();
                return first;
            }
            return null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();

            for (Integer integer : queue) {
                sb.append(integer).append(", ");
            }
            return sb.toString();
        }
    }


    /**
     * =============================================================================
     * 3.0.2.2.
     * How to use Queue from java.util.Queue
     * NOT IMPLEMENTED -> Equals to use LinkedList (add to queue and getFirst to dequeue)
     * =============================================================================
     */

    /**
     * =============================================================================
     * 3.1.
     * NOT IMPLEMENTED
     * =============================================================================
     */


    /**
     * =============================================================================
     * 3.2.
     * NOT IMPLEMENTED
     * =============================================================================
     */


    /**
     * =============================================================================
     * 3.3.
     * Create data structure for Set of Stacks, to represent a stacks with maximum size
     * =============================================================================
     */
    static class SetOfStacks {

        private static final Integer STACK_LIMIT = 5;
        LinkedList<Stack<Integer>> stacks = new LinkedList<Stack<Integer>>();

        // add to top
        void push(Integer num) {
            boolean found = false;

            for (Stack<Integer> stack : stacks) {
                if (stack.size() < STACK_LIMIT) {
                    stack.push(num);
                    found = true;
                    break;
                }
            }

            if (!found) {
                Stack<Integer> newStack = new Stack<Integer>();
                newStack.add(num);
                stacks.add(newStack);
            }
        }

        // remove from top
        Integer pop() {
            return stacks.getLast().pop();
       }

        // remove from top of specific stack
        Integer popAt(int index) {
            return stacks.get(index).pop();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");

            for (Stack<Integer> stack : stacks) {
                sb.append("[");
                for (Integer num : stack) {
                    sb.append(num).append(", ");
                }
                sb.append("], ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static void usingSetOfStacks() {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);
        setOfStacks.push(7);
        setOfStacks.push(8);
        setOfStacks.push(9);
        System.out.println(setOfStacks);
        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.popAt(0);
        setOfStacks.popAt(0);
        System.out.println(setOfStacks);
        setOfStacks.push(11);
        setOfStacks.push(12);
        setOfStacks.push(13);
        setOfStacks.push(14);
        setOfStacks.push(15);
        setOfStacks.push(16);
        System.out.println(setOfStacks);
    }


    /**
     * =============================================================================
     * 3.3.
     * Create hanoi tower algorithm
     * =============================================================================
     */
    public static void main(String[] args) {
        executeHanoiTower();
    }

    public static void executeHanoiTower() {
        Stack<Integer> towerA = new Stack<Integer>();
        Stack<Integer> towerB = new Stack<Integer>();
        Stack<Integer> towerC = new Stack<Integer>();

        towerA.add(5);
        towerA.add(4);
        towerA.add(3);
        towerA.add(2);
        towerA.add(1);

        moveDisc(towerA, towerB, towerC, null);
    }

    // TODO: refactor this method
    private static void moveDisc(Stack<Integer> towerA, Stack<Integer> towerB, Stack<Integer> towerC, Integer lastElement) {
        showTowers(towerA, towerB, towerC);

        if (towerB.size() == 5 || towerC.size() == 5) {
            return;
        }

        Integer newElement = moveFromSourceToTargetAndGetLastElement(towerA, towerB, lastElement);
        showTowers(towerA, towerB, towerC);

        newElement = moveFromSourceToTargetAndGetLastElement(towerA, towerC, newElement);
        showTowers(towerA, towerB, towerC);

        newElement = moveFromSourceToTargetAndGetLastElement(towerB, towerC, newElement);
        showTowers(towerA, towerB, towerC);

        newElement = moveFromSourceToTargetAndGetLastElement(towerB, towerA, newElement);
        showTowers(towerA, towerB, towerC);

        newElement = moveFromSourceToTargetAndGetLastElement(towerC, towerA, newElement);
        showTowers(towerA, towerB, towerC);

        newElement = moveFromSourceToTargetAndGetLastElement(towerC, towerB, newElement);
        showTowers(towerA, towerB, towerC);

        moveDisc(towerA, towerB, towerC, newElement);
    }

    private static Integer moveFromSourceToTargetAndGetLastElement(Stack<Integer> source, Stack<Integer> target,
                                                                   Integer lastMovedElement) {
        if (source.isEmpty()) {
            return lastMovedElement;
        }

        Integer newElement = source.lastElement();
        if (canMoveDisc(source, lastMovedElement) && canAcceptDisc(target, newElement)) {
            source.pop();
            target.push(newElement);
            return newElement;
        }
        return lastMovedElement;
    }

    private static boolean canMoveDisc(Stack<Integer> tower, Integer lastMovedElement) {
        return tower.size() > 0 && !tower.lastElement().equals(lastMovedElement);
    }

    private static boolean canAcceptDisc(Stack<Integer> tower, Integer newElement) {
        return tower.isEmpty() || tower.lastElement() > newElement;
    }

    private static void showTowers(Stack<Integer> towerA, Stack<Integer> towerB, Stack<Integer> towerC) {
        System.out.println("-------------------------");
        showTower("A", towerA);
        showTower("B", towerB);
        showTower("C", towerC);
    }

    private static void showTower(String towerName, Stack<Integer> elements) {
        System.out.println("Tower " + towerName + ":");
        System.out.println(elements);
        System.out.println("");
    }


}