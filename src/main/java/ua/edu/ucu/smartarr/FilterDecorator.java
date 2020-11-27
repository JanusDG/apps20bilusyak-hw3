package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
    private MyPredicate predicat;

    public FilterDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public String operationDescription() {
        return "Tests every element and removes it if it doesn't satisfy MyPredicate";
    }

    public FilterDecorator(SmartArray smartArray, MyPredicate predicat){
        super(smartArray);
        this.predicat = predicat;

        Object[] arr = this.smartArray.toArray();
        int i = 0;
        for (Object obj: arr){
            if (!predicat.test(obj)){
                arr[i] = null;
            }
            i++;

        }
        this.smartArray = new BaseArray(arr);
    }

}
