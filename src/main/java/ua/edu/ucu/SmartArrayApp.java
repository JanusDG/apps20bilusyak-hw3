package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new DistinctDecorator(sa); // Result: [-1, 2, 0, 1, -5, 3];
        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        SmartArray studentSmartArray = new BaseArray(students);

        MyPredicate yearPredicat = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getYear() == 2;
            }
        };

        MyPredicate gradePredicat = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getGPA() >= 4;
            }
        };

        MyComparator alphaComparator = new MyComparator() {
            @Override
            public int compare(Object st1, Object st2)
            {
                String str1 = ((Student)st1).getSurname();
                String str2 = ((Student)st2).getSurname();

                int lenStr1 = str1.length();
                int lenStr2 = str2.length();

                int min_len = Math.min(lenStr1, lenStr2);

                for (int i = 0; i < min_len; i++) {
                    int charStr1 = str1.charAt(i);
                    int charStr2 = str2.charAt(i);

                    if (charStr1 != charStr2) {return charStr1 - charStr2;}
                }

                if (lenStr1 != lenStr2) {
                    return lenStr1 - lenStr2;
                }else {return 0;}
            }
        };

        studentSmartArray = new DistinctDecorator(studentSmartArray);
        studentSmartArray = new FilterDecorator(studentSmartArray, yearPredicat);
        studentSmartArray = new FilterDecorator(studentSmartArray, gradePredicat);
        studentSmartArray = new SortDecorator(studentSmartArray, alphaComparator);



        // Hint: to convert Object[] to String[] - use the following code
        Object[] result = studentSmartArray.toArray();
        for(int i = 0; i< result.length; i++){
            result[i] = ((Student)result[i]).getSurname() +" "+ ((Student)result[i]).getName();
        }
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
