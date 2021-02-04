package com.unilog.assignment.datastructure;

import com.unilog.assignment.element.Node;

public class DoubleLinkedList {

    Node firstNode;
    Node lastNode;
    int numberOfNodes;
    Node[] hashTable;

    public DoubleLinkedList() {
        firstNode = null;
        lastNode = null;
        numberOfNodes = 0;
    }

    public void addFirstNode(int data) {
        Node newNode = new Node();
        newNode.setData(data);
        if (isListEmpty()) {
            firstNode = lastNode = newNode;
            numberOfNodes++;
        } else {
            firstNode.setPreviousNode(newNode);
            newNode.setNextNode(firstNode);
            newNode.setPreviousNode(null);
            firstNode = newNode;
            numberOfNodes++;
        }
        System.out.println("Node added");
    }

    public void addLastNode(int data) {
        Node newNode = new Node();
        newNode.setData(data);

        if (isListEmpty()) {
            firstNode = lastNode = newNode;
            numberOfNodes++;
        } else {
            lastNode.setNextNode(newNode);
            newNode.setPreviousNode(lastNode);
            newNode.setNextNode(null);
            lastNode = newNode;
            numberOfNodes++;
        }
        System.out.println("Node added");
    }

    public void display() {
        Node pos = firstNode;
        System.out.println(" ---- Nodes in the list are --- \n ");
        while (pos != null) {
            System.out.print("\t" + pos.getData());
            pos = pos.getNextNode();
        }
    }


    public void addNode(int data, int index) {
        if (isListEmpty()) {
            System.out.println(" Currently there no nodes in the list");
        }
        if (index < 0 || index > numberOfNodes + 1) {
            System.out.println("Invalid index number");
        } else if (index == 1) {
            addFirstNode(data);
        } else if (index == numberOfNodes) {
            addLastNode(data);
        } else {
            Node newNode = new Node();
            newNode.setData(data);
            Node pos = firstNode;
            while (index > 1) {
                pos = pos.getNextNode();
                index--;
            }
            newNode.setNextNode(pos);
            newNode.setPreviousNode(pos.getPreviousNode());
            pos.getPreviousNode().setNextNode(newNode);
            pos.setPreviousNode(newNode);
            numberOfNodes++;
            System.out.println("Node Added");

        }
    }

    public void removeFirstNode() {
        if (isListEmpty()) {
            System.out.println("Currently there are no nodes in the list");
        } else {
            Node node = firstNode;
            if (lastNode.equals(firstNode)) {
                numberOfNodes--;
                System.out.println("Deleted first node : " + lastNode.getData());
                lastNode = null;
                firstNode = null;
            } else {
                firstNode = firstNode.getNextNode();
                firstNode.setPreviousNode(null);
                numberOfNodes--;
                System.out.println("Deleted first node : " + node.getData());
            }
        }
    }

    public void removeLastNode() {
        if (isListEmpty()) {
            System.out.println("Currently there are no nodes in the list");
        } else {
            Node node = lastNode;
            if (lastNode.equals(firstNode)) {
                numberOfNodes--;
                System.out.println("Deleted lastNode node : " + lastNode.getData());
                lastNode = null;
                firstNode = null;
            } else {
                lastNode = lastNode.getPreviousNode();
                lastNode.setNextNode(null);
                numberOfNodes--;
                System.out.println("Deleted lastNode node : " + node.getData());
            }
        }
    }

    public void removeNode(int index) {
        if (isListEmpty()) {
            System.out.println("Currently there are no nodes in the list");
        }
        if (index < 0 || index > numberOfNodes + 1) {
            System.out.println("Invalid index");
        } else if (index == 1) {
            removeFirstNode();
        } else if (index == numberOfNodes) {
            removeLastNode();
        } else {
            Node pos = firstNode;
            while (index > 1) {
                pos = pos.getNextNode();
                index--;
            }
            Node node = pos;
            pos.getPreviousNode().setNextNode(pos.getNextNode());
            pos.getNextNode().setPreviousNode(pos.getPreviousNode());
            numberOfNodes--;
            System.out.println("Deleted Node " + node.getData());
        }
    }

    boolean isListEmpty() {
        if (numberOfNodes == 0)
            return true;
        return false;
    }

    private void generateHashTable() {
        hashTable = new Node[numberOfNodes];
        Node pos = firstNode;
        int index = 0;
        while (pos != null) {
            index = pos.getData() % numberOfNodes;
            Node node = new Node();
            node.setData(pos.getData());

            if (hashTable[index] != null) {
                Node linkPos = hashTable[index];
                while (linkPos.getNextNode() != null) {
                    linkPos = linkPos.getNextNode();
                }
                linkPos.setNextNode(node);
                node.setNextNode(null);
            } else {
                node.setNextNode(null);
                hashTable[index] = node;
            }
            pos = pos.getNextNode();
        }

        System.out.println(" Following is the newly created hash table data ");
        for (int i = 0; i < numberOfNodes; i++) {
            if (hashTable[i] != null) {
                Node linkPos = hashTable[i];
                while (linkPos != null) {
                    System.out.println(" index " + i + " value " + linkPos.getData());
                    linkPos = linkPos.getNextNode();
                }
            }
        }
    }

    public void findNode(int value) {
        if (isListEmpty()) {
            System.out.println("The list empty");
        } else {
            generateHashTable();
            int index = value % numberOfNodes;
            if (hashTable[index].getData() == value) {
                System.out.println(" Element present in the list");
            } else {
                boolean found = false;
                if (hashTable[index].getNextNode() != null) {
                    Node linkPos = hashTable[index];
                    while (linkPos != null) {
                        if (linkPos.getData() == value) {
                            found = true;
                            break;
                        }
                        linkPos = linkPos.getNextNode();
                    }
                }
                if (found) {
                    System.out.println("Element present in the table");
                } else {
                    System.out.println("Element not present in the table");
                }
            }
        }
        hashTable = null;
    }
}

