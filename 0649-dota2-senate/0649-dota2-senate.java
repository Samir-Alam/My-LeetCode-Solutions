class Solution {
    public boolean ban(StringBuilder senateArray, char toBan, int startAt) {
        boolean loopAround = false;
        int pointer = startAt;
        while (true) {
            if (pointer == 0)
                loopAround = true;
            if (senateArray.charAt(pointer) == toBan) {
                senateArray.deleteCharAt(pointer);
                break;
            }
            pointer = (pointer + 1) % senateArray.length();
        }
        return loopAround;
    }
    public String predictPartyVictory(String senate) {
        // StringBuilder senateArray = new StringBuilder(senate);
        // int rCount = 0;
        // int dCount = 0;
        // for (int i = 0; i < senateArray.length(); i++) {
        //     if (senateArray.charAt(i) == 'R')
        //         rCount++;
        //     else
        //         dCount++;
        // }
        // int turn = 0;
        // while (rCount > 0 && dCount > 0) {
        //     if (senateArray.charAt(turn) == 'R') {
        //         boolean bannedSenatorBefore = ban(senateArray, 'D', (turn + 1) % senateArray.length());
        //         if (bannedSenatorBefore)
        //             turn--;
        //         dCount--;
        //     } else {
        //         boolean bannedSenatorBefore = ban(senateArray, 'R', (turn + 1) % senateArray.length());
        //         if (bannedSenatorBefore)
        //             turn--;
        //         rCount--;
        //     }
        //     turn = (turn + 1) % senateArray.length();
        // }
        // if (rCount > 0)
        //     return "Radiant";
        // else
        //     return "Dire";
        
        int senateLen = senate.length();
        boolean[] isBanned = new boolean[senateLen];

        int noRadiant = 0;
        int noDire = 0;

        for(char c: senate.toCharArray()){
            if(c == 'R'){
                noRadiant ++;
            }
            if(c == 'D'){
                noDire ++;
            }
        }

        return hasWon(noRadiant, noDire, 0, senate, isBanned);
    }
    public String hasWon(int noRadiant, int noDire, int index, String senate, boolean[] isBanned){
        if(noRadiant == 0){
            return "Dire";
        }
        if(noDire == 0){
            return "Radiant";
        }
        

        if(isBanned[index] == true){
            return hasWon(noRadiant, noDire, (index + 1) % senate.length(), senate, isBanned);
        }

        char currentCharacter = senate.charAt(index);
        if(currentCharacter == 'R'){
            for(int i = 1; i < senate.length(); i++){
                int nextLoc = (index + i) % senate.length();
                if(senate.charAt(nextLoc) == 'D' && isBanned[nextLoc] == false){
                    noDire --;
                    isBanned[nextLoc] = true;
                    break;
                }
            }
            return hasWon(noRadiant, noDire, (index+1) % senate.length(), senate, isBanned);
        }

        if(currentCharacter == 'D'){
            for(int i = 1; i < senate.length(); i++){
                int nextLoc = (index + i) % senate.length();
                if(senate.charAt(nextLoc) == 'R' && isBanned[nextLoc] == false){
                    noRadiant --;
                    isBanned[nextLoc] = true;
                    break;
                }
            }
            return hasWon(noRadiant, noDire, (index+1) % senate.length(), senate, isBanned);
        }
        
        return "";
    }
}