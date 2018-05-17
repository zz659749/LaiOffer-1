package LaiOffer;

public class Heapify {
    private int size;
    private int[] array;
    private int capacity;

    public Heapify(int[] array) {
        this.capacity = array.length;
        this.array = new int[this.capacity];
        copy(this.array, array, array.length);
        this.size = capacity;
    }
    public Heapify(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[0];
    }

    public void heapify() {
        int index = size / 2 - 1;
        for (int i = index; i >= 0; i--) {
            perculateDown(i);
        }
    }

    public void offer(int value) {
        if (size == capacity) {
            int[] newArray = new int[capacity * 2];
            copy(newArray, array, array.length);
            array = newArray;
            capacity = array.length;
        }
        array[size] = value;
        size++;
        perculateUp(size - 1);
    }

    private void copy(int[] newArray, int[] array, int length) {
        for (int i = 0; i < length; i++) {
            newArray[i] = array[i];
        }

    }

    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int outPut = array[0];
        array[0] = array[size - 1];
        size--;
        perculateDown(0);
        return outPut;
    }

    public int update(int index, int value) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("没这号人");
        }
        int oldValue = array[index];
        array[index] = value;

        if (oldValue > value) {
            perculateUp(index);
        } else if (oldValue < value){
            perculateDown(index);
        }
        return oldValue;
    }

    private void perculateUp(int son) {
        while (son >= 0) {
            int die = (son - 1) / 2;
            if (array[die] > array[son]) {
                swap(array, die, son);
                son = die;
            } else {
                break;
            }
        }
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    private void perculateDown(int index) {

        while (index <= size / 2 - 1) {
            int ls = index * 2 + 1;
            int rs = index * 2 + 2;
            int candidate = ls;
            if (rs < size && array[rs] < array[ls]) {
                candidate = rs;
            }

            if (array[candidate] >= array[index]) {
                break;
            }
            swap(array, candidate, index);
            index = candidate;
        }
    }

    public int[] getArray() {
        return this.array;
    }

}
