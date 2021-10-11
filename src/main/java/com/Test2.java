package com;

public class Test2 {
    public static void main(String[] args) {
        MyHashMapWithList myHashMap = new MyHashMapWithList();
        myHashMap.put(2, 8);
        myHashMap.put(3, 9);
        myHashMap.put(2, 10);
        myHashMap.put(5, 5);
        myHashMap.put(7, 12);
        System.out.println(myHashMap);
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.get(7));
        System.out.println(myHashMap.get(12));
        myHashMap.remove(5);
        System.out.println(myHashMap);
        myHashMap.put(5, 150);
        System.out.println(myHashMap);
        System.out.println(myHashMap.get(5));
        myHashMap.put(7, 15);
        myHashMap.put(123456, 1);
        System.out.println(myHashMap);
    }

}
