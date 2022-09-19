package student;

import java.util.ArrayList;


public class MinMidMax<T extends Comparable<T>>
{
    private ArrayList<T> store = new ArrayList<>();
    private ArrayList<ListObserver> listObservers = new ArrayList();

    @SafeVarargs
    public MinMidMax(T... names) {
        for (int i = 0; i < names.length; i++) {
            push(names[i]);
        }
    }

    public int getNumItems(){
        return store.size();
    }

    public boolean push(T names){
        if (store.isEmpty()){
            store.add(names);
            for (ListObserver listObserver:listObservers) {
                listObserver.pushedToList(this, names);
            }
            return true;
        }
        for (int i = 0; i < getNumItems(); i++ ) {

            if (names.compareTo(store.get(i)) == 0){
                return false;
            }
            if (names.compareTo(store.get(i)) < 0) {
                store.add(i, names);

                for (ListObserver listObserver:listObservers) {
                    listObserver.pushedToList(this, names);
                }
                return true;
            }
        }
        store.add(names);
        for (ListObserver listObserver:listObservers) {
            listObserver.pushedToList(this, names);
        }
        return true;
    }

    public T popRight(){
        if(store.isEmpty())
        {
            return null;
        }
        T end = store.get(store.size() -1);
        store.remove(store.size() -1);
        for (ListObserver listObserver:listObservers) {
            listObserver.poppedFromList(this, end);
        }
        return end;
    }

    public T popLeft(){
        if (store.isEmpty()){
            return null;
        }
        T end = store.get(0);
        store.remove(0);
        for (ListObserver listObserver:listObservers) {
            listObserver.poppedFromList(this, end);
        }
        return end;
    }

    public T getMinimum(){
        if(store.isEmpty())
        {
            return null;
        }
        return store.get(0);
    }

    public T getMaximum(){
        if(store.isEmpty())
        {
            return null;
        }
        return store.get(store.size()-1);
    }

    public T getMid(){
        if(store.isEmpty())
        {
            return null;
        }
        return store.get(store.size()/2);
    }

    public String toString(){
        if(store.isEmpty()){
            return "[]";
        }
        String output = "";
        StringBuilder builder = new StringBuilder(output);
        builder.append("[");
        for(int i = 0; i < store.size(); i++){
            builder.append(store.get(i));
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() -1);
        builder.append("]");
        return builder.toString();
    }

    public void addObserver(ListObserver add){
        listObservers.add(add);
    }


    public void removeObserver(ListObserver remove){
        listObservers.remove(remove);
    }
}