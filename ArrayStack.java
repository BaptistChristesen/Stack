
/**
 * This ArrayStack object represents a Stack ADT implemented as
 * an array using the StackInterface
 * 
 * @author  
 * @version 
 */
public class ArrayStack<T> implements StackInterface<T>
{
    private int size;
    private T[] stack;

    public ArrayStack()
    {
        // cannot create a generic array object, so has to be cast
        // from an Object back into the generic in order to compile
        stack = (T[]) new Object[1];
    }

    // returns the logical size of the stack
    public int size()    
    {
        return size;
    }

    // tests if this stack is empty
    public boolean empty()
    {
        if(size == 0){
            return true;
        }
        return false;
    }

    // looks at the object at the top of this stack
    // without removing it from the stack
    public T peek()
    {
        if(empty()){
            throw new StackUnderflowException("There is nothing in the stack, noob!");
        }
        return stack[size - 1];
    }

    // removes the object at the top of this stack 
    // and returns that object as the value of this function
    public T pop()
    {
        checkSize();
        T result = peek();
        stack[size - 1] = result;
        size--;
        return result;
    }

    // pushes an item onto the top of this stack
    public T push(T item)
    {
        checkSize();
        stack[size] = item;
        size++;
        return item;
    }

    // removes all of the elements from this stack
    public void clear()
    {
        while(size != 0){
            pop();
        }
    }

    // returns the 1 based position where an object is on this stack
    // note: when the method ends, the stack is the same as it was at the start
    public int search(Object o)
    {
        for(int i = 0; i < size; i++){
            if(((T)o).equals(stack[i])){
                return size - i;
            }
        }
        return -1;
    }
    
    private void checkSize(){
        int newSize; 
        if (size == stack.length){
            newSize = stack.length * 2;
        }
        else if (size < stack.length / 4){
            newSize = stack.length / 2;
        }
        else{
            return;
        }
        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++){
            temp[i] = stack[i];
        }
        stack = temp;
    }
}
