package ua.edu.ucu.apps.lab7.flowers;

public enum FlowerColor {
    /**
     * Flower colors.
     */
    RED("#FF0000"),
    BLUE("#7BB2D9"),
    YELLOW("#F5CB5C"),
    PINK("#D65780"),
    PURPLE("#7F557D"),
    WHITE("FFFFFF");
    private final String stringRepresentation;

    FlowerColor(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }
}
