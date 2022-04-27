package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrimeRecursive {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;

        System.out.print("입력할 숫자의 갯수 : ");
        n = sc.nextInt();

        List<Integer> data = new ArrayList<>();

        System.out.print("숫자 띄어쓰기 해서 입력 : ");

        for (int i = 0; i < n; i++) {
            data.add(sc.nextInt());
        }

        recursive(data);
    }

    static List<Integer> combined = new ArrayList<>();


    public static void recursive(List<Integer> data) {
        int num;

        if (data.size() == 0) return;
        if (data.size() == 1) {
            combined.add(data.get(0));
        } else {
            for (int i = 0; i < data.size() ; i++) {

//                i번째 숫자와 i+1 번째 숫자를 조합해서 combined 배열에 넣는다
//                        조합한 숫자와 나머지 숫자들을 한번 더 조합해서 combined 에 넣는다
//                        조합한 숫자의 자릿수 == data.size() 가 될때까지 진행한다
//                i번째 숫자와 i+2 번째 숫자를 조합해서 combined 배열에 넣는다
//                        동일하게 진행
//                data.size() 번째 숫자와 data.size() - 1 번째 숫자를 조합할때까지 진행한다.


            }
            System.out.println(combined);
//            detectPrimeNum(combined.get(combined.size() - 1));

        }


    }

    private static void detectPrimeNum(int num) {
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
