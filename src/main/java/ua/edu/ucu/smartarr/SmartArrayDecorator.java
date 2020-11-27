package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {
    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = this.smartArray.toArray();
        int i = 0;
        for (Object obj: arr){
            if (obj != null){
                i ++;
            }
        }
        Object[] newArr = new Object[i];
        int j = 0;
        i = 0;
        for (Object obj: arr){
            if (obj != null){
                newArr[j] = arr[i];
                j++;
            }
            i ++;
        }
        return newArr;
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
