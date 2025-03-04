class Solution {
public:
    void reverseString(vector<char>& s) {  //array ka naam s
    stack<char>st;  //stack banaya st naam ka 
    for(int i=0; i<s.size(); i++)
    {
        st.push(s[i]);  //array ke elements ko stack me daal do
    }
    int i=0;
    while(!st.empty())  //stack jab tak empty na ho tab tak
    {
        s[i] = st.top();  //array me wapis dalo stack se element
        st.pop();
        i++;   // array ka 1 index badha do
    }
    }
};