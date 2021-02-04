package com.unilog.assignment.element;

public class Node {

    int data;
    Node previousNode;
    Node nextNode;

    public int getData() {
        return data;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    @Override
    public String toString() {
        return " " + data;
    }
}
