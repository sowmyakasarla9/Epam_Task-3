import java.util.*;
class DescendingWeights{
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int K=sc.nextInt();
        List<Integer>[] weights=new List[K];
        for(int i=0;i<K;i++){
        	weights[i]=new ArrayList<>();
        }
        int a[]=new int[N];
        for(int i=0;i<N;i++){
        	a[i]=sc.nextInt();
        	weights[a[i]%K].add(a[i]);
        }
        for(int i=K-1;i>=0;i--){
        	Collections.sort(weights[i]);
        	for(int j=0;j<weights[i].size();j++){
        		System.out.print(weights[i].get(j)+" ");
        	}
        }
        
    }    
}