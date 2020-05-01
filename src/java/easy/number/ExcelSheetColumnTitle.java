package src.java.easy.number;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder ret = new StringBuilder();
        while(n > 0){
            int num = (n-1)%26;
            ret.insert(0, (char)('A'+num));
            n = (n-1)/26;
        }
        return ret.toString();
    }
}