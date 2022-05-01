package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CombineRec {
    static List<String> result = new ArrayList<>();
    static String num = "";
    static List<String> checked = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("숫자 띄어쓰기 해서 입력 : ");

        String input = sc.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        List<String> data = new ArrayList<>();

        int idx = 0;
        while (tokenizer.hasMoreTokens()) {
            data.add(idx, tokenizer.nextToken());
            idx++;
        }


        combine(data, "");
        System.out.println(result);

    }


    public static void combine(List<String> data, String base) {

        if (base.equals(data.get(data.size() - 1))) return;
        else {
            for (int k = 0; k < data.size(); k++) {
                if (!checked.contains(data.get(k))) {
                    num = base + data.get(k);
                    result.add(num);
                    checked.add(data.get(k));
                    combine(data, num);
                    if (checked.size() >= 2)
                        checked.remove(checked.size() - 1);
                }
            }
        }
    }
}