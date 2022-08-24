class Solution {
    public int evalRPN(String[] s) {
        int n = s.length;
        
        if(n == 0) return 0;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++)
        {
            String t = s[i];
            char ch = t.charAt(0);
            
            if(t.length() == 1 && (ch == '+' || ch == '-' || ch == '/' || ch == '*'))
            {
                int fi = st.pop();
                int se = st.pop();
                if(ch == '+'){
                    st.push(fi + se);
                }
                else if(ch == '*'){
                    st.push(fi * se);
                }
                else if(ch == '-'){
                    st.push(se - fi);
                }
                else{
                    st.push(se / fi);
                }
            }
            else
            {
                st.push(Integer.parseInt(t));
            }
        }
        
        return st.pop();
    }
}

