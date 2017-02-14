import java.io.IOException;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws IOException {

        IOTools iOTools = new IOTools();

        ArrayList<String> input = iOTools.getFile("Input.txt");


        SmallGrid TL = new SmallGrid(input.get(0),"Top Left", true);
        SmallGrid TM = new SmallGrid(input.get(1),"Top Middle", true);
        SmallGrid TR = new SmallGrid(input.get(2),"Top Right", true);

        SmallGrid ML = new SmallGrid(input.get(3),"Middle Left", true);
        SmallGrid MM = new SmallGrid(input.get(4),"Middle Middle", true);
        SmallGrid MR = new SmallGrid(input.get(5),"Middle Right", true);

        SmallGrid BL = new SmallGrid(input.get(6),"Bottom Left", true);
        SmallGrid BM = new SmallGrid(input.get(7),"Bottom Middle", true);
        SmallGrid BR = new SmallGrid(input.get(8),"Bottom Right", true);

        BigGrid game = new BigGrid(TL, TM, TR, ML, MM, MR, BL, BM, BR, true);

        game.trimVerticalTopPossibilities(game.TL, game.leftVL, game.leftVM, game.leftVR);
        game.trimVerticalTopPossibilities(game.TM, game.midVL, game.midVM, game.midVR);
        game.trimVerticalTopPossibilities(game.TR, game.rightVL, game.rightVM, game.rightVR);

        game.trimVerticalMidPossibilities(game.ML, game.leftVL, game.leftVM, game.leftVR);
        game.trimVerticalMidPossibilities(game.MM, game.midVL, game.midVM, game.midVR);
        game.trimVerticalMidPossibilities(game.MR, game.rightVL, game.rightVM, game.rightVR);

        game.trimVerticalBotPossibilities(game.BL, game.leftVL, game.leftVM, game.leftVR);
        game.trimVerticalBotPossibilities(game.BM, game.midVL, game.midVM, game.midVR);
        game.trimVerticalBotPossibilities(game.BR, game.rightVL, game.rightVM, game.rightVR);

        game.trimHorizLeftPossibilities(game.TL, game.topHT, game.topHM, game.topHB);
        game.trimHorizLeftPossibilities(game.ML, game.midHT, game.midHM, game.midHB);
        game.trimHorizLeftPossibilities(game.BL, game.botHT, game.botHM, game.botHB);

        game.trimHorizMidPossibilities(game.TM, game.topHT, game.topHM, game.topHB);
        game.trimHorizMidPossibilities(game.MM, game.midHT, game.midHM, game.midHB);
        game.trimHorizMidPossibilities(game.BM, game.botHT, game.botHM, game.botHB);

        game.trimHorizRightPossibilities(game.TR, game.topHT, game.topHM, game.topHB);
        game.trimHorizRightPossibilities(game.MR, game.midHT, game.midHM, game.midHB);
        game.trimHorizRightPossibilities(game.BR, game.botHT, game.botHM, game.botHB);


        BigGrid.solveGame(game);
    }
}
