package ua.edu.ucu.smartarr;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);

        Object[] arr = this.smartArray.toArray();
        int i = 0;
        for (; i< arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                Object dObj1 = arr[i];
                Object dObj2 = arr[j];
                if (dObj1 == null || dObj2== null){continue; }
                if (dObj1.equals(dObj2)) {
                    arr[j] = null;
                }
            }
        }
        this.smartArray = new BaseArray(arr);
    }

    @Override
    public String operationDescription() {
        return "Remove duplicates from SmartArray." +
                " Use method equals() to compare objects";
    }

}
