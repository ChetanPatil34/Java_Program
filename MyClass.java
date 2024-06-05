package com.infogalaxy.interfacedemo.exceptiondemo;

import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        int a,b,c=0;
        String name=null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 2 numbers:");
        a=sc.nextInt();
        b=sc.nextInt();
        try {
            c=a/b;
            System.out.println("Length="+name.length());
        } catch (Exception ex) {
            System.out.println("Exception Occured:"+ex.getMessage());
        }
//        } catch (NullPointerException ex2) {
//            System.out.println("Please Enter the Name");
//            System.out.println("System Message:"+ex2.getMessage());
//        }
        finally {
            System.out.println("Code Block Done");
        }
        System.out.println("Div="+c);
    }
}
