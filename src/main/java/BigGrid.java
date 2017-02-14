import java.util.ArrayList;
import java.util.HashSet;

class BigGrid {

    SmallGrid TL, TM, TR, ML, MM, MR, BL, BM, BR;
    SmallGrid topHT, topHM, topHB, midHT, midHM, midHB, botHT, botHM, botHB, leftVL, leftVM, leftVR, midVL, midVM, midVR, rightVL, rightVM, rightVR;
    SmallGrid[] contents;
    boolean allGridsValid;


    BigGrid(SmallGrid TL, SmallGrid TM, SmallGrid TR, SmallGrid ML, SmallGrid MM, SmallGrid MR, SmallGrid BL, SmallGrid BM, SmallGrid BR, boolean findGrids) {
        this.TL = TL;
        this.TM = TM;
        this.TR = TR;

        this.ML = ML;
        this.MM = MM;
        this.MR = MR;

        this.BL = BL;
        this.BM = BM;
        this.BR = BR;

        this.topHT = new SmallGrid((TL.topH + TM.topH + TR.topH), "TOP HORIZONTAL TOP", findGrids);
        this.topHM = new SmallGrid((TL.midH + TM.midH + TR.midH), "TOP HORIZONTAL MIDDLE", findGrids);
        this.topHB = new SmallGrid((TL.botH + TM.botH + TR.botH), "TOP HORIZONTAL BOTTOM", findGrids);

        this.midHT = new SmallGrid((ML.topH + MM.topH + MR.topH), "MIDDLE HORIZONTAL TOP", findGrids);
        this.midHM = new SmallGrid((ML.midH + MM.midH + MR.midH), "MIDDLE HORIZONTAL MIDDLE", findGrids);
        this.midHB = new SmallGrid((ML.botH + MM.botH + MR.botH), "MIDDLE HORIZONTAL BOTTOM", findGrids);

        this.botHT = new SmallGrid((BL.topH + BM.topH + BR.topH), "BOTTOM HORIZONTAL TOP", findGrids);
        this.botHM = new SmallGrid((BL.midH + BM.midH + BR.midH), "BOTTOM HORIZONTAL MIDDLE", findGrids);
        this.botHB = new SmallGrid((BL.botH + BM.botH + BR.botH), "BOTTOM HORIZONTAL BOTTOM", findGrids);

        this.leftVL = new SmallGrid((TL.leftV + ML.leftV + BL.leftV), "LEFT VERTICAL LEFT", findGrids);
        this.leftVM = new SmallGrid((TL.midV + ML.midV + BL.midV), "LEFT VERTICAL MIDDLE", findGrids);
        this.leftVR = new SmallGrid((TL.rightV + ML.rightV + BL.rightV), "LEFT VERTICAL RIGHT", findGrids);

        this.midVL = new SmallGrid((TM.leftV + MM.leftV + BM.leftV), "MIDDLE VERTICAL LEFT", findGrids);
        this.midVM = new SmallGrid((TM.midV + MM.midV + BM.midV), "MIDDLE VERTICAL MIDDLE", findGrids);
        this.midVR = new SmallGrid((TM.rightV + MM.rightV + BM.rightV), "MIDDLE VERTICAL RIGHT", findGrids);

        this.rightVL = new SmallGrid((TR.leftV + MR.leftV + BR.leftV), "RIGHT VERTICAL LEFT", findGrids);
        this.rightVM = new SmallGrid((TR.midV + MR.midV + BR.midV), "RIGHT VERTICAL MIDDLE", findGrids);
        this.rightVR = new SmallGrid((TR.rightV + MR.rightV + BR.rightV), "RIGHT VERTICAL RIGHT", findGrids);

        this.contents = new SmallGrid[]{topHT, topHM, topHB, midHT, midHM, midHB, botHT, botHM, botHB, leftVL, leftVM, leftVR, midVL, midVM, midVR, rightVL, rightVM, rightVR};
        this.allGridsValid = checkIfAllVaild(this.contents);
    }

    private boolean checkIfAllVaild(SmallGrid[] contents) {
        boolean isValid = true;
        for(SmallGrid grid : contents) {
            if (!grid.isValid) {
                isValid = false;
            }
        }
        return isValid;
    }

