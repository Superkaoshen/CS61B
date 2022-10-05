import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

public class ArrayDeque <T>{
        private T[] items;
        private int size;
        private int nextFirst;
        private int nextLast;

        public ArrayDeque() {
            items = (T[]) new Object[8];
            size = 0;
            nextFirst = 4;
            nextLast = 5;
        }

        private void resize(int capacity) {
            T[] a = (T[]) new Object[capacity];
            int tmp = (nextFirst + items.length) % items.length + 1;
            int tmp1 = nextLast - 1;
            for (int i = 0;i <= tmp1; i++){
                a[tmp1 - i] = items[tmp1 - i];
            }
            int tmp3 = items.length;
            int tmp4 = items.length * 2;
            for (int i = tmp;i < items.length; i ++){
                a[--tmp4] = items[--tmp3];
            }
            nextFirst = tmp4 - 1;
            items = a;
        }



        public void addLast(T x) {
            if (size == items.length){
                resize(size * 2);
            }
            if (size == 0){
                items[nextLast] = x;
            }else
                items[nextLast % items.length] = x;
            nextLast = (nextLast % items.length) + 1;
            size ++;
        }
        public void addFirst(T x){
            if (size == items.length){
                resize(size * 2);
            }
            if (size == 0){
                items[nextFirst] = x;
            }else {
                items[(nextFirst + items.length)% items.length] = x;
            }if(nextFirst == 0){
                nextFirst = items.length - 1;
            }else
                nextFirst = (nextFirst + items.length) % items.length - 1;
            size ++;
        }
        public int size(){
            return size;
        }
        public boolean isEmpty(){
            return size == 0;
        }
        public void printDeque(){
            for(int i = 0;i < items.length; i++){
                if (get(i) != null)
                    System.out.print(get(i) + " ");
            }
        }
        public T removeLast(){
            if(size == 0){
                return null;
            }
            T items_r = items[nextLast - 1];
            items[nextLast - 1] = null;
            nextLast --;
            size --;
            return items_r;
        }
        public T removeFirst(){
            if (size == 0){
                return null;
            }
            T items_r = items[(nextFirst + items.length) % items.length];
            items[nextFirst] = null;
            nextFirst++;
            nextFirst = (nextFirst + items.length) % items.length;
            size --;
            return items_r;
        }
        public T get(int index){
            if (index >= size || index < 0){
                return null;
            }
            int index_real = (nextFirst + items.length + 1) % items.length;
            return items[(index_real + index)% items.length];

        }

    public static void main(String[] args) {
        ArrayDeque<Integer> k = new ArrayDeque();
        k.addFirst(0);
        k.addFirst(1);
        k.addFirst(2);
        System.out.println(k.isEmpty());
        System.out.println(k.isEmpty());

        k.addFirst(5);
        k.addFirst(6);
        k.removeFirst();

        k.printDeque();
    }


}
