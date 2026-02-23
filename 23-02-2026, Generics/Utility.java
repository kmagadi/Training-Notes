public class Utility
{
    public static <T> void print( T[] items )
    {
        for ( T item : items )
        {
            System.out.print( item + " " );
        }
        System.out.println();
    }

    public static void main( String[] args )
    {
        Integer[] arr = new Integer[ 10 ];
        Boolean[] boolArr = new Boolean[ 2 ];

        for ( int i = 0; i < 10; i++ )
        {
            arr[ i ] = i * 15;
        }

        boolArr[ 0 ] = true;
        boolArr[ 1 ] = false;

        print( arr );
        print( boolArr );
    }
}