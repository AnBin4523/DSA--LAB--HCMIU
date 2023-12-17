public class Puzzle {
    public static void main(String[] args) {
        System.out.println("The case (base > limit): ");
        System.out.println(puzzle(14, 10)); 
        System.out.println("The case (base < limit): ");
        System.out.println(puzzle(4, 7));  
        System.out.println("The case (base == limit): ");
        System.out.println(puzzle(0, 0));   
    }

    static int puzzle(int base, int limit) {
        // this is a base case
        if (base > limit) {
            return -1;
        } 
        // this is another base case
        else if (base == limit) {  
            return 1;
        } 
        // this is recursive case
        else {
            return base + puzzle(base + 1, limit);
        }
    }
}
