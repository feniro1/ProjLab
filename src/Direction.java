/**
 * Az iranyok tarolasa egy enum-ban a konnyebb es egyertelmubb navigalas miatt
 */
public enum Direction {

    Up(0),
    Right(1),
    Down(2),
    Left(3);

    //Ertek szerint is taroljuk
    private final int value;
    private Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toHungarian (){
        switch(value){
            case 0: return "felfele";
            case 1: return "jobbra";
            case 2: return "lefele";
            case 3: return "balra";
        }
        return "";
    }

    //Visszafele is haladhatunk rajtuk
    public Direction reverse(){
        switch(value){
            case 0: return Down;
            case 1: return Left;
            case 2: return Up;
            case 3: return Right;
            default:
                    break;
        }
        return this;
    }
}