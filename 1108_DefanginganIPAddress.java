// Manual Approach

class Solution {
    public String defangIPaddr(String address) {
        String s = "";
        for(char c: address.toCharArray()){
            if(c == '.')
                s += "[.]";
            else
                s += c;
        }
        return s;
    }
}

// Replace method approach

class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
