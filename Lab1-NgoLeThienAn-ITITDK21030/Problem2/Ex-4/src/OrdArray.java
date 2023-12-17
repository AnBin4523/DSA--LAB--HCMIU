public class OrdArray {
    private int[] a;
    private int nElems;      

    public OrdArray(int max) {
        a = new int[max];    
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(int searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn;
            else if (lowerBound > upperBound)
                return nElems;
            else {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }

    public void insert(int value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] > value) {
                break;
            }
        }
        for (int k = nElems; k > j; k--) {
            a[k] = a[k - 1];
        }
        a[j] = value;
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }

    public OrdArray merge(OrdArray arr1, OrdArray arr2) {
        int size1 = arr1.size();
        int size2 = arr2.size();
        int newSize = size1 + size2;

        OrdArray mergedArray = new OrdArray(newSize);

        int i = 0, j = 0;

        while (i < size1 && j < size2) {
            int value1 = arr1.a[i];
            int value2 = arr2.a[j];

            if (value1 < value2) {
                mergedArray.insert(value1);
                i++;
            } else {
                mergedArray.insert(value2);
                j++;
            }
        }

        while (i < size1) {
            mergedArray.insert(arr1.a[i]);
            i++;
        }

        while (j < size2) {
            mergedArray.insert(arr2.a[j]);
            j++;
        }

        return mergedArray;
    }
}