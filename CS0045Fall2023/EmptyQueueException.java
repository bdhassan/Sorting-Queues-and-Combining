package CS0045Fall2023;

public class EmptyQueueException extends RuntimeException
{
    public EmptyQueueException()
    {
        this("Queue is empty");
    }

    public EmptyQueueException(String message)
    {
        super(message);
    }
}

