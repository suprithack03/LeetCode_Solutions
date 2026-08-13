class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int sign = 1;
        int result = 0;

        // 1. Skip spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Check sign
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        // 3. Read digits
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {

            int digit = s.charAt(i) - '0';

            // 4. Check overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}