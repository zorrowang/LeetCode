// Wrong soluction
public class Solution {
    public List<String> addOperators(String num, int target) {
        return addOperators(num, (double)target);
    }
    
    public List<String> addOperators(String num, double target) {
        List<String> ret = new ArrayList<>();
        if (num.length() == 0)  return ret;
        double n = Double.parseDouble(num);
        if (n == target) {
            ret.add(num);
            return ret;
        }
        for (int i=num.length()-1; i>=0; i--) {
            String sub = num.substring(i);
            String rest = num.substring(0, i);
            Double s = Double.parseDouble(sub);
            List<String> l1 = addOperators(rest, target - s);
            if (l1.size() > 0) {
                for (int j = 0; j<l1.size(); j++) {
                    l1.set(j, l1.get(j) + "+" + sub);
                }
                ret.addAll(l1);
            }
            List<String> l2 = addOperators(rest, target + s);
            if (l2.size() > 0) {
                for (int j = 0; j<l2.size(); j++) {
                    l2.set(j, l2.get(j) + "-" + sub);
                }
                ret.addAll(l2);
            }
            List<String> l3 = addOperators(rest, target / s);
            if (l3.size() > 0) {
                for (int j = 0; j<l3.size(); j++) {
                    l3.set(j, l3.get(j) + "*" + sub);
                }
                ret.addAll(l3);
            }
            List<String> l4 = addOperators(rest, target * s);
            if (l4.size() > 0) {
                for (int j = 0; j<l4.size(); j++) {
                    l4.set(j, l4.get(j) + "/" + sub);
                }
                ret.addAll(l4);
            }
        }
        return ret;
    }
}