import java.util.*;
class GlowingBulb
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int testcase=sc.nextInt();
        for(int j=0;j<testcase;j++)
        {
            List<Integer> list=new ArrayList<>();
            List<Integer> r=new ArrayList<>();
            String s=sc.next();
            long k=sc.nextLong();
            for(int i=0;i<40;i++)
            {
                if(s.charAt(i)=='1')
                {
                    list.add(i+1);
                }
                
            }
            //System.out.println(list);
            int l=r.size();
            int e=list.get(0);
            int len=list.size();
            while(l<=k)
            {
                for(int i=0;i<len;i++)
                {
                    if(e%list.get(i)==0)
                    {
                        r.add(e);
                        break;
                    }
                }
                e++;
                l=r.size();
            }
            System.out.println(r.get((int)k-1));
        }
    }
}