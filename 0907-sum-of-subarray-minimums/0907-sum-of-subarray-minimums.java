class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int mod = 1000000007;

        int[] ple = new int[n];
        int[] nle = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Less Element
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            ple[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        st.clear();

        // Next Less Element
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nle[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {

            long left = i - ple[i];
            long right = nle[i] - i;

            ans = (ans + (left * right % mod) * arr[i]) % mod;
        }

        return (int) ans;
    }
}