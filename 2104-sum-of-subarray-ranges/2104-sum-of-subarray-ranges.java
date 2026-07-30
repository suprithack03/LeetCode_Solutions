class Solution {

    public long subArrayRanges(int[] nums) {

        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    public long sumSubarrayMins(int[] arr) {

        int n = arr.length;

        int[] ple = new int[n];
        int[] nle = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Less
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            ple[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        st.clear();

        // Next Less
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

            ans += left * right * arr[i];
        }

        return ans;
    }

    public long sumSubarrayMaxs(int[] arr) {

        int n = arr.length;

        int[] pge = new int[n];
        int[] nge = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Greater
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            pge[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        st.clear();

        // Next Greater
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {

            long left = i - pge[i];
            long right = nge[i] - i;

            ans += left * right * arr[i];
        }

        return ans;
    }
}