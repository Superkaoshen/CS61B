public class LinkedListDeque <T>{
    public class node{
       private T item;
       private node pre;
       private node next;
       public node (T n,node pre1,node next1){
            item = n;
            pre = pre1;
            next = next1;
        }
       public node (node pre1,node next1){
           pre = pre1;
           next = next1;
       }
    }

    private int size;
    /*
    初始化一个空的链表双端队列
     */
    private node sentinel;
    public LinkedListDeque(){
        sentinel = new node(null,null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    /*
    在双端队列的前面添加一个类型的项目。
     */
    public void addFirst(T item){
        node p = new node(item,sentinel,sentinel.next);
        sentinel.next.pre = p;
        sentinel.next = p;
        size++;
    }
    /*
    在双端队列的后面添加一个类型的项目。
     */
    public void addLast(T item){
        node p = new node(item,sentinel.pre,sentinel);
        sentinel.pre.next = p;
        sentinel.pre = p;
        size ++;
    }
    /*
    如果 deque 为空，则返回 true，否则返回 false。
     */
    public boolean isEmpty(){
        if (size == 0)
            return true;
        return false;
    }
    /*
    返回双端队列中的项目数。
     */
    public int size(){
        return size;
    }
    /*
    从头到尾打印双端队列中的项目，用空格分隔。
     */
    public void printDeque(){
        node p = sentinel.next;
        while(p != sentinel){
            System.out.print(p.item + " ");
            p = p.next;
        }

    }

    /*
    删除并返回双端队列后面的项目。如果不存在这样的项目，则返回 null。
     */
    public T removeLast(){
        if (size == 0){
            return null;
        }
        T item_r = sentinel.pre.item;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size --;
        return item_r;
    }
    public T removeFirst(){
        if (size == 0){
            return null;
        }
        T item_r = sentinel.next.item;
            sentinel.next.pre = sentinel;
            sentinel.next = sentinel.next.next;
            size --;
        return item_r;
    }
    /*
    获取给定索引处的项目，其中 0 是前面，1 是下一个项目，依此类推。
    如果不存在这样的项目，则返回 null。不能改变双端队列！
     */
    public T get(int index){
        if (index >= size)
        return null;
        node ptr = sentinel;
        for (int i = 0; i <= index; i ++){
            ptr = ptr.next;
        }
        return ptr.item;
    }
    private T getRecursiveHelp(node start, int index) {
        if (index == 0) {
            return start.item;
        } else {
            return getRecursiveHelp(start.next, index - 1);
        }
    }
    public T getRecursive(int index){
        if (index >= size){
            return null;
        }
        node ptr = sentinel;

        return getRecursiveHelp(ptr.next, index);
    }


    public static void main(String[] args) {
        LinkedListDeque<Integer> k = new LinkedListDeque<Integer>();
        k.addFirst(1);
        k.addFirst(2);
        System.out.println(k.getRecursive(3));
        System.out.println(k.get(-1));
//        k.printDeque();
//
    }
}
