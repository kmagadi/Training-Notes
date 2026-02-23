package Realtime_Trending_Engine_Karthik;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Data model for an order event as specified in the requirements.
 */
class OrderEvent {
    // Fields required by the system 
    public final String orderId;
    public final String userId;
    public final String productId;
    public final String category;
    public final String region;
    public final long timestamp; // epoch time in milliseconds

    /**
     * Constructor to initialize an order event[cite: 4].
     */
    public OrderEvent(String orderId, String userId, String productId, 
                      String category, String region, long timestamp) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.category = category;
        this.region = region;
        this.timestamp = timestamp;
    }

    // Optional: Overriding toString helps with debugging and logging
    @Override
    public String toString() {
        return "OrderEvent{" +
                "orderId='" + orderId + '\'' +
                ", productId='" + productId + '\'' +
                ", category='" + category + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
public class TrendingEngine 
{
    // 1. Storage for events in time order (Last 10 minutes) 
    private final Deque< OrderEvent > eventQueue = new LinkedList<>();

    // 2. Simple Map for counts (Product ID -> Count) 
    private final Map< String, Integer > productCounts = new HashMap<>();

    // 3. Map for Regional Category trends (Region -> Category -> Count) 
    private final Map< String, Map< String, Integer >> regionalCategoryCounts = new HashMap<>();

    private static final long TEN_MIN_MS = 10 * 60 * 1000;

    /**
     * Process a new order event [cite: 3]
     */
    public synchronized void addOrder( OrderEvent event ) 
    {
        // Add event to the back of the queue 
        eventQueue.addLast( event );

        // Increment Global Product Count 
        productCounts.put( event.productId, productCounts.getOrDefault( event.productId, 0 ) + 1 );

        // Increment Regional Category Count 
        Map< String, Integer > categoryMap = regionalCategoryCounts.computeIfAbsent( event.region, k -> new HashMap<>() );
        categoryMap.put( event.category, categoryMap.getOrDefault( event.category, 0 ) + 1);

        // Clean up data older than 10 minutes 
        removeExpiredEvents();
    }

    /**
     * Remove events that are no longer in the 10-minute window 
     */
    private void removeExpiredEvents() 
    {
        long currentTime = System.currentTimeMillis();
        
        while ( !eventQueue.isEmpty() ) 
        {
            OrderEvent oldest = eventQueue.peekFirst();
            
            // If the oldest event is older than 10 mins, remove it 
            if ( currentTime - oldest.timestamp > TEN_MIN_MS ) 
            {
                eventQueue.pollFirst();
                
                // Update product count 
                productCounts.put( oldest.productId, productCounts.get( oldest.productId ) - 1 );
                
                // Update regional category count 
                Map< String, Integer > categoryMap = regionalCategoryCounts.get( oldest.region );
                if ( categoryMap != null ) 
                {
                    categoryMap.put( oldest.category, categoryMap.get( oldest.category ) - 1 );
                }
            } else {
                break; // Everything else in the queue is fresh
            }
        }
    }

    /**
     * Task 1: Get Top 5 Products 
     */
    public synchronized List<String> getTop5Products() 
    {
        return productCounts.entrySet().stream()
                .sorted(( a, b ) -> b.getValue().compareTo( a.getValue()) ) // Sort descending
                .limit( 5 )
                .map( Map.Entry::getKey )
                .collect( Collectors.toList() );
    }

    /**
     * Task 2: Top 3 Categories per Region 
     */
    public synchronized Map<String, List<String>> getTopCategoriesByRegion() {
        Map<String, List<String>> result = new HashMap<>();
        
        for (String region : regionalCategoryCounts.keySet()) {
            List<String> top3 = regionalCategoryCounts.get(region).entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .limit(3)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
            result.put(region, top3);
        }
        return result;
    }
    public static void main(String[] args) {
        TrendingEngine engine = new TrendingEngine();
        long now = System.currentTimeMillis();

        // Adding some dummy data to test
        engine.addOrder( new OrderEvent( "O1", "U1", "Laptop", "Electronics", "India", now ));
        engine.addOrder( new OrderEvent( "O2", "U2", "Laptop", "Electronics", "India", now ));
        engine.addOrder( new OrderEvent( "O3", "U3", "Phone", "Electronics", "India", now ));
        engine.addOrder( new OrderEvent( "O4", "U4", "Sneakers", "Footwear", "India", no));
        engine.addOrder( new OrderEvent( "O5", "U5", "Harry Potter", "Books", "US", now));

        System.out.println("Top 5 Products: " + engine.getTop5Products());
        System.out.println("Top Categories per Region: " + engine.getTopCategoriesByRegion());
    }
}