import java.util.Stack;

public class OctalStack {
    // Convert a decimal number and convert it to octal form
    public static int decimalToOctal (int decimalNumber) {
        Stack<Integer> octalStack = new Stack<>();
        while (decimalNumber > 0) {
            int remainder = decimalNumber % 8;
            octalStack.push(remainder);
            decimalNumber /= 8;
        }

        StringBuilder octalNumber = new StringBuilder();
        while (!octalStack.isEmpty()) {
            octalNumber.append(octalStack.pop());
        }

        return Integer.parseInt(octalNumber.toString());
    }

    // Concatenate two stacks
    public static Stack<Integer> concatenateStacks(Stack<Integer> stack_1, Stack<Integer> stack_2) {
        Stack<Integer> concatenateStack = new Stack<>();
        concatenateStack.addAll(stack_1);
        concatenateStack.addAll(stack_2);
        return concatenateStack;
    }

    // Determine if the contents of one stack are identical to that of another
    public static boolean areStacksIdentical(Stack<Integer> stackA, Stack<Integer> stackB) {
        if (stackA.size() != stackB.size()) {
            return false;
        }

        Stack<Integer> cloneStackA = new Stack<>();
        Stack<Integer> cloneStackB = new Stack<>();
        cloneStackA.addAll(stackA);
        cloneStackB.addAll(stackB);

        while (!cloneStackA.isEmpty() && !cloneStackB.isEmpty()) {
            if (!cloneStackA.pop().equals(cloneStackB.pop())) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) throws Exception {
        int decimalNumber = 2764;

        // task 1
        int octalNumber = decimalToOctal(decimalNumber);
        System.out.println("Decimal " + decimalNumber + " is equivalent to Octal " + octalNumber);

        // task 2
        Stack<Integer> stack_1 = new Stack<>();
        Stack<Integer> stack_2 = new Stack<>();

        stack_1.push(4);
        stack_1.push(5);
        stack_1.push(6);

        stack_2.push(7);
        stack_2.push(8);
        stack_2.push(9);

        Stack<Integer> concatenateStack = concatenateStacks(stack_1, stack_2);
        System.out.println("Concatenate stack: " + concatenateStack);

        // task 3
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();

        stackA.push(1);
        stackA.push(2);
        stackA.push(3);

        stackB.push(1);
        stackB.push(2);
        stackB.push(4);

        boolean stacksIdentical = areStacksIdentical(stackA, stackB);
        System.out.println("Are the two stacks identical? " + stacksIdentical);
    }
}
