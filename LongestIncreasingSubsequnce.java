import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequnce {
	public static void main(String[] args) {
		int[] arr= {-9,-4,8,-2,1,4,-1,3,4};
		//int[] arr= {2,7,4,3,8};
		longestIncreasingSubsequence(arr);
	}

	private static void longestIncreasingSubsequence(int[] arr) {
		int[] sequenceList = new int[arr.length];
		int[] parentIndexList = new int[arr.length];
		int maxTillNow=0;
		int maxTillNowIndex=-1;
		for(int i = 0 ; i< arr.length;i++) {
			sequenceList[i]=1;
			parentIndexList[i]=-1;
		}
		for(int i = 1 ; i< arr.length;i++) {
			for(int j = 0 ; j< i;j++) {
				if(arr[i] >=arr[j]){
					if((1+sequenceList[j]) > sequenceList[i]) {
						parentIndexList[i]=j;
					}
					sequenceList[i]=Math.max(sequenceList[i],1+sequenceList[j]);
					if(sequenceList[i] >maxTillNow)
						maxTillNow=sequenceList[i];
						maxTillNowIndex=i;
				}
			}
		}
		for(int i = 0 ; i< arr.length;i++) {
			System.out.print(sequenceList[i]+ " ");
		}
		System.out.print("\nMax Till Now: " +maxTillNow +"\n");
		List<Integer> seqList = new ArrayList<Integer>();
		while(maxTillNowIndex !=-1){
			seqList.add(sequenceList[maxTillNowIndex]);
			maxTillNowIndex=parentIndexList[maxTillNowIndex];
		}
		for(int seqIndex : seqList) {
			System.out.print(seqIndex+ " ");
		}
	}
}
