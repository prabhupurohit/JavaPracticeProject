package com.pcp.custom.collection;

public class CustomLinkedList<T> {

    private Item<T> head;

    //Add item to the end of the list
    public void addItem(T t) {
        Item<T> newItem = new Item<> (t, null);
        Item<T> prevItem = null;
        Item<T> nextItem = head;

        while (nextItem != null) {
            prevItem = nextItem;
            nextItem = nextItem.getNext();
        }
        if (head == null) {
            head = newItem;
        } else {
            prevItem.setNext(newItem);
        }
    }

    //Insert item in the beginning of the list
    public void insertFirstItem (T t) {
        Item<T> newItem = new Item<>(t, null);
        Item<T> previousHead;
        if (head !=null) {
            previousHead = head;
            newItem.setNext(previousHead);
        }
        head = newItem;
    }

    //Delete item in the beginning of the list
    public void deleteFirstItem () {
        Item<T> previousHead = null;
        if(head != null) {
            previousHead = head;
        }
        
        if (head.getNext() != null) {
            head = head.getNext();
        }

        previousHead.setNext(null);
    }

    //Display All items in the list
    public void displayAll() {
        Item<T> nextItem = head;
        while (nextItem != null) {
            System.out.println("Item: " + nextItem.getItem());
            nextItem = nextItem.getNext();
        }
    }
}
