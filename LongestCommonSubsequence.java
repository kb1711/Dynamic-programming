
public class LongestCommonSubsequence {
     public static void main(String[] args) {
             //String str1="abc", str2="ac";
             String str1="azced", str2="abcdef";
            longestCommonSubsequence(str1, str2);
        }

    private static void longestCommonSubsequence(String str1, String str2) {
        int str1Length=str1.length();
        int str2Length=str2.length();
        int[][] longestSeqArry = new int[str1Length+1][str2Length+1];
       
       
        for(int i = 0 ; i <= str1Length ;i++){
            for(int j = 0 ; j<=str2Length ; j++) {
                if(i==0 || j==0) {
                    longestSeqArry[i][j]=0;
                }
                else if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    longestSeqArry[i][j]=longestSeqArry[i-1][j-1] +1;
                } else {
                    longestSeqArry[i][j]=Math.max(longestSeqArry[i-1][j],longestSeqArry[i][j-1]);
                }
            }
        }
       
   

    for(int i = 0 ; i <= str1Length ;i++){
        System.out.print("\n");
        for(int j = 0 ; j<=str2Length ; j++) {
            System.out.print(longestSeqArry[i][j] +" ");
        }
    }
   
    System.out.print("\n"+backTrackAndPrintLCS(longestSeqArry,str1,str2,str1Length,str2Length));
    }

    private static StringBuffer backTrackAndPrintLCS(int[][] longestSeqArry,
            String str1, String str2, int str1Length, int str2Length) {
        // TODO Auto-generated method stub
        if(str1Length==0 || str2Length==0) {
            return new StringBuffer();
        }
        else if(str1.charAt(str1Length-1) == str2.charAt(str2Length-1)) {
            return backTrackAndPrintLCS(longestSeqArry,str1,str2,str1Length-1,str2Length-1).append(str1.charAt(str1Length-1));
        }
        else{
            if(longestSeqArry[str1Length][str2Length-1] > longestSeqArry[str1Length-1][str1Length]) {
                return backTrackAndPrintLCS(longestSeqArry,str1,str2,str1Length,str2Length-1) ;
            } else {
                return backTrackAndPrintLCS(longestSeqArry,str1,str2,str1Length-1,str2Length);
            }
        }
           
    }

}

