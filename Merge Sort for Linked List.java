// Merge Sort for Linked List java solution

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head.next==null){
            return head;
        }
        
        Node m=mid(head);
        Node h2=m.next;
        m.next=null;
        Node t1=mergeSort(head);
        Node t2=mergeSort(h2);
        Node ans=merge(t1,t2);
        return ans;
    }
    
    static Node mid(Node h){
        Node s=h;
        Node f=h;
        
        while(f.next!=null && f.next.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
    
    static Node merge(Node h1, Node h2){
        if(h1==null){
            return h2;
        }
        if(h2==null){
            return h1;
        }
        
        Node ans=null;
        Node t=null;
        
        if(h1.data < h2.data){
            ans=h1;
            t=ans;
            h1=h1.next;
        }else{
            ans=h2;
            t=ans;
            h2=h2.next;
        }
        while(h1!=null && h2!=null){
            if(h1.data < h2.data){
                t.next=h1;
                t=t.next;
                h1=h1.next;
            }else{
                t.next=h2;
                t=t.next;
                h2=h2.next;
            }
        }
        if(h1==null){
            t.next=h2;
        }
        if(h2==null){
            t.next=h1;
        }
        return ans;
    }
}


