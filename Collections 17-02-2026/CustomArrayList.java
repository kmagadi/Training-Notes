public class CustomArrayList 
{
    int[] arr;
    int currInd;
    double loadFactor = 0.7;

    CustomArrayList(int size) 
    {
        currInd = 0;
        arr = new int[size];
    }

    public void add(int ele) 
    {
        if (currInd >= arr.length * loadFactor) 
        {
            resize();
        }
        
        arr[currInd] = ele;
        currInd++;
    }

    private void resize() 
    {
        int newCapacity = arr.length * 2;
        int[] newArr = new int[newCapacity];
        
        for (int i = 0; i < arr.length; i++) 
        {
            newArr[i] = arr[i];
        }
        
        arr = newArr;
    }

    public boolean removeAt(int ind) 
    {
        if (ind < 0 || ind >= currInd) return false;

        for (int i = ind; i < currInd - 1; i++) 
        {
            arr[i] = arr[i + 1];
        }
        currInd--;
        return true;
    }

    public int size() {
        return currInd;
    }

    public boolean isFull()
    {
        if( currInd == arr.length - 1 )
            return true;
        return false;
    }

    public void remove()
    {
        arr[ currInd ] = 0;
        currInd--;
    }

    public boolean isEmpty()
    {
        if( currInd == 0 )
            return true;
        return false;
    }

    public void traverse()
    {
        for( int i = 0; i <= currInd; i++ )
        {
            System.out.println( arr[ i ]);
        }
    }

    public int get( int ind )
    {
        if( ind < 0 )
            return -1;

        if( ind > arr.length )
            return -1;
        
        return arr[ ind ];
    }
    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList( 10 );

        for( int i = 0; i < 100; i++ )
        {
            list.add( i );
        }
        for( int i = 0; i < 100; i++ )
        {
            if( list.get( i ) % 5 == 0 )
                list.remove();
        }
        list.traverse();
    }
}