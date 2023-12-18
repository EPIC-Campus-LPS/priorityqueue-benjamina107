import java.util.ArrayList;

/**
 * This class represents a Priority Queue (heap) based on the ordering
 * defined by the compareTo method for the element. "Lower" value will
 * mean "higher" priority.
 *
 * @param <E> the type of elements in the queue
 * @author
 */
public class PriorityQueue<E extends Comparable<E>> {

    private ArrayList<E> myHeap; //array representation of the heap

    /**
     * Creates an empty Priority Queue
     */
    public PriorityQueue() {
        myHeap = new ArrayList<E>();
    }

    /**
     * Adds the element to the priority queue
     *
     * @param element the element to be added
     */
    public void add(E element) {
        myHeap.add(element);

        int c = myHeap.size();

        while (c > 1 && myHeap.get(c) < myHeap.get(getParent(c))) {
            swap(c, getParent(c));
            c = getParent(c);
        }

    }

    /**
     * Returns the parent index of the current item.
     *
     * @param current the item to find the parent of.
     */
    public int getParent(int current) {
        return (int) Math.floor(current / 2);
    }

    /**
     * Returns the left child index of the current item.
     *
     * @param current the item to find the left child of.
     */
    public int getLeft(int current) {
        return current * 2;
    }


    /**
     * Returns the right child index of the current item.
     *
     * @param current the item to find the left child of.
     */
    public int getRight(int current) {
        return (current * 2) + 1;
    }


    /**
     * Swaps two elements in the queue.
     * Pre-condition: 0 <= posOne, posTwo < size of queue
     *
     * @param posOne the first element's position in the queue
     * @param posTwo the second element's position in the queue
     */
    private void swap(int posOne, int posTwo) {

        E tmp = myHeap.get(posOne);
        myHeap.set(posOne, myHeap.get(posTwo));
        myHeap.set(posTwo, tmp);

    }

    /**
     * Returns whether or not the element is in the heap
     *
     * @param element the element to be searched for
     * @return true if the element is in the queue, false otherwise
     */
    public boolean contains(E element) {
        return myHeap.contains(element);
    }

    /**
     * Returns the element of highest priority, null if queue is empty.
     * Post-condition: the queue is not changed
     *
     * @return the element of highest priority queue
     */
    public E peek() {
        if (myHeap.size() == 0) {return null;}

        return myHeap.get(0);
    }

    /**
     * Removes and returns the element of highest priority,
     * returns null if queue is empty.
     *
     * @return the element of highest priority
     */
    public E poll() {

        if (myHeap.size() == 0) {return null;}


        swap(1, myHeap.size());
        E min = myHeap.remove(myHeap.size());
        heapify(0);
        return min;
    }

    /**
     * Will "sift down" the element at the given position
     * down to restore the heap property
     *
     * @param pos the starting position for heapify
     */
    private void heapify(int pos) {

        if (getRight(pos) > myHeap.size()) {heapify(getRight(pos));}
        if (getLeft(pos) > myHeap.size()) {heapify(getLeft(pos));}

        if (myHeap.get(getParent(pos)) > myHeap.get(pos)) {
            swap(pos, getParent(pos));
        }

    }

    /**
     * Finds and removes the given element from the queue.
     * Returns true if an element was deleted from the queue,
     * false otherwise.
     *
     * @param element the element to be removed from the queue
     * @return true if an element was removed from the queue, false otherwise
     */
    public boolean remove(E element) {
        if (!(myHeap.contains(element))) {return false;}

        return myHeap.remove(element);
    }

    /**
     * Returns the number of elements in the queue
     *
     * @return the number of elements in the queue
     */
    public int size() {
        return myHeap.size();
    }

    /**
     * Returns the String representation of the heap
     * (by the order of list, each element separated
     * with a single space)
     *
     * @return the String representation of the heap
     */
    public String toString() {
        if (myHeap.size() == 0) return "";

        String rt = myHeap.get(0).toString();

        for(E x : myHeap) {

            rt += x.toString() + " ";

        }
        return rt;
    }


    /**
     * Main method - contains console program used
     * for testing of the PriorityQueue class.
     *
     * @param args
     */
    public static void main(String[] args) {    }

}