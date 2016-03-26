
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
                    break;
            case 1: return Left;
                    break;
            case 2: return Up;
                    break;
            case 3: return Right;
                    break;
            default:
                    break;
        }
    }
}