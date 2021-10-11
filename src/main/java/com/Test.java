package com;
/*
Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map,
update the corresponding value. int get(int key) returns the value to which the specified key is mapped,
or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
*/

public class Test {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
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
    }
}
