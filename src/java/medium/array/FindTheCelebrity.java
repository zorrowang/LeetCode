package src.java.medium.array;

import java.util.Stack;

/**
 * The knows API is defined in the parent class Relation. boolean knows(int a,
 * int b);
 */

public class FindTheCelebrity extends Relation {
    // Two-Pointer solution - Time: O(n), Space: O(1)
    public int findCelebrity(int n) {
        int a = 0, b = n - 1; 
          
        while (a < b) { 
            if (knows(a, b))    a++; 
            else    b--; 
        }
        for (int i = 0; i < n; i++) { 
            if (i != a && (knows(a, i) || !knows(i, a))) 
                return -1; 
        } 
        return a;
    }

    // Stack solution - Time: O(n), Space: O(n)
    public int findCelebrity2(int n) { 
        Stack<Integer> st = new Stack<>(); 
        int c; 
  
        for (int i = 0; i < n; i++)  
            st.push(i); 
  
        while (st.size() > 1) { 
            int a = st.pop(), b = st.pop(); 
            if (knows(a, b))    st.push(b);
            else    st.push(a); 
        } 
  
        c = st.pop(); 
  
        for (int i = 0; i < n; i++) { 
            if (i != c && (knows(c, i) || !knows(i, c))) 
                return -1; 
        } 
        return c; 
    } 

    // Graph solution
    public int findCelebrity3(int n) {
        int[] incoming = new int[n];
        int[] outcoming = new int[n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == j) continue;
                if (knows(i, j)) {
                    incoming[j]++;
                    outcoming[i]++;
                }
            }
        }
        for (int i=0; i<n; i++) {
            if (incoming[i]==n-1 && outcoming[i]==0)
                return i;
        }
        return -1;
    }
}