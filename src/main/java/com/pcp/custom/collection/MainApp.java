package com.pcp.custom.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MainApp {

    public static void main(String[] args) {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.addItem("Prabhu");
        list.addItem("Banani");
        list.insertFirstItem("Suman");
        list.displayAll();
        list.deleteFirstItem();
        list.displayAll();
        list.insertFirstItem("Ravi");
        list.displayAll();
    }
}
