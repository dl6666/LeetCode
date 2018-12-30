package myleetcode;

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0 || gas.length != cost.length) return -1;
        int sum = 0, index = 0, rem = 0, len = gas.length;
        for (int i = 0; i < len; i++) {
            if (rem < 0) {
                index = i;
                rem = 0;
            }
            rem += gas[i] - cost[i];
            sum += gas[i] - cost[i];
        }
        if (sum < 0) return -1;
        else return index;
    }
}
