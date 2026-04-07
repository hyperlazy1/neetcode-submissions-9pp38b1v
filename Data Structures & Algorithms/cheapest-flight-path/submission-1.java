public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (var flight : flights) {
            adj[flight[0]].add(new int[] { flight[1], flight[2] });
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        q.offer(new int[] { 0, src, 0 });

        while (!q.isEmpty()) {
            var curr = q.poll();
            int stops = curr[0], node = curr[1], cst = curr[2];
            if (stops > k) continue;

            for (var neighbor : adj[node]) {
                int nei = neighbor[0], w = neighbor[1];
                int nextCost = cst + w;
                if (nextCost < prices[nei]) {
                    prices[nei] = nextCost;
                    q.offer(new int[] { stops + 1, nei, nextCost });
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}