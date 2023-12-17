public class Link {
    public int iData;              // data item
    public double dData;           // data item
    public Link next;              // next link in list
// -------------------------------------------------------------
    public Link(int id, double dd) // constructor
    {
      iData = id;                 // initialize data
      dData = dd;                 // ('next' is automatically
    }                           //  set to null)
// -------------------------------------------------------------
    // public void displayLink()      // display ourself
    // {
    //   System.out.print("{" + iData + ", " + dData + "} ");
    // }

    public Link getNext() {
        return next;
    }

    public String toString() {
        return "{" + iData + ", " + dData + "}";
    }
}
