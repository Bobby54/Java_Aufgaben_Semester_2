package student;

public interface ListObserver<T, E>
{
    public void pushedToList(T trigger, E element);

    public void poppedFromList(T trigger, E element);

}
