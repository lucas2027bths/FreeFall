import java.util.ArrayList;
import java.util.Objects;

public class Generator {
    public ArrayList<String> createFile(){
        int length = randomNum(5,10);
        int height = randomNum(100,200);
        System.out.println("The length is " + length);
        ArrayList<String> tempFile = new ArrayList<>();
        for (int x = 0; x < height; x++){
            tempFile.add(randomSequence(length));
        }
        for (String s : tempFile){
            System.out.println(s);
        }
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
