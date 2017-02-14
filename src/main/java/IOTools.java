import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IOTools {

    ArrayList<String> getFile(String fileName) {

        ArrayList<String> newList = new ArrayList<>();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                newList.add(scanner.nextLine());
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return newList;

    }


    static void prettyPrint(BigGrid game){
        int counter = 0;
        for(SmallGrid x : game.contents) {
            if (x.position.contains("HORIZONTAL")) {
                if (counter % 3 == 0) {
                    System.out.println("_______________________________");
                }
                System.out.println(prettyLine(x.contents));
                counter++;
            }
        }
        System.out.println("_______________________________");
    }
    static private String prettyLine(ArrayList<Integer> lines){
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        int counter = 0;
        for(Integer x : lines){
            if(counter == 2 || counter == 5 || counter == 8){
                sb.append(" ").append(x).append(" |");
            }else {
                sb.append(" ").append(x).append(" ");
            }
            counter++;
        }
        return sb.toString();
    }

}



