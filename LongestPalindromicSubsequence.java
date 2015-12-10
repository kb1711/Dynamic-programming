public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String str="agbdba";
    //    String str ="racecar";
        longestPalindromicSubsequence(str);
    }

    private static void longestPalindromicSubsequence(String inputStr) {
        int inputStringLength=inputStr.length();
        int[][] outputArr= new int[inputStringLength][inputStringLength];
        for(int strLen=0; strLen < inputStringLength ;strLen++) {
            outputArr[strLen][strLen]=1;
        }
        for(int lenOfConsideredStr=2; lenOfConsideredStr <=inputStringLength ; lenOfConsideredStr++) {
            for(int i =0 ;i < inputStringLength-lenOfConsideredStr+1 ;i++) {
                int j = i + lenOfConsideredStr -1;
                if(lenOfConsideredStr==2 && inputStr.charAt(i)==inputStr.charAt(j)) {
                    outputArr[i][j]=2;
                   
                } else if(inputStr.charAt(i)==inputStr.charAt(j)) {
                    outputArr[i][j]=2 + outputArr[i+1][j-1];
                } else {
                    outputArr[i][j]=Math.max(outputArr[i][j-1], outputArr[i+1][j]);
                }
            }
               
        }
        for(int i =0 ; i < inputStringLength ;i++) {
            System.out.print("\n");
            for(int j =0 ; j < inputStringLength ;j++) {
                System.out.print(outputArr[i][j]+" ");
            }
        }
        System.out.print("\n"+outputArr[0][inputStringLength-1]);
        System.out.print("\n"+backTrackAndPrintLPS(outputArr,inputStr,0,inputStringLength-1));
    }

    private static StringBuffer backTrackAndPrintLPS(int[][] outputArr,
            String inputStr, int startIndex,int endIndex) {
        if(inputStr.length()==0 || startIndex > endIndex) {
            return new StringBuffer();
        }
        else if(inputStr.charAt(startIndex) == inputStr.charAt(endIndex)) {
            if(startIndex==endIndex)
                return backTrackAndPrintLPS(outputArr,inputStr,startIndex+1,endIndex-1).append(inputStr.charAt(startIndex));
            else
                return (new StringBuffer(Character.toString(inputStr.charAt(startIndex)))).append(backTrackAndPrintLPS(outputArr,inputStr,startIndex+1,endIndex-1)).append(inputStr.charAt(startIndex));
        }
        else{
            if(outputArr[startIndex][endIndex-1] > outputArr[startIndex+1][endIndex]) {
                return backTrackAndPrintLPS(outputArr,inputStr,startIndex,endIndex-1) ;
            } else {
                return backTrackAndPrintLPS(outputArr,inputStr,startIndex+1,endIndex);
            }
        }
    }

}
