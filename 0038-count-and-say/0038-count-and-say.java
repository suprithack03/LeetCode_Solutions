class Solution {
    public String countAndSay(int n) {

        String result = "1";

        for (int i = 2; i <= n; i++) {

            String next = "";
            int j = 0;

            while (j < result.length()) {

                char ch = result.charAt(j);
                int count = 0;

                // Count consecutive same characters
                while (j < result.length() &&
                       result.charAt(j) == ch) {
                    count++;
                    j++;
                }

                next += count;
                next += ch;
            }

            result = next;
        }

        return result;
    }
}