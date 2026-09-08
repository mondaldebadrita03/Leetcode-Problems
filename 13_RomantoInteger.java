class Solution {
    public int romanToInt(String s) {
        int val = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            switch(c){
                case 'I' -> val += 1;
                case 'V' -> val += 5;
                case 'X' -> val += 10;
                case 'L' -> val += 50;
                case 'C' -> val += 100;
                case 'D' -> val += 500;
                case 'M' -> val += 1000;
            }
            if(i > 0){
                if(c == 'V' && s.charAt(i - 1) == 'I' || c == 'X' && s.charAt(i - 1) == 'I'){
                    val -= 1;
                    i--;
                }
                if(c == 'L' && s.charAt(i - 1) == 'X' || c == 'C' && s.charAt(i - 1) == 'X'){
                    val -= 10;
                    i--;
                }
                if(c == 'D' && s.charAt(i - 1) == 'C' || c == 'M' && s.charAt(i - 1) == 'C'){
                    val -= 100;
                    i--;
                }
            }
        }
        return val;
    }
}
