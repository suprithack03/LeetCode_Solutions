class Solution {
    public int repeatedStringMatch(String a, String b) {

        String str = a;
        int count = 1;

        while (str.length() < b.length()) {
            str = str + a;
            count++;
        }

        if (str.contains(b)) {
            return count;
        }

        str = str + a;
        count++;

        if (str.contains(b)) {
            return count;
        }

        return -1;
    }
}