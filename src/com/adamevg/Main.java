package com.adamevg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    }

    public static void chess() {
        final Scanner in = new Scanner(System.in);
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            coordinates.add(new Coordinate(in.nextInt(), in.nextInt()));
        }
        if (isStrikingPair(coordinates)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static Boolean isStrikingPair(List<Coordinate> coordinates) {
        for (int i = 0; i < coordinates.size(); i++) {
            for (int j = i + 1; j < coordinates.size(); j++) {
                if (coordinates.get(i).x == coordinates.get(j).x
                        || coordinates.get(i).y == coordinates.get(j).y
                        || (Math.abs(coordinates.get(i).y - coordinates.get(j).y) == Math.abs(coordinates.get(i).x - coordinates.get(j).x))) {
                    return true;
                }
            }

        }
        return false;
    }

    public static class Coordinate {
        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public String printTextPerRole(String[] roles, String[] playScript) {
        char nl = '\n';
        StringBuilder answer = new StringBuilder();
        for (String role : roles) {
            answer.append(role).append(":").append(nl);
            for (int i = 0; i < playScript.length; i++) {
                if (playScript[i].startsWith(role + ":")) {
                    answer.append(i + 1).append(")").append(playScript[i].substring(role.length() + 1)).append(nl);
                }
            }
            answer.append(nl);
        }
        return answer.toString();
    }

    public static int getQuantityOfCuts(int N) {
        if (N == 1 || N < 0) {
            return 0;
        }
        int quantityOfCuts = 0;
        while (N > 0) {
            if (N % 2 == 0) {
                N /= 2;
            } else {
                N--;
            }
            quantityOfCuts++;
        }
        return quantityOfCuts;
    }

    //aaabbb -> a3b3
    public static String getShortString(String s) {
        char[] a = s.toCharArray();
        int q = 1;
        StringBuilder resultString = new StringBuilder();
        if (a.length == 1) {
            return s;
        } else {
            for (int i = 0; i < a.length - 1; ++i) {
                if (a[i] == a[i + 1]) {
                    ++q;
                }

                if (a[i] != a[i + 1]) {
                    if (q != 1) {
                        resultString.append(q).append(a[i]);
                    } else {
                        resultString.append(a[i]);
                    }
                    q = 1;
                }
            }
            if (a[a.length - 2] == a[a.length - 1]) {
                if (q != 1) {
                    resultString.append(q).append(a[a.length - 1]);
                } else {
                    resultString.append(a[a.length - 1]);
                }
            } else {
                resultString.append(a[a.length - 1]);
            }

            return resultString.toString();
        }
    }

}
