public class LinkList
   {
   private Link first;            // ref to first link on list

// -------------------------------------------------------------
   public LinkList()              // constructor
      {
      first = null;               // no links on list yet
      }
// -------------------------------------------------------------
   public void insertFirst(int id, double dd)
      {                           // make new link
// YOUR CODE STARTS HERE
    Link newLink = new Link(id, dd); // create a new Link
    newLink.next = first; // set the new link's 'next' to the current 'first'
    first = newLink; // set the new link as the 'first' link

// YOUR CODE ENDS HERE
      }
// -------------------------------------------------------------
   public Link find(int key)      // find link with given key
      {                           // (assumes non-empty list)
      
// YOUR CODE STARTS HERE
    Link current = first; // start at the beginning of the list
    while (current != null) // until the end of the list
    {
        if (current.iData == key) // check if the key matches
            return current; // found, so return the link
        current = current.next; // move to the next link
    }
    return null; // not found, return null

// YOUR CODE ENDS HERE

      }
// -------------------------------------------------------------
   public Link delete(int key)    // delete link with given key
      {                           // (assumes non-empty list)

// YOUR CODE STARTS HERE
    Link current = first; // start at the beginning of the list
    Link previous = first; // to keep track of the previous link

    while (current != null) // until the end of the list
    {
        if (current.iData == key) // check if the key matches
        {
            if (current == first) // if it's the first link
            {
                first = first.next; // set 'first' to the next link
            } else {
                previous.next = current.next; // link the previous to the next link
            }
            return current; // return the deleted link
        }
        previous = current; // move the previous to the current link
        current = current.next; // move to the next link
    }
    return null;

// YOUR CODE ENDS HERE      

      }
// -------------------------------------------------------------
   public void displayList()      // display the list
      {
      System.out.print("List (first-->last): ");
      Link current = first;       // start at beginning of list
      while(current != null)      // until end of list,
         {
         current.displayLink();   // print data
         current = current.next;  // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   }