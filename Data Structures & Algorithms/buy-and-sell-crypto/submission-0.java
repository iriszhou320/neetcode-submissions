class Solution {
    class Element {
        int lowest;
        int max;
        public Element(int max, int lowest) {
            this.lowest = lowest;
            this.max = max;
        }
    };

    public int maxProfit(int[] prices) {
        // DP carrying over the max profit and the lowest price
        Element[] elements = new Element[prices.length];
        // base case
        elements[0] = new Element(0, prices[0]);
        for (int i = 1; i < prices.length; i++) {
            Element prev = elements[i-1]; 
            System.out.print(prev.lowest);
            if (prices[i] <= prev.lowest) {
                Element current = new Element(prev.max, prices[i]);
                elements[i] = current;
            } else {
                int profit = prices[i] - prev.lowest;
                int currentMax = Math.max(profit, prev.max);
                Element current = new Element(currentMax, prev.lowest);
                elements[i] = current;
            }
        }

        return elements[prices.length-1].max;
    }
}
