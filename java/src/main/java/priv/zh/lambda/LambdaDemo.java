package priv.zh.lambda;

public class LambdaDemo {

    public void exec(){
        MathOperation<Integer> operationIntAdd=(a,b)->a+b;
        MathOperation<Double> operationIntSub=(a,b)->a-b;
        System.out.printf("add method invoke result is %d\n",operationIntAdd.operate(1,2));
        System.out.printf("sub method invoke result is %f\n",operationIntSub.operate(1.,2.));
    }
    private interface MathOperation<T>{
        T operate(T value1,T value2);
    }
}
