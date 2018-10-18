package Interface;

import java.util.ArrayList;

public class Saveable implements ISaveable{
    private ArrayList<String> myArrayList;
    private int index;

    public Saveable() {
        myArrayList = new ArrayList<>();
        index = 0;
    }

    @Override
    public void inputDataToArrayList(String data) {
        myArrayList.add(index,data);
        index++;
    }

    @Override
    public void printDataFromArrayList() {
        if(index > 0) {
            for(int i = 0; i < index; i++) {
                System.out.println((i+1) + ". -> " + myArrayList.get(i));
            }
        }
        else {
            System.out.println("The array list is empty!");
        }
    }

    @Override
    public String toString() {
        String returnData = "";
        if(index > 0) {
            for(int i = 0; i < index; i++) {
                returnData = returnData + " " + myArrayList.get(i);
            }
        }
        else {
            System.out.println("The array list is empty!");
        }
        return returnData;
    }
}