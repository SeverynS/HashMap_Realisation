package com;

import java.util.*;

public class MyHashMapWithList {
    private ArrayList<Node> nodes;

    /**
     * Initialize your data structure here.
     */
    public MyHashMapWithList() {
        nodes = new ArrayList<>();
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        Node tempNode = new Node(key, value);
        if(!nodes.contains(tempNode)){
            nodes.add(new Node(key, value));
        }else{
            tempNode = nodes.get(nodes.indexOf(tempNode));
            tempNode.setValue(value);
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        Node tempNode = new Node(key);
        if(nodes.contains(tempNode)){
            tempNode = nodes.get(nodes.indexOf(tempNode));
            return tempNode.getValue();
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        Node tempNode = new Node(key);
            nodes.remove(tempNode);
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                nodes +
                '}';
    }

    static class Node {
        final int key;
        int value;

        public Node(int key) {
            this.key = key;
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public int setValue(int newValue) {
            int oldValue = this.value;
            value = newValue;
            return oldValue;
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return getKey() == node.getKey() /*&& getValue() == node.getValue()*/;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}