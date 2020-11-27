package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    public SortDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        super(smartArray);

        Object[] arr = this.smartArray.toArray();
        Arrays.sort(arr, comparator);
        this.smartArray = new BaseArray(arr);
    }

    @Override
    public String operationDescription() {
        return "Sorts elements using MyComparator to compare them";
    }

}
