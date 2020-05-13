package src.java.easy.number;

public class AddDigits {
    public int addDigits(int num) {
        while (num >= 10) {
            int t = 0;
            while (num > 0) {
                t += (num%10);
                num = num/10;
            }
            num = t;
        }
        return num;
    }
}