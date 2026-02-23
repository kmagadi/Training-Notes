import java.util.*;

public class Experiment
{
    public static void main(String[] args) {
        // List< Number > numList = new ArrayList<>();
        List< Integer > intList = new ArrayList<>();

        for( int i = 0; i < 10; i++ ){
            intList.add( i );
        }

//        for( Integer i : intList )
//        {
//            numList.add( i );
//        }

        List< Number > numList = new ArrayList<>(intList);

        for( Number num : numList )
        {
            System.out.println( num );
        }
    }
}