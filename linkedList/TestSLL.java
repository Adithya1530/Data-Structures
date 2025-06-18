package linkedList;

public class TestSLL {

    public static void main(String[] args){
        SingleLinkedList list = new SingleLinkedList();
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
        list.insertLast(100);
        list.insertLast(690);
        list.insert(84, 0);
        list.insert(36,3);
        list.insert(117, 6);
        list.display(); 
        System.out.println("The first element is deleted : "+list.deleteFirst());
        list.display();
        System.out.println("The last element is deleted : "+list.deleteLast());
        list.display();
        System.out.println("The element at a particular index is deleted : "+list.delete(3));
        list.display();
        System.out.println(list.find(100));
        System.out.println(list.find(011));
        System.out.println(list);
    }
}

