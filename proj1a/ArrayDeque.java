import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

public class ArrayDeque {
        private int[] items;
        private int size;
        private int nextFirst;
        private int nextLast;

        public ArrayDeque() {
            items = new int[8];
            size = 0;
            nextFirst = 4;
            nextLast = 5;
        }

        private void resize(int capacity) {
            int[] a = new int[capacity];
            int tmp = (nextFirst + items.length) % items.length + 1;
            int tmp1 = nextLast - 1;
            for (int i = 0;i <= tmp1; i++){
                a[tmp1 - i] = items[tmp1 - i];

                //nextFirst ++;
            }
            //nextFirst = nextFirst - 1;
            int tmp3 = items.length;
            int tmp4 = items.length * 2;
            for (int i = tmp;i < items.length; i ++){
                a[--tmp4] = items[--tmp3];
                //System.out.println(tmp4);
            }
            System.out.println(tmp4);
            nextFirst = tmp4 - 1;
            items = a;

        }



        public void addLast(int x) {
            if (size == items.length){
                resize(size * 2);
            }
            if (size == 0){
                items[nextLast] = x;
            }else
                items[nextLast % items.length] = x;
            nextLast ++;
            size ++;
        }
        public void addFirst(int x){
            if (size == items.length){
                resize(size * 2);
            }
            if (size == 0){
                items[nextFirst] = x;
            }else {
                items[(nextFirst + items.length)% items.length] = x;
            }
            nextFirst = (nextFirst + items.length) % items.length - 1;
            size ++;
        }
        public int size(){
            return size;
        }
        public Boolean isEmpty(){
            return size == 0;
        }
        public void printDeque(){
            for(int i = 0;i < items.length; i++){
                if (get(i)!=0)
                    System.out.print(get(i) + " ");
            }
        }
        public int remveLast(){
            if(size == 0){
                return 0;
            }
            int items_r = items[nextLast - 1];
            items[nextLast - 1] = 0;
            nextLast --;
            size --;
            return items_r;
        }
        public int removeFirst(){
            if (size == 0){
                return 0;
            }
            int items_r = items[nextFirst + 1];
            items[nextFirst] = 0;
            nextFirst ++;
            size --;
            return items_r;
        }
        public int get(int index){
            if (index >= size || index < 0){
                return 0;
            }
            int index_real = (nextFirst + items.length + 1) % items.length;
            //System.out.println(nextFirst);
            return items[(index_real + index)% items.length ];

        }


//    public static void main(String[] args) {
//        ArrayDeque k = new ArrayDeque();

         //10 8 7 6 5 3 2 1 4 9 11 12 13 15
//        k.addFirst(1);
//        k.addFirst(2);
//        k.addFirst(3);
//        k.addLast(4);
//        k.addFirst(5);
//        k.addFirst(6);
//        k.addFirst(7);
//        k.addFirst(8);
//        k.addLast(9);
//        k.addFirst(10);
//        k.addLast(11);
//        k.addLast(12);
//        k.addLast(13);
//        k.addLast(14);
//        k.addLast(15);
//        k.addLast(16);
//        k.addFirst(17);
//        k.removeFirst();
//        k.addFirst(18);





//        k.get(0);
//        System.out.println(k.removeFirst());
//        System.out.println(k.remveLast());

        //k.remveLast();
        //k.removeFirst();
        //System.out.println(k.size);
        //System.out.println(k.items.length);
//        System.out.println(k.get(14));
//        k.printDeque();
    //}
}
