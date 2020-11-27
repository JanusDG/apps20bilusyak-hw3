package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {

    private final Object[] array;

    public BaseArray(Object[] numbers) {
        this.array = numbers.clone();
    }

    @Override
    public Object[] toArray() {
        return this.array.clone();
    }

    @Override
    public String operationDescription() {
        return "Basic Array instance";
    }

    @Override
    public int size() {
        return this.array.length;
    }
}
