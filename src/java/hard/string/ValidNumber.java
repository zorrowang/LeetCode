package src.java.hard.string;

public class ValidNumber {
    public boolean isNumber(String s) {
        StringBuilder sb = new StringBuilder(s.trim());
        boolean point = false;
        boolean e = false;
        boolean sign = false;
        boolean number = false;
        int i=0; 
        while(i<sb.length()){
            if (Character.isDigit(sb.charAt(i))){
                i++;
                number = true;
            }
            else if (sb.charAt(i)=='.'){
                if (!point){
                    if (i>0&&sb.charAt(i-1)=='e')
                        return false;
                    if (i>0&&Character.isDigit(sb.charAt(i-1))&&e)
                        return false;
                    point = true;
                    i++;
                }
                else
                    return false;
            }
            else if (sb.charAt(i)=='e'){
                if (i>0 && !e){
                    if (i==1&&(sb.charAt(i-1)=='.'||sb.charAt(i-1)=='+'||sb.charAt(i-1)=='-'))
                        return false;
                    e = true;
                    i++;
                }
                else
                    return false;
            }
            else if (sb.charAt(i)=='+' || sb.charAt(i)=='-'){
                if (i==0 && !sign){
                    sign = true;
                    i++;
                }
                else if (i>0 && sb.charAt(i-1)=='e' && i<sb.length()-1)
                    i++;
                else
                    return false;
            }
            else
                return false;
        }
        return number&&sb.charAt(i-1)!='e';
    }
}
