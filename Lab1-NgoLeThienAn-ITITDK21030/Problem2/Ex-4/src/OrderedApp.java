public class OrderedApp {
    public static void main(String[] args) {
        int maxSize = 100;             
        OrdArray sourceArray1 = new OrdArray(maxSize);
        OrdArray sourceArray2 = new OrdArray(maxSize);

        sourceArray1.insert(22);
        sourceArray1.insert(33);
        sourceArray1.insert(44);

        sourceArray2.insert(11);
        sourceArray2.insert(55);
        sourceArray2.insert(66);

        OrdArray destinationArray = new OrdArray(maxSize);
        destinationArray = destinationArray.merge(sourceArray1, sourceArray2);

        System.out.print("Merged Array: ");
        destinationArray.display();
    }
    
}
