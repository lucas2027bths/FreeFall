import java.util.ArrayList;
import java.util.Objects;

public class Generator {
    public ArrayList<String> createFile(){
        int length = randomNum(4,4);
        int height = randomNum(1,1);

        String firstInst = "";
        int ranIndx = randomNum(0,length);
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
        ranIndx = randomNum(0,length);
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
            currentLine += Objects.toString(randomNum(0,1));
        }
        if (!currentLine.contains("0")){
            int randomNum = randomNum(0,length-1);
            currentLine = currentLine.substring(0,randomNum) + "0" + currentLine.substring(randomNum+1);
        }
        return currentLine;
    }
}
