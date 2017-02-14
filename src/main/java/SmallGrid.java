import java.util.ArrayList;
import java.util.Arrays;

public class SmallGrid {

    IOTools ioTools = new IOTools();

    int BL, MR, MM, ML, TR, TL, TM, BM, BR;
    private ArrayList<int[]> immutableIndexs;
    String topH, midH, botH, leftV, midV, rightV, position;
    ArrayList<Integer> contents;
    boolean isValid;
    ArrayList<SmallGrid> validGrids;

    SmallGrid(String textInput, String position, boolean findGrids) {
        this.position = position;
        this.TL = Integer.parseInt(textInput.split("")[0]);
        this.TM = Integer.parseInt(textInput.split("")[1]);
        this.TR = Integer.parseInt(textInput.split("")[2]);
        this.ML = Integer.parseInt(textInput.split("")[3]);
        this.MM = Integer.parseInt(textInput.split("")[4]);
        this.MR = Integer.parseInt(textInput.split("")[5]);
        this.BL = Integer.parseInt(textInput.split("")[6]);
        this.BM = Integer.parseInt(textInput.split("")[7]);
        this.BR = Integer.parseInt(textInput.split("")[8]);
        this.topH = "" + this.TL + this.TM + this.TR;
        this.midH = "" + this.ML + this.MM + this.MR;
        this.botH = "" + this.BL + this.BM + this.BR;
        this.leftV = "" + this.TL + this.ML + this.BL;
        this.midV = "" + this.TM + this.MM + this.BM;
        this.rightV = "" + this.TR + this.MR + this.BR;
        this.contents = new ArrayList<>(Arrays.asList(this.TL, this.TM, this.TR, this.ML, this.MM, this.MR, this.BL, this.BM, this.BR));
        this.isValid = checkifValid(this.contents);
        this.immutableIndexs = findImmutableIndexs(this.contents);
        if(findGrids) {
            this.validGrids = findGridPossibles(this);
        }

    }

    ArrayList<SmallGrid> findGridPossibles(SmallGrid gameGrid) {
        ArrayList<SmallGrid> possiblesList = new ArrayList<>();
        int goal = gameGrid.immutableIndexs.size();
        int counter = 0;
        for(String possibleGrid : ioTools.getFile("AllValid.txt")){
            counter = 0;
            SmallGrid grid = new SmallGrid(possibleGrid, "", false);
            for(int[] immutableIndex : gameGrid.immutableIndexs){
                if (immutableIndex[0] == grid.contents.get(immutableIndex[1])){
                    counter++;
                }
            }
            if(counter == goal){
                possiblesList.add(grid);
            }
        }
        System.out.println("Number of Grid possibles for " + gameGrid.position + " is " + possiblesList.size());
        return possiblesList;
    }


    boolean checkifValid(ArrayList<Integer> contents) {
        boolean isValid = true;
        for(int x = 1; x < 10; x++) {
            if (!contents.contains(x)) {
                isValid = false;
            }
        }
        return isValid;
    }

    ArrayList<int[]> findImmutableIndexs(ArrayList<Integer> contents){
        ArrayList<int[]> listOfIndexValues = new ArrayList<>();
        for(int index = 0; index < 9; index++) {
            if (contents.get(index) != 0) {
                listOfIndexValues.add(new int[]{contents.get(index), index});
            }
        }
        return listOfIndexValues;
    }
}
