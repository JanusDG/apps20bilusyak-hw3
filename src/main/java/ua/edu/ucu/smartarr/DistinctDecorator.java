package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);

        Object[] arr = this.smartArray.toArray();
        int i = 0;
        for (;i< arr.length;i++){
            for(int j = i + 1; j < arr.length; j++){
                Object d1 = arr[i];
                Object d2 = arr[j];
                if (d1 == null || d2== null){continue;}
                if (d1.equals(d2)){
                    arr[j] = null;
                }
            }
        }
        this.smartArray = new BaseArray(arr);
    }

    @Override
    public String operationDescription() {
        return "Remove duplicates from SmartArray. Use method equals() to compare objects";
    }

}
