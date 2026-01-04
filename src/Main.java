import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator();
        ArrayList<String> data = generator.createFile();
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
}
