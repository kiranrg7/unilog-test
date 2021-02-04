package com.unilog.assignment;

import com.unilog.assignment.datastructure.DoubleLinkedList;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        // write your code here
        int ch = 0;
        Scanner scanner = new Scanner(System.in);
        int val;
        int index;
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        while (ch != 9) {
            ch = menu();

            switch (ch) {
                case 1:
                    System.out.println("Enter the value");
                    val = scanner.nextInt();
                    doubleLinkedList.addFirstNode(val);
                    break;

                case 2:
                    System.out.println("Enter the value");
                    val = scanner.nextInt();
                    doubleLinkedList.addLastNode(val);
                    break;

                case 3:
                    System.out.println("Enter the value");
                    val = scanner.nextInt();
                    System.out.println("Enter index number");
                    index = scanner.nextInt();
                    doubleLinkedList.addNode(val, index);
                    doubleLinkedList.display();
                    break;

                case 4:
                    doubleLinkedList.removeFirstNode();
                    doubleLinkedList.display();
                    break;

                case 5:
                    doubleLinkedList.removeLastNode();
                    doubleLinkedList.display();
                    break;

                case 6:
                    System.out.println("Enter index number");
                    index = scanner.nextInt();
                    doubleLinkedList.removeNode(index);
                    doubleLinkedList.display();
                    break;

                case 7:
                    System.out.println("Enter value to find");
                    val = scanner.nextInt();
                    doubleLinkedList.findNode(val);
                    break;

                case 8:
                    doubleLinkedList.display();
                    break;

                case 9:System.out.println("Exiting...Thank you..");
                    break;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }

    static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n-----Double Linked List ---------\n");
        System.out.println("1) Add node first\n2) Add node last\n3) Add node at an index\n4) Remove first node\n" +
                "5) Remove last node\n6) Remove node at an index\n7) Find a node \n8) Display data\n9) Exit");
        System.out.println(" Enter your choice");
        return scanner.nextInt();

    }
}
