
/**
 * 
 */
public enum Direction {

    Up(0),
    Right(1),
    Down(2),
    Left(3);

    private final int value;
    private Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

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