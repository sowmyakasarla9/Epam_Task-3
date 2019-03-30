import java.util.*;

class Metro{
 
	static class Next_stn{
 
		int time;
		int next;
		Long avail_period;
 
		Next_stn(int next,int time,Long avail){
 
			this.next=next;
			this.time=time;
			avail_period=avail;
		}
 
	}
 
	static class State{
 
		Long total_time;
		int node;
 
		State(int n,Long tt){
			node=n;
			total_time=tt;
		}
 
	}
 
	static int n,m;
	static int start,end;
	static ArrayList<Next_stn> adj_list[];
	static Long [] total_time;
 
	static PriorityQueue<State> minimum_que=new PriorityQueue<State>(new Comparator<State>(){
 
		@Override
		public int compare(State s1,State s2){
				return Long.compare(s1.total_time,s2.total_time);
		}
	});
 
	
	public static void main(String [] abs){
		
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		m=s.nextInt();
		adj_list=new ArrayList[n + 1];
		total_time=new Long[n + 1];
		for(int i = 0 ; i <= n ; i++)
		{
			adj_list[i]=new ArrayList<Next_stn>();
		}
		for(int i=0;i<m;i++)
		{
			int K=s.nextInt();
			Long T=s.nextLong();
			int [] line=new int[K];
			for(int j=0;j<K;j++)
			{
				line[j]=s.nextInt();
			}
			for(int j=0;j<K-1;j++)
			{
				int w=s.nextInt();
				adj_list[line[j]].add(new Next_stn(line[j+1],w,T));
				T=T+w;
			}
		}
 
		start=s.nextInt();
		end=s.nextInt();
		Arrays.fill(total_time,Long.MAX_VALUE/2);
		total_time[start]=(long)0;
		minimum_que.add(new State(start,(long)(0)));
 
		System.out.println(calculateLeastTime());
	}
 
	static Long calculateLeastTime()
	{
 
		while(!minimum_que.isEmpty())
		{
 
			State taken_node=minimum_que.poll();
			if(taken_node.node==end)
				return total_time[taken_node.node];
			
			for(Next_stn adj: adj_list[taken_node.node])
			{
				if(total_time[adj.next] > total_time[taken_node.node]+adj.time && total_time[taken_node.node]<= adj.avail_period )
				{
					total_time[adj.next]=total_time[taken_node.node]+adj.time;
					minimum_que.add(new State(adj.next,total_time[adj.next]));
				}
 
			}
		}
		return (long)-1;
	}
}