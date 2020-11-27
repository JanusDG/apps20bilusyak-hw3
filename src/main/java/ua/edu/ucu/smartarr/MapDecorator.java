package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    public MapDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);

        Object[] arr = this.smartArray.toArray();
        int i = 0;
        for (; i<arr.length; i++){
            arr[i] = function.apply(arr[i]);
        }
        this.smartArray = new BaseArray(arr);
    }

    @Override
    public String operationDescription() {
        return "Map every element to another object using MyFunction";
    }

}
