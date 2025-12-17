import java.util.ArrayList;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator();
        ArrayList<String> data = generator.createFile();

        int startIndex = data.getFirst().indexOf("0");
        System.out.println(data.getFirst());
        for (int x = 1; x < data.size(); x++){
            String currentInstruction = data.get(x);
            System.out.println(currentInstruction);
            System.out.println(checkRight(startIndex,currentInstruction));
        }

    }
    public static int checkRight(int indx,String currentInst){
        int movements = 0;
        int length = currentInst.length();
        for (int j = indx+1; j < length ; j++){
            if (currentInst.charAt(j) == '0'){
                break;
            }
            movements++;
        }
        System.out.println("MOVEMENT IS " + movements);
        int newMovement = length-indx;
        for (int j = 0; j < length;j++){
            newMovement ++;
            if (currentInst.charAt(j) == '0'){
                newMovement--;
                break;
            }
        }
        System.out.println("TRUMAN WATCHES " +newMovement);
        return Math.min(movements,newMovement);
    }

}