class Solution {
    public int evalRPN(String[] tokens) {
        Stack <Integer> st = new Stack<>();
        for(String token : tokens){
            if(token.equals  ("+") ||token.equals  ("-") || 
            token.equals ("*") || token.equals  ("/") ){
                int b=st.pop();
                int a = st.pop();
                int res =0;
                switch (token){
                    case "+": res = a+b; break; 
                    case "-": res = a-b; break; 
                    case "*": res = a*b; break; 
                    case "/": res = a/b; break; 
                    
                }
                st.push(res);
            }else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}