    void trimVerticalTopPossibilities(SmallGrid gridUnderTest, SmallGrid VLgrid, SmallGrid VMgrid, SmallGrid VRgrid){
        System.out.println("Trimming grid " + gridUnderTest.position + " with vertical possibilities, it has " + gridUnderTest.validGrids.size() + " valid grids");
        HashSet<SmallGrid> TMPossibilities = new HashSet<>();
        ArrayList<SmallGrid> TMPossibilitiesArray = new ArrayList<>();
        for(SmallGrid possibile : gridUnderTest.validGrids){
            for(SmallGrid VLGrids : VLgrid.validGrids){
                for(SmallGrid VMGrids : VMgrid.validGrids){
                    for(SmallGrid VRGrids : VRgrid.validGrids) {
                        if (possibile.topH.equals(String.valueOf(VLGrids.TL) + String.valueOf(VMGrids.TL) + String.valueOf(VRGrids.TL))) {
                            if (possibile.midH.equals(String.valueOf(VLGrids.TM) + String.valueOf(VMGrids.TM) + String.valueOf(VRGrids.TM))) {
                                if (possibile.botH.equals(String.valueOf(VLGrids.TR) + String.valueOf(VMGrids.TR) + String.valueOf(VRGrids.TR))) {
                                    TMPossibilities.add(possibile);
                                }
                            }
                        }
                    }
                }
            }
        }
        for(SmallGrid x : TMPossibilities){
            TMPossibilitiesArray.add(x);
        }
        System.out.println(gridUnderTest.position + " now has " + TMPossibilitiesArray.size() + " valid grids\n");
        gridUnderTest.validGrids = TMPossibilitiesArray;
    }
    void trimVerticalMidPossibilities(SmallGrid gridUnderTest, SmallGrid VLgrid, SmallGrid VMgrid, SmallGrid VRgrid){
        System.out.println("Trimming grid " + gridUnderTest.position + " with vertical possibilities, it has " + gridUnderTest.validGrids.size() + " valid grids");
        HashSet<SmallGrid> TMPossibilities = new HashSet<>();
        ArrayList<SmallGrid> TMPossibilitiesArray = new ArrayList<>();
        for(SmallGrid possibile : gridUnderTest.validGrids){
            for(SmallGrid VLGrids : VLgrid.validGrids){
                for(SmallGrid VMGrids : VMgrid.validGrids){
                    for(SmallGrid VRGrids : VRgrid.validGrids) {
                        if (possibile.topH.equals(String.valueOf(VLGrids.ML) + String.valueOf(VMGrids.ML) + String.valueOf(VRGrids.ML))) {
                            if (possibile.midH.equals(String.valueOf(VLGrids.MM) + String.valueOf(VMGrids.MM) + String.valueOf(VRGrids.MM))) {
                                if (possibile.botH.equals(String.valueOf(VLGrids.MR) + String.valueOf(VMGrids.MR) + String.valueOf(VRGrids.MR))) {
                                    TMPossibilities.add(possibile);
                                }
                            }
                        }
                    }
                }
            }
        }
        for(SmallGrid x : TMPossibilities){
            TMPossibilitiesArray.add(x);
        }
        System.out.println(gridUnderTest.position + " now has " + TMPossibilitiesArray.size() + " valid grids\n");
        gridUnderTest.validGrids = TMPossibilitiesArray;
    }
    void trimVerticalBotPossibilities(SmallGrid gridUnderTest, SmallGrid VLgrid, SmallGrid VMgrid, SmallGrid VRgrid){
        System.out.println("Trimming grid " + gridUnderTest.position + " with vertical possibilities, it has " + gridUnderTest.validGrids.size() + " valid grids");
        HashSet<SmallGrid> TMPossibilities = new HashSet<>();
        ArrayList<SmallGrid> TMPossibilitiesArray = new ArrayList<>();
        for(SmallGrid possibile : gridUnderTest.validGrids){
            for(SmallGrid VLGrids : VLgrid.validGrids){
                for(SmallGrid VMGrids : VMgrid.validGrids){
                    for(SmallGrid VRGrids : VRgrid.validGrids) {
                        if (possibile.topH.equals(String.valueOf(VLGrids.BL) + String.valueOf(VMGrids.BL) + String.valueOf(VRGrids.BL))) {
                            if (possibile.midH.equals(String.valueOf(VLGrids.BM) + String.valueOf(VMGrids.BM) + String.valueOf(VRGrids.BM))) {
                                if (possibile.botH.equals(String.valueOf(VLGrids.BR) + String.valueOf(VMGrids.BR) + String.valueOf(VRGrids.BR))) {
                                    TMPossibilities.add(possibile);
                                }
                            }
                        }
                    }
                }
            }
        }
        for(SmallGrid x : TMPossibilities){
            TMPossibilitiesArray.add(x);
        }
        System.out.println(gridUnderTest.position + " now has " + TMPossibilitiesArray.size() + " valid grids\n");
        gridUnderTest.validGrids = TMPossibilitiesArray;
    }

