class Node
{
    int value;
    Node next;

    Node( int value )
    {
        this.value = value;
        next = null;
    }

    Node()
    {
        this.value = 0;
        next = null;
    }
}
public class CustomSet {
    private Node[] table;
    private double loadFactor;
    private int currOccupied;
    private int currSize;

    public CustomSet()
    {   
        loadFactor = 0.7;
        currSize = 10;
        table = new Node[ currSize ];
        currOccupied = 0;
    }

    public void checkCapacity()
    {
        if( currOccupied != 0 && currOccupied >= currSize * loadFactor )
            resize();
    }

    private int getHash(int key) 
    {
        return Math.abs(key) % currSize;
    }

    public void resize() 
    {
        Node[] oldTable = table;
        int oldCapacity = currSize;
        
        currSize = oldCapacity * 2;
        Node[] newTable = new Node[currSize];
    
        for ( int i = 0; i < oldCapacity; i++ ) 
        {
            Node current = oldTable[i];
    
            while ( current != null ) 
            {
                Node nextInOldList = current.next;
    
                int newInd = getHash( current.value );
    
                current.next = newTable[ newInd ]; 
                newTable[ newInd ] = current;
    
                current = nextInOldList;
            }
        }
    
        this.table = newTable;
    }

    public boolean contains( int key )
    {
        int hashCode = getHash( key );
        Node tptr = table[ hashCode ];
        
        while( tptr != null )
        {
            if( tptr.value == key )
                return true;
            
            tptr = tptr.next;
        }
x
        return false;
    }

    // public boolean remove(int key)
    public boolean remove( int key )
    {
        if( contains( key ) )
        {
            int hashCode = getHash( key );
            Node tptr = table[ hashCode ];
            Node prev = null;

            while( tptr != null )
            {
                if( tptr.value == key )
                {
                    if( prev == null )
                    {
                        table[ hashCode ] = tptr.next;
                    }
                    else
                    {
                        prev.next = tptr.next;
                    }

                    currOccupied--;
                    return true;
                }
                
                prev = tptr;
                tptr = tptr.next;
            }
        }

        return false;
    }

    // public boolean add(int key)
    public boolean add( int key )
    {
        if( !contains( key ) )
        {
            checkCapacity();
            int ind = getHash( key );
            
            Node nn = new Node( key );
            
            nn.next = table[ ind ];
            
            table[ ind ] = nn;

            currOccupied++;
            return true;
        }

        return false;
    }

    public void traverse()
    {
        for ( int i = 0; i < table.length; i++ ) 
        {
            Node current = table[ i ];
             
            while ( current != null ) 
            {
                System.out.println( current.value );
                current = current.next;
            }
        } 
    }

    public static void main( String[] args ) 
    {
        CustomSet set = new CustomSet();

        for ( int i = 0; i < 100; i++ ) 
        {
            set.add(i);
        }

        for ( int i = 0; i < 100; i++ ) 
        {
            if ( i % 5 == 0 )
                set.remove(i);
        }

        set.traverse();
        System.out.println("Final Logical Capacity: " + set.currSize);
        System.out.println("Final Element Count: " + set.currOccupied);

        int key = 1;
        boolean addedDup = set.add( key ); 
        System.out.printf("Add duplicate %d: %b%n", key, addedDup );
    }
}