class Solution {
public:
    int reverse(int x) {
        int ans=0;  //reverse no = ans
        while(x != 0){
            int digit = x%10;
        // reverse no ka range se bahar jane ka matlab 
            if((ans>INT_MAX/10) || (ans<INT_MIN/10)){
                return 0;
            }

         ans = ans * 10 + digit;
            x =x/10;
        }
        return ans;
    }
};