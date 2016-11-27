public class Solution {
    public boolean isAdditiveNumber(String num) {
        for(int i=1; i<num.length(); i++) {
            if (num.charAt(0) == '0' && i > 1) {
                return false;
            }
            String first = num.substring(0, i);
            for (int j=i+1; j<num.length(); j++) {
                if (num.charAt(i) == '0' && j > i+1) {
                    break;
                }
                String second = num.substring(i, j);
                if (isAdditiveNumberHelper(first, second, j, num)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isAdditiveNumberHelper(String first, String second, int index, String num) {
        while (index < num.length()) {
            String sum = stringPlus(first, second);
            if (num.length()-index < sum.length()) {
                return false;
            }
            for (int i=0; i<sum.length(); i++) {
                char c = sum.charAt(i);
                if (c != num.charAt(index+i)) {
                    return false;
                }
            }
            first = second;
            second = sum;
            index += sum.length();
        }
        return true;
    }
    
    public String stringPlus(String num1, String num2) {
        List<Character> ret = new ArrayList<>();
        char[] numArray1 = num1.toCharArray();
        char[] numArray2 = num2.toCharArray();
        int i = numArray1.length-1;
        int j = numArray2.length-1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int n = (numArray1[i--] - '0') + (numArray2[j--] - '0') + carry;
            carry = n / 10;
            n %= 10;
            ret.add(0, (char)(n+48));
        }
        while (i >= 0) {
            int n = (numArray1[i--] - '0') + carry;
            carry = n / 10;
            n %= 10;
            ret.add(0, (char)(n+48));
        }
        while (j >= 0) {
            int n = (numArray2[j--] - '0') + carry;
            carry = n / 10;
            n %= 10;
            ret.add(0, (char)(n+48));
        }
        if (carry > 0) {
            ret.add(0, (char)(carry+48));
        }
        //  array = new char[ret.size()];
        char[] array = new char[ret.size()];
        for (int s=0; s<ret.size(); s++) {
          array[s] = ret.get(s);
        }
        return String.valueOf(array);
    }
}
