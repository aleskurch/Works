package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static class eat implements Comparable {
        public int weight;
        public int price;
        eat(){}
        public eat(int student_id, int last_name)
        {
            this.weight = student_id;
            this.price = last_name;
        }
        public int compareTo(Object obj)
        {
            eat tmp = (eat) obj;
            if(this.weight  < tmp.weight)
            {
                return -1;
            }
            else if(this.weight > tmp.weight)
            {
                return 1;
            }
            return 0;
        }

    }
    static int knapsack(eat weights[],  eat weights1[], int max, int weith) {
        int n = weights.length;
        int n1 = weights1.length;
        for(int i=0; i<=weith; i++){
            int needed=i;
            int needed1=weith-i;
        int dp[][] = new int[needed + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            for (int w = 1; w <= needed; w++) {
                if (weights[j-1].weight <= w) {
                    dp[w][j] = Math.max(dp[w][j - 1], dp[w - weights[j-1].weight][j - 1] + weights[j-1].price);
                } else {
                    dp[w][j] = dp[w][j - 1];
                }
            }
        }
        int dp1[][] = new int[needed1 + 1][n1 + 1];
        for (int j = 1; j <= n1; j++) {
            for (int w = 1; w <= needed1; w++) {
                if (weights1[j-1].weight <= w) {
                    dp1[w][j] = Math.max(dp1[w][j - 1], dp1[w - weights1[j-1].weight][j - 1] + weights1[j-1].price);
                } else {
                    dp1[w][j] = dp1[w][j - 1];
                }
            }
        }
        if (dp[needed][n] > dp1[needed1][n1] && max < dp1[needed1][n1]) {
            max = dp1[needed1][n1];
        }
        else {
            if (dp[needed][n] <= dp1[needed1][n1] && max < dp[needed][n]) {
                max = dp[needed][n];
            }
        }
        }
        return max;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int weight = sc.nextInt();
        int count_of_eat = sc.nextInt();
        int n = count_of_eat;
        eat[] Eat = new eat[n];
        for (int i = 0; i < n; i++) {
            Eat[i]=new eat();
            Eat[i].weight=sc.nextInt();
            Eat[i].price=sc.nextInt();
        }
        int count_of_drink = sc.nextInt();
        int m = count_of_drink;
        eat[] Drink = new eat[m];
        for (int i = 0; i < m; i++) {
            Drink[i]=new eat();
            Drink[i].weight=sc.nextInt();
            Drink[i].price=sc.nextInt();
        }
        Arrays.sort(Eat);
        Arrays.sort(Drink);
        int max = 0;
            max=knapsack(Eat, Drink, max, weight);
        System.out.println(max);
    }
}