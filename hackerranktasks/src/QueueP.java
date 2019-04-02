import java.io.*;
import java.util.*;

public class QueueP {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Queue<Integer> q=new LinkedList<>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
        int ch=sc.nextInt();
        switch(ch)
        {
            case 1:int val=sc.nextInt();
                    q.add(val);
                    break;
            case 2:q.remove();
                     break;
            case 3:System.out.println(q.peek());
                     break;
        }
        }
    }
}

