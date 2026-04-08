class Solution {
    public int compress(char[] chars) {
        int sIndex = 0;
        int repeatingCharacterTime = 0;
        char currentRepeatingCharater = ' ';

        for(int i = 0; i < chars.length; i++){
            if(currentRepeatingCharater == chars[i]){
                repeatingCharacterTime++;
            }else{
                if(currentRepeatingCharater != ' '){
                    chars[sIndex] = currentRepeatingCharater;
                    sIndex++;
                }
                if(repeatingCharacterTime > 1){
                    String repeating = Integer.toString(repeatingCharacterTime);
                    int j = 0;
                    while(j < repeating.length()){
                        chars[sIndex] = repeating.charAt(j);
                        j++;
                        sIndex++;
                    }
                }
                currentRepeatingCharater = chars[i];
                repeatingCharacterTime = 1;
            }
        }

        if(currentRepeatingCharater != ' '){
            chars[sIndex] = currentRepeatingCharater;
            sIndex++;
        }
        if(repeatingCharacterTime > 1){
            String repeating = Integer.toString(repeatingCharacterTime);
            int j = 0;
            while(j < repeating.length()){
                chars[sIndex] = repeating.charAt(j);
                j++;
                sIndex++;
            }
        }
        return sIndex; 
    }
}