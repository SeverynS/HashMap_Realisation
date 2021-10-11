package com;

import java.util.Arrays;
import java.util.Objects;

public class MyHashMap {
    private Object[][] nodes;

    public static Integer hashCalculation(int key) {
        return Objects.hash(key) * 1023;
    }


    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        nodes = new Object[16][16];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[0][i] == null) {
                nodes[1][i] = new Node(key, value);
                nodes[0][i] = hashCalculation(key);
                break;
            }
            Node currentNode = (Node) nodes[1][i];
            if (currentNode.getKey() == key) {
                currentNode.setValue(value);
                break;
            }
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int tempHash = hashCalculation(key);

        for (int i = 0; i < nodes.length; i++) {
            Node currentNode = (Node) nodes[1][i];
            if (nodes[1][i] == null) {
                break;
            }
            if (hashCalculation(currentNode.getKey()).equals(tempHash)) {
                return currentNode.getValue();
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int tempHash = hashCalculation(key);
        for (int i = 0; i < nodes.length; i++) {
            Node currentNode = (Node) nodes[1][i];
            if (hashCalculation(currentNode.getKey()).equals(tempHash)) {
                nodes[0][i] = null;
                nodes[1][i] = null;
                break;
            }
        }

    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                Arrays.deepToString(nodes) +
                '}';
    }

    static class Node {
        final int key;
        int value;

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
            return getKey() == node.getKey() && getValue() == node.getValue();
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}