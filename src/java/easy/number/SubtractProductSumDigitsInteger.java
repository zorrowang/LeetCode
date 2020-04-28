package src.java.easy.number;

class SubtractProductSumDigitsInteger {
    public int subtractProductAndSum(int n) {
        int sum = 0, product = 1;
        while (n > 0) {
            int d = n % 10;
            sum += d;
            product *= d;
            n = n/10;
        }
        return product-sum;
    }
}