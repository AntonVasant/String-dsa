package binarysearch;

public class ShipCapacity {
    public int shipWithinDays(int[] weights, int days) {
        int totalWeight = 0;
        int maxWeight = 0;

        for (int weight : weights) {
            totalWeight += weight;
            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }

        int low = maxWeight;
        int high = totalWeight;
        int result = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canShipWithinDays(weights, mid, days)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean canShipWithinDays(int[] weights, int capacity, int days) {
        int currentLoad = 0;
        int daysRequired = 1;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                daysRequired++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }

        return daysRequired <= days;
    }

}
