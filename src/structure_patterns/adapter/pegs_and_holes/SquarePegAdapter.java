package structure_patterns.adapter.pegs_and_holes;

public class SquarePegAdapter extends RoundPeg{
    private SquarePeg peg;
    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        double result = Math.sqrt(2 * Math.pow(peg.getWidth(), 2));
        return result;
    }

}
