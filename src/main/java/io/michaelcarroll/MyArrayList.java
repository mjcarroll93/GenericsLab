package io.michaelcarroll;


public class MyArrayList<T> {

    T[] arr;
    int nextIndex = 0;
    int maxSize;


    MyArrayList() {
        arr = (T[]) new Object[10];
        this.maxSize = 10;
    }

    MyArrayList(int initialSize) {
        arr = (T[]) new Object[initialSize];
        this.maxSize = initialSize;
    }

    public void add(T elementToAdd) {
        if(doesArrayNeedToBeResized()){
            resizeArray();
        }
        arr[nextIndex] = elementToAdd;
        nextIndex++;
    }

    public void add(int index, T elementToAdd) {
        shiftIndicesToRightHandler(index);
        arr[index] = elementToAdd;
    }

    public T get(int index) {
        return arr[index];
    }

    public void remove(int indexToRemove) {
        shiftIndicesToLeft(indexToRemove);
    }

    public void set(int index, T elementToAdd) {
        arr[index] = elementToAdd;
    }

    public boolean isEmpty() {
        boolean empty = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null)
                empty = false;
        }
        return empty;
    }

    public boolean contains(T element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    private void resizeArray() {
        T[] tempArr = arr;
        maxSize *= 2;
        arr = (T[]) new Object[maxSize];
        for (int i = 0; i < tempArr.length; i++) {
            arr[i] = tempArr[i];
        }
    }

    private boolean doesArrayNeedToBeResized() {
        if (arr.length == nextIndex)
            return true;
        else
            return false;
    }

    public void shiftIndicesToRightHandler(int index) {
        if (arr[maxSize - 1] == null) {
            shiftIndicesToRight(index);
        } else {
            resizeArray();
            shiftIndicesToRight(index);
        }
    }

    public void shiftIndicesToLeft(int index) {
        for (int i = index; i < arr.length - 2; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public void shiftIndicesToRight(int index) {

        for (int i = arr.length - 2; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
    }

    public int size(){
        return arr.length;
    }
}


