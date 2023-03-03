class Solution {
    public int compress(char[] chars) {
        int i = 0 ; 
        int j = 0 ; 
        int n = chars.length; 
        if(n ==1)
        return 1; 

        while(i<n){
        int count = 1 ; 
        char charc = chars[i]; 
          while(i+1<n && chars[i] == chars[i+1]){
                i++; 
                count++; 
            }
           if(count == 1){
               chars[j++] = charc;  
           }
        else{
           if(count > 1){
               chars[j++] = charc;  
               String countfreq = count+""; 
               for(int r= 0 ; r<countfreq.length() ; r++){
                   chars[j++] = countfreq.charAt(r); 
               }
             }
          }
          i++; 
        }
        return j;
    }
}