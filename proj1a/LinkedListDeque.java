public class LinkedListDeque <T>{
    class node{
        T item;
        node rest;
        node pre;
    }
    node first;
    node last;
    node sentinel;
    int size;

    /*
    初始化一个空的链表双端队列
     */
    public LinkedListDeque(){
       sentinel = new node();
       first = sentinel.rest;
       last = first;
       size = 0;
    }
    /*
    在双端队列的前面添加一个类型的项目。
     */
    public void addFirst(T item){
        node oldfirst = first;
        first = new node();
        first.item = item;
        first.rest = oldfirst;
        size ++;
    }
    /*
    在双端队列的后面添加一个类型的项目。
     */
    public void addLast(T item){
        node oldlast = last;
        last = new node();
        last.item = item;
        last.rest = oldlast;
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
        node p = first;
        while(p != null){
            System.out.print(p.item + " ");
            p = p.rest;
        }
        node q = last;
        while (q != null){
            System.out.print(q.item + " ");
            q = q.rest;
        }

    }

    /*
    删除并返回双端队列后面的项目。如果不存在这样的项目，则返回 null。
     */
    public T removeLast(){
        if (size == 0){
            return null;
        }
        T item_r = last.item;
        last =last.rest;
        size --;
        return item_r;
    }
    public T removeFirst(){
        if(size == 0){
            return null;
        }
        T item_f = first.item;
        first =first.rest;
        size --;
        return item_f;
    }
    /*
    获取给定索引处的项目，其中 0 是前面，1 是下一个项目，依此类推。
    如果不存在这样的项目，则返回 null。不能改变双端队列！
     */
    public T get(int index){
        int i;
        node s1 = first;
        for (i = 0; i < index; i++){
            if (s1 == null)
                return null;
            if (i == index){
                return s1.item;
            }
        }
        return null;
    }
    public T getRecursive(int index){
        return null;
    }
}
