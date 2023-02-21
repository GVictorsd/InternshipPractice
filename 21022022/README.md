# Java Collections

## Hierarchy
'''
Iterable
    Collection
        List
            ArrayList
            LinkedList
            Vector
            Stack
        Queue
            PriorityQueue
            ArrayDeque
        Set
            HashSet
            LinkedHashSet
            Sortedset
                TreeSet
'''
## Methods of Collection Interface
- boolean add(E e): insert
- bool addAll(Collection <extends E> c): insert specific collection elems
- bool remove(Obj elem): delete from the collection
- int size()
- void clear() : removes total number of elems
- bool contains(obj elem): search
- Iterator iterator()
- Object[] toArray() : converts collection to Array
- bool isEmpty()
- bool equals(Object element)
- public int hashCode()

## Iterator Interface
- bool hasNext()
- Object next()
- void remove(): removes the last element returned by the iterator

## Iterator
Iterator<T> iterator();

## List interface
ArrayList <T> list1 = new ArrayList();
LinkedList <T> list2 = new LinkedList();
Vector <T> list3 = new Vector();
Stack <T> list4 = new Stack();

## Example
public static void main(String[] argv){
    ArrayList <String> a = new ArrayList<String>();
    a.add("elem1");
    int n = a.size();
    for(String i:a){
        System.out.print(i + " ");
    }

    Iterator<String> it = a.iterator();
    while(it.hasNext()){
        System.out.println(it.next());
    }

}
