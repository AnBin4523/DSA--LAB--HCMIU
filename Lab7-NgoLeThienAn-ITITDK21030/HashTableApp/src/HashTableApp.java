
// hash.java
// demonstrates hash table with linear probing
// to run this program: C:>java HashTableApp
import java.io.*;

////////////////////////////////////////////////////////////////
class HashTableApp {
    public static void main(String[] args) throws IOException {
        DataItem aDataItem;
        int aKey, size, n, keysPerCell;
        // get sizes
        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 10;
        // make table
        HashTable theHashTable = new HashTable(size);

        System.out.println("Initial key sequence: ");
        for (int j = 0; j < n; j++) // insert data
        {
            aKey = (int) (java.lang.Math.random() *
                    keysPerCell * size);
            System.out.println(aKey + " ");
            aDataItem = new DataItem(aKey);
            theHashTable.insert(aDataItem);
        }
        System.out.println();

        theHashTable.displayTable();
        theHashTable.displayAverageProbeLength();

        System.out.print("Enter load factor to test: ");
        double loadFactor = getDouble();

        int newSize = (int) (size / loadFactor);
        System.out.println("Resizing the hash table to accommodate the load factor: " + loadFactor);
        theHashTable.resize(newSize);
        theHashTable.displayTable();
        theHashTable.displayAverageProbeLength();

        System.out.println("Testing Linear Probing:");
        theHashTable.displayTable();
        theHashTable.displayAverageProbeLength();

        System.out.println("Testing Quadratic Probing:");
        theHashTable.insertQuadratic(new DataItem(123));
        theHashTable.displayTable();
        theHashTable.displayAverageProbeLength();

        while (true) // interact with user
        {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new DataItem(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if (aDataItem != null) {
                        System.out.println("Found " + aKey);
                    } else
                        System.out.println("Could not find " + aKey);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            } // end switch
        } // end while
    } // end main()
      // --------------------------------------------------------------

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    // --------------------------------------------------------------
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    // -------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    public static double getDouble() throws IOException {
        String s = getString();
        return Double.parseDouble(s);
    }
    // --------------------------------------------------------------
} // end class HashTableApp
  ////////////////////////////////////////////////////////////////

class DataItem { // (could have more data)
    private int iData; // data item (key)
    // --------------------------------------------------------------

    public DataItem(int ii) // constructor
    {
        iData = ii;
    }

    // --------------------------------------------------------------
    public int getKey() {
        return iData;
    }
    // --------------------------------------------------------------
} // end class DataItem
  ////////////////////////////////////////////////////////////////

class HashTable {
    private DataItem[] hashArray; // array holds hash table
    private int arraySize;
    private DataItem nonItem; // for deleted items
    private int totalProbeLength;
    private int numInsertions;
    // -------------------------------------------------------------

    public HashTable(int size) // constructor
    {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1); // deleted item key is -1
    }

    public void resize(int newSize) {
        DataItem[] oldArray = hashArray;
        int oldSize = arraySize;

        // Create a new hash array with the new size
        arraySize = newSize;
        hashArray = new DataItem[arraySize];
        numInsertions = 0;
        totalProbeLength = 0;

        // Re-insert the items from the old array into the new array
        for (int i = 0; i < oldSize; i++) {
            if (oldArray[i] != null && oldArray[i].getKey() != -1) {
                insert(oldArray[i]);
            }
        }
    }

    // -------------------------------------------------------------
    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println("");
    }

    // -------------------------------------------------------------
    public int hashFunc(int key) {
        return key % arraySize; // hash function
    }

    private int quadraticProbe(int originalHashVal, int i) {
        return (originalHashVal + i * i) % arraySize;
    }

    public void insertQuadratic(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int originalHashVal = hashVal;
        int probeCount = 0;
        int probeLength = 0;

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            ++probeCount;
            ++probeLength;
            ++hashVal;
            hashVal = quadraticProbe(originalHashVal, probeCount); // Quadratic probing
            hashVal %= arraySize;
        }

        hashArray[hashVal] = item;
        totalProbeLength += probeLength;
        ++numInsertions;

        System.out.println(
                "Inserted key " + key + " with hash value " + originalHashVal + " probe sequence: " + probeCount
                        + " probe length: " + probeLength);
    }

    // -------------------------------------------------------------
    public void insert(DataItem item) // insert a DataItem
    // (assumes table not full)
    {
        int key = item.getKey(); // extract key
        int hashVal = hashFunc(key); // hash the key
        int originalHashVal = hashVal;
        int probeCount = 0;
        int probeLength = 0;

        // until empty cell or -1,
        while (hashArray[hashVal] != null &&
                hashArray[hashVal].getKey() != -1) {
            ++probeCount;
            ++probeLength;
            ++hashVal; // go to next cell
            hashVal = quadraticProbe(originalHashVal, probeCount);
            hashVal %= arraySize; // wraparound if necessary
        }

        hashArray[hashVal] = item; // insert item
        totalProbeLength += probeLength;
        ++numInsertions;

        System.out.println(
                "Inserted key " + key + " with hash value " + originalHashVal + " probe sequence: " + probeCount
                        + " probe length: " + probeLength);
    } // end insert()
      // -------------------------------------------------------------

    public void displayAverageProbeLength() {
        double averageProbeLength = (double) totalProbeLength / numInsertions;
        System.out.println("Average probe length for the initial filling: " + averageProbeLength);
    }

    public DataItem delete(int key) // delete a DataItem
    {
        int hashVal = hashFunc(key); // hash the key

        while (hashArray[hashVal] != null) // until empty cell,
        { // found the key?
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal]; // save item
                hashArray[hashVal] = nonItem; // delete item
                return temp; // return item
            }
            ++hashVal; // go to next cell
            hashVal %= arraySize; // wraparound if necessary
        }
        return null; // can't find item
    } // end delete()
      // -------------------------------------------------------------

    public DataItem find(int key) // find item with key
    {
        int hashVal = hashFunc(key); // hash the key
        int originalHashVal = hashVal;
        int probeCount = 0;
        int probeLength = 0;

        while (hashArray[hashVal] != null) // until empty cell,
        { // found the key?
            ++probeLength;

            if (hashArray[hashVal].getKey() == key) {
                System.out.println("Found key " + key + " with hash value " + originalHashVal + " probe sequence: "
                        + probeCount + " probe length: " + probeLength);
                return hashArray[hashVal]; // yes, return item
            }

            ++probeCount;
            ++hashVal; // go to next cell
            hashVal = quadraticProbe(originalHashVal, probeCount);
            hashVal %= arraySize; // wraparound if necessary
        }

        System.out.println("Could not find key " + key + " with hash value " + originalHashVal + " probe sequence: "
                + probeCount + " probe length: " + probeLength);
        return null; // can't find item
    }
    // -------------------------------------------------------------
} // end class HashTable
  ////////////////////////////////////////////////////////////////