    void trimHorizLeftPossibilities(SmallGrid gridUnderTest, SmallGrid HTgrid, SmallGrid HMgrid, SmallGrid HBGrid){
        System.out.println("Trimming grid " + gridUnderTest.position + " with horizontal possibilities, it has " + gridUnderTest.validGrids.size() + " valid grids");
        HashSet<SmallGrid> TMPossibilities = new HashSet<>();
        ArrayList<SmallGrid> TMPossibilitiesArray = new ArrayList<>();
        for(SmallGrid possibile : gridUnderTest.validGrids){
            for(SmallGrid HTGrids : HTgrid.validGrids){
                for(SmallGrid HMGrids : HMgrid.validGrids){
                    for(SmallGrid HBGrids : HBGrid.validGrids) {
                        if (possibile.topH.equals(String.valueOf(HTGrids.TL) + String.valueOf(HTGrids.TM) + String.valueOf(HTGrids.TR))) {
                            if (possibile.midH.equals(String.valueOf(HMGrids.TL) + String.valueOf(HMGrids.TM) + String.valueOf(HMGrids.TR))) {
                                if (possibile.botH.equals(String.valueOf(HBGrids.TL) + String.valueOf(HBGrids.TM) + String.valueOf(HBGrids.TR))) {
                                    TMPossibilities.add(possibile);
                                }
                            }
                        }
                    }
                }
            }
        }
        for(SmallGrid x : TMPossibilities){
            TMPossibilitiesArray.add(x);
        }
        System.out.println(gridUnderTest.position + " now has " + TMPossibilitiesArray.size() + " valid grids\n");
        gridUnderTest.validGrids = TMPossibilitiesArray;
    }
    void trimHorizMidPossibilities(SmallGrid gridUnderTest, SmallGrid HTgrid, SmallGrid HMgrid, SmallGrid HBgrid){
        System.out.println("Trimming grid " + gridUnderTest.position + " with horizontal possibilities, it has " + gridUnderTest.validGrids.size() + " valid grids");
        HashSet<SmallGrid> TMPossibilities = new HashSet<>();
        ArrayList<SmallGrid> TMPossibilitiesArray = new ArrayList<>();
        for(SmallGrid possibile : gridUnderTest.validGrids){
            for(SmallGrid HTGrids : HTgrid.validGrids){
                for(SmallGrid HMGrids : HMgrid.validGrids){
                    for(SmallGrid HBGrids : HBgrid.validGrids) {
                        if (possibile.topH.equals(String.valueOf(HTGrids.ML) + String.valueOf(HTGrids.MM) + String.valueOf(HTGrids.MR))) {
                            if (possibile.midH.equals(String.valueOf(HMGrids.ML) + String.valueOf(HMGrids.MM) + String.valueOf(HMGrids.MR))) {
                                if (possibile.botH.equals(String.valueOf(HBGrids.ML) + String.valueOf(HBGrids.MM) + String.valueOf(HBGrids.MR))) {
                                    TMPossibilities.add(possibile);
                                }
                            }
                        }
                    }
                }
            }
        }
        for(SmallGrid x : TMPossibilities){
            TMPossibilitiesArray.add(x);
        }
        System.out.println(gridUnderTest.position + " now has " + TMPossibilitiesArray.size() + " valid grids\n");
        gridUnderTest.validGrids = TMPossibilitiesArray;
    }
    void trimHorizRightPossibilities(SmallGrid gridUnderTest, SmallGrid HTgrid, SmallGrid HMgrid, SmallGrid HBgrid){
        System.out.println("Trimming grid " + gridUnderTest.position + " with horizontal possibilities, it has " + gridUnderTest.validGrids.size() + " valid grids");
        HashSet<SmallGrid> TMPossibilities = new HashSet<>();
        ArrayList<SmallGrid> TMPossibilitiesArray = new ArrayList<>();
        for(SmallGrid possibile : gridUnderTest.validGrids){
            for(SmallGrid HTGrids : HTgrid.validGrids){
                for(SmallGrid HMGrids : HMgrid.validGrids){
                    for(SmallGrid HBGrids : HBgrid.validGrids) {
                        if (possibile.topH.equals(String.valueOf(HTGrids.BL) + String.valueOf(HTGrids.BM) + String.valueOf(HTGrids.BR))) {
                            if (possibile.midH.equals(String.valueOf(HMGrids.BL) + String.valueOf(HMGrids.BM) + String.valueOf(HMGrids.BR))) {
                                if (possibile.botH.equals(String.valueOf(HBGrids.BL) + String.valueOf(HBGrids.BM) + String.valueOf(HBGrids.BR))) {
                                    TMPossibilities.add(possibile);
                                }
                            }
                        }
                    }
                }
            }
        }
        for(SmallGrid x : TMPossibilities){
            TMPossibilitiesArray.add(x);
        }
        System.out.println(gridUnderTest.position + " now has " + TMPossibilitiesArray.size() + " valid grids\n");
        gridUnderTest.validGrids = TMPossibilitiesArray;
    }

    static void solveGame(BigGrid game){
        System.out.println("Solving Game!");
        for(SmallGrid TL : game.TL.validGrids){
            for(SmallGrid TM : game.TM.validGrids){
                for(SmallGrid TR : game.TR.validGrids){
                    for(SmallGrid ML : game.ML.validGrids){
                        for(SmallGrid MM : game.MM.validGrids){
                            for(SmallGrid MR : game.MR.validGrids){
                                for(SmallGrid BL : game.BL.validGrids){
                                    for(SmallGrid BM : game.BM.validGrids){
                                        for (SmallGrid BR : game.BR.validGrids){
                                            BigGrid possibleSolution = new BigGrid(TL, TM, TR, ML, MM, MR, BL, BM, BR, false);
                                            if(possibleSolution.allGridsValid){
                                                IOTools.prettyPrint(possibleSolution);
                                                System.exit(0);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
