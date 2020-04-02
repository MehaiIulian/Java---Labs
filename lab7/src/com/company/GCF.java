package com.company;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/longest-arithmetic-progression-dp-35/

public class GCF {
    // Returns length of the longest
    // AP subset in a given set

    static int lenghtOfLongestAP(ArrayList<Token> progression) {
        int n=progression.size();
        if (n <= 2) return n;

        // Create a table and initialize all
        // values as 2. The value ofL[i][j] stores
        // LLAP with set[i] and set[j] as first two
        // elements of AP. Only valid entries are
        // the entries where j>i
        int L[][] = new int[n][n];

        // Initialize the result
        int llap = 2;

        // Fill entries in last column as 2.
        // There will always be two elements in
        // AP with last number of set as second
        // element in AP
        for (int i = 0; i < n; i++)
            L[i][n - 1] = 2;

        // Consider every element as second element of AP
        for (int j = n - 2; j >= 1; j--) {
            // Search for i and k for j
            int i = j - 1, k = j + 1;
            while (i >= 0 && k <= n - 1) {
                if (progression.get(i).getValue() + progression.get(k).getValue() < 2 * progression.get(j).getValue())
                    k++;

                    // Before changing i, set L[i][j] as 2
                else if (progression.get(i).getValue() + progression.get(k).getValue() < 2 * progression.get(j).getValue())
                {
                    L[i][j] = 2;
                    i--;

                } else {
                    // Found i and k for j, LLAP with i and j as first two
                    // elements is equal to LLAP with j and k as first two
                    // elements plus 1. L[j][k] must have been filled
                    // before as we run the loop from right side
                    L[i][j] = L[j][k] + 1;

                    // Update overall LLAP, if needed
                    llap = Math.max(llap, L[i][j]);

                    // Change i and k to fill
                    // more L[i][j] values for current j
                    i--;
                    k++;
                }
            }

            // If the loop was stopped due
            // to k becoming more than
            // n-1, set the remaining
            // entties in column j as 2
            while (i >= 0) {
                L[i][j] = 2;
                i--;
            }
        }
        return llap;
    }
}