/*

https://leetcode.com/problems/my-calendar-i/submissions/1237425928/

[s1, e1] : Range of new slot to be booked
[s2, e2] : Range of previously booked slots

1. s2 >= e1
   
           s1           e1                              OR                  s1          e1
           |------------|                                                   |------------|
                        |------------|                                                         |------------|
			            s2           e2                                                       s2           e2
    
	
	
2. s1 >= e2	   

                       s1           e1                  OR                                     s1          e1
                        |------------|                                                        |------------|
           |------------|                                                   |------------|
          s2           e2                                                  s2           e2

Note: I have considered the first depiction in case-1 
and case-2 as intersections because we are given 
right-open interval range.
So we consider two ranges as non-intersecting even if 
one has the same start as end of the other.

No intersection will occur if either of the above cases 
is satisfied	 

So, we will just check the above conditions against all
the previous bookings and if any of them don't satisfy
either of these condition, then an intersection exists 
and we return false. Otherwise, just insert the new 
booking slot and return true

*/

import java.util.HashMap;

class MyCalendar {
    HashMap<Integer, Integer> map;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public MyCalendar() {
        map = new HashMap();
    }

    public boolean book(int start, int end) {
        for (Integer val : map.keySet()) {
            if (val < end && map.get(val) > start)
                return false;
        }
        map.put(start, end);
        return true;
    }
}
