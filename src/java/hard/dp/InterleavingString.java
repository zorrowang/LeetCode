package src.java.hard.dp;

public class InterleavingString {
    // match[i][j] = {match[i-1][j]&&s1[i]==s3[i+j] | match[i][j-1]&&s2[j]==s3[i+j]}
    public boolean isInterleave(String s1, String s2, String s3) {

        int l1 = s1.length(), l2=s2.length(), l3=s3.length();
        if(l1+l2!=l3)    return false;
        
        boolean[][] match = new boolean[l1+1][l2+1];
        match[0][0] = true;
        for(int i=0; i<l1; i++)
            match[i+1][0] = match[i][0]&&(s1.charAt(i)==s3.charAt(i));
        for(int i=0; i<l2; i++)
            match[0][i+1] = match[0][i]&&(s2.charAt(i)==s3.charAt(i));
        
        for(int i=1; i<=l1; i++){
            for (int j=1; j<=l2; j++){
                match[i][j] = (match[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1)))||(match[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1)));
            }
        }
        
        return match[l1][l2];
    }

    //This backtracking solution
    public boolean isInterleaveRec(String s1, String s2, String s3) {
        if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty())    return true;
        if(s1.isEmpty() || s2.isEmpty()){
            if (s1.isEmpty())   return s2.equals(s3);
            else    return s1.equals(s3);
        }
        if(s1.isEmpty() || s2.isEmpty() || s3.isEmpty())    return false;
        
        char ch1 = s1.charAt(0);
        char ch2 = s2.charAt(0);
        char ch3 = s3.charAt(0);
        
        if (ch1==ch3){
            if(isInterleaveRec(s1.substring(1), s2, s3.substring(1)))
                return true;
        }
        
        if (ch2==ch3){
            if(isInterleaveRec(s1, s2.substring(1), s3.substring(1)))
                return true;
        }
        
        return false;
    }



}

