//My approach
class Solution {
    public int myAtoi(String s) {
        s = s.trim(); 
        if(s==null || s.length()==0)
            return 0;
        int n=s.length();
        int sign=1;
        int i=0;
        String s1="";
        if(s.charAt(i)=='-'){
            sign=-1;
            i++;
        }else if(s.charAt(i)=='+'){
            i++;
        }
        while(i<n && Character.isDigit(s.charAt(i))){
            s1+=s.charAt(i);
            i++;
            if(s1.length()>11)
                break;
        }
        if(s1.isEmpty())
            return 0;
        double num=Double.parseDouble(s1)*sign;
        if(num>Integer.MAX_VALUE)
            return Integer.MAX_VALUE; 
        if(num<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)num;
    }
}

//The other approach
class Solution {
    public int myAtoi(String s) {
        s = s.trim(); 
        if(s==null || s.length()==0)
            return 0;
        int n=s.length();
        int sign=1;
        int i=0;
        if(s.charAt(i)=='-'){
            sign=-1;
            i++;
        }else if(s.charAt(i)=='+'){
            i++;
        }
        double num = 0; 
        while(i<n && Character.isDigit(s.charAt(i))){
           int digit = s.charAt(i) - '0';
            num = num * 10 + digit;
            i++;
            if(num>Integer.MAX_VALUE)
                break;
        }
        num*=sign;
        if(num>Integer.MAX_VALUE)
            return Integer.MAX_VALUE; 
        if(num<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)num;
    }
}


