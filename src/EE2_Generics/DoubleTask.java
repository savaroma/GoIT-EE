package EE2_Generics;

public class DoubleTask implements Task<Double> {
    private Double value;
    private Double result;

    public DoubleTask(Double value) {
        this.value = value;
    }

    @Override
    public void execute() {
        String s = value.toString();
        int lastNumberAfterPoint = s.charAt(s.length() - 1) - '0';
        if (lastNumberAfterPoint % 2 == 1) {
            result = 1.0;
        } else {
            result = 0.0;
        }
    }

    @Override
    public Double getResult() {
        return result;
    }

    @Override
    public Double getValue() {
        return value;
    }
}