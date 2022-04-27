package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrimeNonRecursive {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;

        System.out.print("입력할 숫자의 갯수 : ");
        n = sc.nextInt();

        int data[] = new int[n];

        System.out.print("숫자 띄어쓰기 해서 입력 : ");

        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        nonRecursive(data);
    }

    static List<Integer> combined = new ArrayList<>();


    public static void nonRecursive(int[] data) {
        int num;
        List<Integer> checked = new ArrayList<>();

        if (data.length == 0) return;
        if (data.length == 1) {
            combined.add(data[0]);
        } else {
            for (int i = 0; i < data.length; i++) {
                combined.add(data[i]);  //숫자 그대로 넣기
                checked.add(data[i]);
                for (int k = 0; k < data.length; k++) {
                        if (k != i) {
                            num = (int) (data[i] * Math.pow(10, checked.size()) + data[k]);
                            combined.add(num);
                        }
                }
                checked.clear();

            }
            System.out.println(combined);
            findPrimeNum(combined.get(combined.size() - 1));

        }


    }


    private static void findPrimeNum(int num) {
        boolean[] arr = new boolean[num + 1];    //true 일 때 소수인걸로
        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;

        for (int i = 2; i * i <= num; i ++) {  //루트 num 이하의 모든 수에 대해
            for (int j = i * i; j <= num; j += i) {  //배수들을 false 처리
                arr[j] = false;
            }
        }

        for (int i = 0; i <= num; i ++) {
            if (true == arr[i] && combined.contains(i)) {
                System.out.print(i + " ");
            }
        }

    }



}
