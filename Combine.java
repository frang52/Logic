package com.example;

import java.util.*;

public class Combine {

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
        combine(data);

    }

    static List<String> result = new ArrayList<>();

    private static void combine(List<String> data) {
        List<String> checked = new ArrayList<>();
        String num;
        String num2;

        if (data.size() == 0) return;
        if (data.size() == 1) {
            result.add(data.get(1));
        } else {
            for (int i = 0; i < data.size(); i++) {
                checked.clear();
                result.add(data.get(i));
                checked.add(data.get(i));
                for (int k = 0; k < data.size(); k++) {
                    if (k != i) {
                        num = data.get(i) + data.get(k);
                        result.add(num);
                        checked.add(data.get(k));
                        for (int j = 0; j < data.size(); j++) {
                            if (!checked.contains(data.get(j))) {
                                num2 = num + data.get(j);
                                result.add(num2);
                            }
                        }
                        if (checked.size() >= 2)
                            checked.remove(checked.size() - 1);
                    }
                }
            }
            System.out.println(result);
        }
    }
}