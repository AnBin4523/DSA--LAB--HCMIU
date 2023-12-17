public class StackApp
   {
   public static void main(String[] args)
      {
        StackX theStack = new StackX(5);

        theStack.displayStackArray();
        theStack.displayStack();

        theStack.push(20);
        theStack.displayStackArray();
        theStack.displayStack();

        theStack.push(40);
        theStack.displayStackArray();
        theStack.displayStack();

        theStack.push(60);
        theStack.displayStackArray();
        theStack.displayStack();

        theStack.push(80);
        theStack.displayStackArray();
        theStack.displayStack();

        theStack.push(100); 
        theStack.displayStackArray();
        theStack.displayStack();

        // stack is full
        theStack.push(120); 
        theStack.displayStackArray();
        theStack.displayStack();

        while (!theStack.isEmpty()) {
            long value = theStack.pop();
            System.out.print(value + " ");
        }
        System.out.println();

        // stack is empty
        theStack.pop();
      }  
   }  
