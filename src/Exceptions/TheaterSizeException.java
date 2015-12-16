package exceptions;

/**
 * Created by Mikkel lamhauge on 10-12-2015.
 * used in instanciator for protection against corrupt Data in the theater table.
 */
public class TheaterSizeException extends Exception {

    public TheaterSizeException(String message)
    {
        super(message);
    }
}
