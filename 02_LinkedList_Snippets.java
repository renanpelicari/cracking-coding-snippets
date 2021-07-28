import java.util.*;

public class 02_LikedList_Snippets {

    /**
     * =============================================================================
     * 2.0.1.
     * How to create: Singly Linked List (manually without using LinkedList from java.utils)
     * =============================================================================
     */
     class Node {
         Node next = null;
         int data;

         public Node(int data) {
             this.data = data; 
         }

         void appendToEnd(int data) {
             Node newData = new Node(data);
             Node currentData = this;

             while (currentData.next != null) {
                 currentData = currentData.next;
             }

             currentData.next = newData;
         }
     }



    /**
     * =============================================================================
     * 2.1.1.
     * Remove duplicated from unsorted linked list (with temporary buffer allowed)
     * =============================================================================
     */
    public static void removeDuplicatesA(LinkedList<Integer> linkedList) {

        final Set<Integer> tempMap = new HashSet<>();
        Iterator<Integer> it = linkedList.iterator();

        while (it.hasNext()) {
            Integer num = (Integer) it.next();

            if (tempMap.contains(num)) {
                it.remove();
            } else {
                tempMap.add(num);
            }
        }
    }



    /**
     * =============================================================================
     * 2.1.2.
     * Remove duplicated from unsorted linked list (with temporary buffer not allowed)
     * =============================================================================
     */
    public static void removeDuplicatesB(LinkedList<Integer> linkedList) {

        Iterator<Integer> it = linkedList.iterator();
        int index = 0;

        while (it.hasNext()) {
            Integer num = it.next();

            if (it.hasNext()) {
                for (int i = 0; i < index; i++) {
                    Integer compareNum = linkedList.get(i);

                    if (num.equals(compareNum)) {
                        it.remove();
                        index--;
                    }
                }
                index++;
            }
        }
    }



    /**
     * =============================================================================
     * 2.2.
     * Find the nth to last element from a linked list
     * =============================================================================
     */
    public static LinkedList<Integer> findLinkedListNextNodes(final LinkedList<Integer> currentList, final int position) {
         
        final LinkedList<Integer> newLinkedList = new LinkedList<Integer>();
        final ListIterator<Integer> it = currentList.listIterator(position);

        while (it.hasNext()) {
            newLinkedList.add(it.next());
        }

        return newLinkedList;
    }



    /**
     * =============================================================================
     * 2.3.
     * Given an element, remove first occurrence from linkedList
     * =============================================================================
     */
    public static void removeFirstOccurrence(final LinkedList<Integer> linkedList, final Integer element) {
        linkedList.removeFirstOccurrence(element);
    }



    /**
     * =============================================================================
     * 2.4.
     * NOT IMPLEMENTED
     * =============================================================================
     */


    /**
     * =============================================================================
     * 2.5.
     * NOT IMPLEMENTED
     * =============================================================================
     */

}