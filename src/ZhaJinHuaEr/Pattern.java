package ZhaJinHuaEr;

public class Pattern {

    private final boolean cube;
    private final boolean sameSuit;
    private final boolean sequence;
    private final boolean square;

    Pattern(boolean cube, boolean sameSuit, boolean sequence, boolean square) {
        this.cube = cube;
        this.sameSuit = sameSuit;
        this.sequence = sequence;
        this.square = square;
    }

    public boolean isBaoZii() {
        return cube;
    }

    public boolean isTongHuaShun() {
        return sameSuit && sequence;
    }

    public boolean isJinHua() {
        return sameSuit;
    }

    public boolean isShunZi() {
        return sequence;
    }
    public boolean isDuiEr() {
        return square;
    }
}
