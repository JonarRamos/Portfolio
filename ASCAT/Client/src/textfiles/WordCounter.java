package textfiles;

public class WordCounter {

    public static int countCapitals(String word) {        
        int CC = 1;
        for(int i=word.length()-1; i>=0; i--) {     
            if(Character.isUpperCase(word.charAt(i))){
                if (i == 0) {
                }
                else if (i == word.length()){
                    if (Character.isUpperCase(word.charAt(i - 1))){
                        CC++;
                        }
                }
                else
                    if ((Character.isLowerCase(word.charAt(i + 1)))||(Character.isLowerCase(word.charAt(i - 1)))) {
                        CC++;
                        }
                }
            }
        return CC;
        }
    }



