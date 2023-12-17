import java.util.List;
import java.util.ArrayList;

public class SubSetRecursive {
    static List<List<Integer>> generateSubSets(int[] set, int index) {
        List<List<Integer>> subsets;
        
        if (index == set.length) {
            subsets = new ArrayList<>();
            subsets.add(new ArrayList<>());
        } else {
            subsets = generateSubSets(set, index + 1);
            int currentElement = set[index];
            
            int size = subsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(subsets.get(i));
                subset.add(currentElement);
                subsets.add(subset);
            }
        }
        
        return subsets;
    }
    public static void main(String[] args) throws Exception {
        int[] inputSet = {1, 2, 3, 4, 5};
        List<List<Integer>> subsets = generateSubSets(inputSet, 0);
        
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
