package src.java.hard.string;

public class IntegerToEnglishWords {
    String[] array = {"", "Thousand", "Million", "Billion", "Trillion"};
    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] doubles = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", 
                        "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
                     "Ninety"};
    public String numberToWords(int num) {
        if (num == 0)   return "Zero";
        StringBuilder builder = new StringBuilder();
        int cnt = 0;
        while (num > 0) {
            builder.insert(0, convert(num%1000, cnt));
            cnt++;
            num = num/1000;
        }
        return builder.toString().trim();
    }
    
    private String convert(int num, int suffix) {
        StringBuilder builder = new StringBuilder();
        int cnt = 1;
        while (num > 0) {
            if (cnt==1 && num % 100 >= 10 && num % 100 < 20) {
                builder.insert(0, " " + doubles[num % 10]);
                num = num / 100;
                cnt++;
            } else {
                int n = num % 10;
                if (n != 0) {
                    String str = "";
                    if (cnt==1)         str = singles[n];
                    else if (cnt==2)    str = tens[n];
                    else if (cnt==3)    str = singles[n] + " Hundred";
                    builder.insert(0, " " + str);
                }
                num = num / 10;
            }    
            cnt++;
        }
        if (cnt > 1 && suffix > 0)
            builder.append(" " + array[suffix]);
        return builder.toString();
    }
}