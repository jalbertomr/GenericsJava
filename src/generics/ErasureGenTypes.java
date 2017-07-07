package generics;

/**
 * Created by Bext on 23/01/2017.
 */
public class ErasureGenTypes {

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() { return data; }
        public Node<T> getNext() { return next; }
        //...
    }

    //Because the type parameter T is unbounded, the Java compiler replaces it with Object
    class Node_replaced<Object> {
        private Object data;
        private Node_replaced<Object> next;

        public Node_replaced(Object data, Node_replaced<Object> next) {
            this.data = data;
            this.next = next;
        }

        public Object getData() { return data; }
        public Node_replaced<Object> getNext() { return next; }
        //...
    }

    //In the following example, the generic Node class uses a bounded type parameter
    class NodeBounded<T extends Comparable<T>> {
        private T data;
        private NodeBounded<T> next;

        public NodeBounded(T data, NodeBounded<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() { return data; }
        public NodeBounded<T> getNext() { return next; }
    }

    //The Java compiler replaces the bounded type parameter T with the first bound class, Comparable
    class NodeBounded_replaced {
        private Comparable data;
        private NodeBounded_replaced next;

        public NodeBounded_replaced(Comparable data, NodeBounded_replaced next) {
            this.data = data;
            this.next = next;
        }

        public Comparable getData() { return data; }
        public NodeBounded_replaced getNext() { return next; }
    }
}
