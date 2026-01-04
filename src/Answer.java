import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Answer {
    public static void main(String[] args) {
        ArrayList<String> data = getFileData("input_files/" + args[0]); // took from mr das example code, I just realized that the string [] args is for arguments when running the code I might be dumb
        for (String s: data){
            System.out.println(s);
        }
        int rows = data.size();
        int characters = data.get(0).length();

        int currentIndex = data.get(0).indexOf('0'); //starting index since only one zero
        int moves = 0;

        for (int r = 1; r < rows; r++) {
            String row = data.get(r);
            int bestMove = Integer.MAX_VALUE;
            int bestIndex = currentIndex;

            for (int c = 0; c < characters; c++) {
                char character = row.charAt(c);
                if (character == '0' || character == '2') { // when you find a 0 (or 2) need to check the min amount of movements normally and wrapping around
                    //I also realized I can just use indexOf since i only changed it to have one zero but im lazy so not going to
                    int directPath = Math.abs(c - currentIndex); // I was being stupid and at first making a checkleft and checkright like for a advent problem and then realized I could just subtract and use absolute value
                    int wrapPath = characters - directPath;
                    int minDistance = Math.min(directPath, wrapPath);

                    if (minDistance < bestMove) {
                        bestMove = minDistance;
                        bestIndex = c;
                    }
                }
            }

            moves += bestMove;
            currentIndex = bestIndex;

            if (row.charAt(currentIndex) == '2') {
                break;
            }
        }

        System.out.println("Minimum moves: " + moves);
    }
    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }
}

