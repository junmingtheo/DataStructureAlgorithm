package ArraySet;
import java.util.Iterator;
public class ArraySet <T extends Comparable<T>> implements Iterable<T> {
    private Object[] item;
    private int size ;
    public ArraySet () {
        size = 0;
        item =new Object[10];;
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }
    private class ArraySetIterator implements Iterator<T>{
        int pos ;
        private ArraySetIterator() {
            pos = 0;
        }

        public boolean hasNext() {
            return pos< size;
        }

        public T next() {
            if (hasNext()) {
                T x = (T) item[pos];
                pos ++;
                return x;
            }
            return null;
        }
    }
    public boolean contain(T x) {

        return this.BSHelper(x)!= -1;
    }

    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("Cannot input null");
        }
        else {
            if (size == item.length-2) {
                Object[] K = new Object[item.length/4+item.length];
                System.arraycopy(item,0,K,0,size);
                item= K;
            }
            if (contain(x)) {
                System.out.println("item exist in set");
            } else {
                 item[size] = x;
                 size++;
            }
        }
    }


    private int binarySearch(T x,int left , int right, int mid) {
        if (left > right) {
            return -1;
        }
        else if ( item[mid] == null) {
            mid = mid + 1;
            return binarySearch(x,left,right,mid);
        }

        else if (x.compareTo((T) item[mid]) > 0) {
            left = mid+1;
            mid = (left + right)/2;
            return binarySearch(x,left,right,mid);
        } else if (x.compareTo((T) item[mid]) < 0) {
            right = mid-1;
            mid = (left + right)/2;
            return binarySearch(x,left,right,mid);
        }

        return mid;

    }
    public int size() {
        return size;
    }

    public void display() {
        displayhelper();
    }
    private void displayhelper() {
        for (Object i : this) {
            System.out.println(i);
        }
    }
    public int find(T x) {
        int y = BSHelper(x);
        if (y == -1 ) {
            System.out.print("variable not inset");
            return -1;
        }
        else {
            return y;
        }
    }

    private int BSHelper(T x) {
        return binarySearch(x,0,size-1,(size-1)/2);
    }

    public void delete(T x) {
        int y = BSHelper(x);
        if (y == -1 ) {
            System.out.print("variable not inset");
            return;
        }
        else {
            System.arraycopy(item,y+1,item,y,(size-1)-y);
            item[size-1]=null;
            size --;
        }

        if (size < item.length/1.25 && item.length > 10) {
            Object[] K = new Object[size];
            System.arraycopy(item,0,K,0,size);
            item = K;
        }
    }

}
