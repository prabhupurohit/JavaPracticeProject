package com.pcp.custom.collection;

public class Item<T> {
    private T item;
    private Item<T> next;

    public Item(T item, Item<T> next) {
        this.item = item;
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public Item<T> getNext() {
        return next;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setNext(Item<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }
}
