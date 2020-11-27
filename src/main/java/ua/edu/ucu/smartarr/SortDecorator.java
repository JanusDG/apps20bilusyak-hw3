package ua.edu.ucu.smartarr;

import ua.edu.ucu.SmartArrayApp;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyPredicate;

import java.lang.reflect.Array;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator comparator;

    public SortDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public String operationDescription() {
        return "Sorts elements using MyComparator to compare them";
    }

    public SortDecorator(SmartArray smartArray, MyComparator comparator){
        super(smartArray);
        this.comparator = comparator;

        Object[] arr = this.smartArray.toArray();
        Arrays.sort(arr,comparator);
        this.smartArray = new BaseArray(arr);
    }
}
