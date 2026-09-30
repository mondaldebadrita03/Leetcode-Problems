import java.util.Deque;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> oper = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        String[] parts = path.split("/");

        for(String part: parts){
            if(part.equals("") || part.equals(".")){
                continue;
            }
            if(part.equals("..")){
                if(!oper.isEmpty()){
                    oper.pop();
                }
            }
            else{
                oper.push(part);
            }
        }

        while (!oper.isEmpty()) {
            sb.append("/").append(oper.removeLast());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
