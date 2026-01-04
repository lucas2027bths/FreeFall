import java.util.ArrayList;
import java.util.Objects;

public class Generator {
    public ArrayList<String> createFile(){
        int length = randomNum(10,20);
        int height = randomNum(10,20);
        //changed problem to have only 1 zero / two per line since having multiple zeros was a lot harder and was the same as a advent problem I couldn't solve (also its just hard in general)
        String firstInst = ""; //this was when I still had multiple zeros for the other lines before, so I could just reuse randomsequence now but i dont feel like it
        int ranIndx = randomNum(0,length-1);
        for (int i = 0; i < length; i++){
            if (i == ranIndx){
                firstInst+= "0";
            }else{
                firstInst += "1";
            }
        }

        ArrayList<String> tempFile = new ArrayList<>();
        tempFile.addFirst(firstInst);
        for (int x = 0; x < height; x++){
            tempFile.add(randomSequence(length));
        }

        firstInst = "";
        ranIndx = randomNum(0,length-1);
        for (int i = 0; i < length; i++){
            if (i == ranIndx){
                firstInst+= "2";
            }else{
                firstInst += "1";
            }
        }

        tempFile.add(firstInst);
        return tempFile;
    }

    public int randomNum(int min, int max){
        return (int) (Math.random() * ((max-min) + 1) + min);
    }

    public String randomSequence(int length){
        String currentLine = "";
        for (int j = 0;j < length;j++){
            currentLine += "1";
        }
            int randomNum = randomNum(0,length-1);
            currentLine = currentLine.substring(0,randomNum) + "0" + currentLine.substring(randomNum+1);
        return currentLine;
    }
}
