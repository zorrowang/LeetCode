package src.easy.number;

public class UglyNumber {
    public boolean isUgly(int num) {
        while(num>0) {
            if (num%2 == 0)
                num = num/2;
            else if (num%3 == 0)
                num = num/3;
            else if (num%5 == 0)
                num = num/5;
            else
                return num==1;
        }
        return false;
    }
}