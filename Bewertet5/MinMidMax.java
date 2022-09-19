package student;

import java.util.ArrayList;

public class MinMidMax<T extends Comparable<T>> {

    private ArrayList<T> objects = new ArrayList<>();

    private ArrayList<ListObserver> listObservers = new ArrayList();

    public MinMidMax(T... retrievedObjects){

        for (int i = 0; i < retrievedObjects.length; i++){
            push(retrievedObjects[i]);
        }
    }

    public int getNumItems(){

        return objects.size();
    }

    public boolean push(T retrievedObject){
        if (objects.isEmpty()){
            objects.add(retrievedObject);

            for (ListObserver listObserver:listObservers) {
                listObserver.pushedToList(this, retrievedObject);
            }

            return true;
        }
        for (int i = 0; i< getNumItems(); i++ ) {

            if (retrievedObject.compareTo(objects.get(i)) == 0){
                return false;
            }
            if (retrievedObject.compareTo(objects.get(i)) < 0) {
                objects.add(i, retrievedObject);

                for (ListObserver listObserver:listObservers) {
                    listObserver.pushedToList(this, retrievedObject);
                }

                return true;
            }
        }

        objects.add(retrievedObject);
        for (ListObserver listObserver:listObservers) {
            listObserver.pushedToList(this, retrievedObject );
        }
        return true;
    }

    public String toString(){
        String result = "";
        StringBuilder builder = new StringBuilder(result);
        builder.append("[");
        for(int i = 0; i < objects.size(); i++){
            builder.append(objects.get(i));
            builder.append(" ");

        }
        if(objects.isEmpty()){
            return "[]";
        }
        builder.deleteCharAt(builder.length() -1);
        builder.append("]");
        return builder.toString();
    }

    public T popRight(){
        if (objects.isEmpty()){
            return null;
        }
        T lastObject = objects.get(objects.size() -1 );
        objects.remove(objects.size() -1);
        for (ListObserver listObserver:listObservers) {
            listObserver.poppedFromList(this, lastObject);
        }


        return lastObject;
    }

    public T popLeft(){
        if (objects.isEmpty()){
            return null;
        }
        T firstObject = objects.get(0);
        objects.remove(0);
        for (ListObserver listObserver:listObservers) {
            listObserver.poppedFromList(this, firstObject);
        }


        return firstObject;
    }

    public T getMinimum(){
        if (objects.isEmpty()){
            return null;
        }
        return objects.get(0);
    }

    public T getMaximum(){
        if (objects.isEmpty()){
            return null;
        }
        return objects.get(objects.size() -1);
    }

    public T getMid(){
        if (objects.isEmpty()){
            return null;
        }
        return objects.get(objects.size() / 2);
    }

    public void addObserver(ListObserver add){
        listObservers.add(add);
    }
    public void removeObserver(ListObserver remove){
        listObservers.remove(remove);
    }
}



