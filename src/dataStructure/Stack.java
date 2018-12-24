package dataStructure;

import java.util.Iterator;

/**
 * a simple implements of Stack
 * @author zhengguochun
 */
public class Stack<T> implements Iterable<T>{
    //the top value of the stack
    private Node top = null;
    private int length = 0;

    /**
     * the node of stack
     * every node has two field ,value and next node
     */
    private class Node{
         T elem;
         Node next = null;
    }

    public void push(T elem){
        Node oldTop = top;
        top = new Node();
        top.elem = elem;
        top.next = oldTop;
        length++;
    }

    public T pop(){
        T elem = top.elem;
        top = top.next;
        length--;
        return elem;
    }
    public int size(){
        return length;
    }
    public boolean isEmpty(){
        return length == 0;
        //|| top == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }
    private class StackIterator implements Iterator<T>{
        private Node current = top;
        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            T elem = current.elem;
            current = current.next;
            return elem;
        }

        @Override
        public void remove() {

        }
    }
}
