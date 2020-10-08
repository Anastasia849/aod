package ru.mirea.aod_practice9;

import java.util.Comparator;
import java.util.PriorityQueue;


public class Tester {

    public static void main(String[] args) {
        Comparator <Request> comparator=new Comparator<Request>() {
            @Override
            public int compare(Request o1, Request o2) {
                if(o1.getPriority()>o2.getPriority())
                    return 1;
                if(o1.getPriority()<o2.getPriority())
                    return -1;
                return 0;
            }
        };
        PriorityQueue <Request> queue=new PriorityQueue<>(10,comparator);
        queue.add(new Request('K',1,5));
        queue.add(new Request('M',2,3));
        queue.add(new Request('P',3,4));
        queue.add(new Request('K',4,7));
        queue.add(new Request('P',5,8));
        queue.add(new Request('M',6,5));
        queue.add(new Request('P',7,4));
        queue.add(new Request('K',8,7));
        queue.add(new Request('P',9,3));
        queue.add(new Request('P',10,4));

        int kTime=0,mTime=0,pTime=0;
        while(!queue.isEmpty()){
            if(queue.peek().getCategory()=='K') kTime+=queue.peek().getTime();
            if(queue.peek().getCategory()=='M') mTime+=queue.peek().getTime();
            if(queue.peek().getCategory()=='P') pTime+=queue.peek().getTime();
            System.out.println(queue.poll());
        }
        System.out.println();
        System.out.println("Time for M category: "+mTime);
        System.out.println("Time for K category: "+ kTime);
        System.out.println("Time for P category: "+ pTime);

    }
}
