class Box< T >
{
    private T value;

    void setValue( T value )
    {
        this.value = value;
    }

    T getValue()
    {
        return value;
    }

    public static void main(String[] args)
    {
        Box< String > box = new Box<>();
        box.setValue( "Hello" );

        System.out.println( box.getValue() );
    }
}