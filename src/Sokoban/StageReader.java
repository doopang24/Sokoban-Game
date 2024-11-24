package Sokoban;

public class StageReader {

    public String receiveStage() {
        String input = """
                Stage 2
                  #######
                ###  O  ###
                #    o    #
                # Oo P oO #
                ###  o  ###
                 #   O  #\s
                 ########
                """;
        return input;
    }
}
