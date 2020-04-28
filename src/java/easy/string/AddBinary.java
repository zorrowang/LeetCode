package src.java.easy.string;

class AddBinary {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (a==null && b==null)   return "";
        if (a==null || b==null)   return a==null?b:a;
        
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        
        char[] ret = new char[Math.max(arr1.length, arr2.length)];
        
        int i=arr1.length-1, j=arr2.length-1;
        boolean flow = false;
        
        while(i>=0 && j>=0){
            int k = Math.max(i, j);
            int temp = (arr1[i]-'0') + (arr2[j]-'0');
            if (flow)   temp++;
            if (temp>=2){
                ret[k] = (temp%2==0?'0':'1');
                flow = true;
            }
            else{
                ret[k] = (temp==0?'0':'1');
                flow = false;
            }
            i--;
            j--;
        }
        
        while(i>=0){
            int temp = arr1[i]-'0';
            if (flow)   temp++;
            if (temp>=2){
                ret[i] = (temp%2==0?'0':'1');
                flow = true;
            }
            else{
                ret[i] = (temp==0?'0':'1');
                flow = false;
            }
            i--;
        }
        
        while(j>=0){
            int temp = arr2[j]-'0';
            if (flow)   temp++;
            if (temp>=2){
                ret[j] = (temp%2==0?'0':'1');
                flow = true;
            }
            else{
                ret[j] = (temp==0?'0':'1');
                flow = false;
            }
            j--;
        }
        
        String str = new String(ret);
        if (flow) str = "1"+str;
        return str;
    }
	
	// More precise version
	public String addBinaryUpdated(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String ret = "";
        if (a==null && b==null) return ret;
        if (a==null || b==null) return (a==null)?b:a;
        
        int i=a.length()-1, j=b.length()-1;
        int carry = 0;
        
        while(i>=0 || j>=0){
            int temp = 0;
            if (i>=0 && j>=0)
                temp = (a.charAt(i--)-'0') + (b.charAt(j--)-'0') + carry;
            else if(i>=0)
                temp = (a.charAt(i--)-'0') + carry;
            else
                temp = (b.charAt(j--)-'0') + carry;
                
            carry = temp/2;
            ret = (temp%2) + ret;
        }
        
        if (carry>0)    ret = "1"+ret;
        return ret;
    }
}