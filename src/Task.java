/**
 * author:  Adrian Kuta
 * indeks:  204423
 * date:    2015-04-08
 * email:   redione193 @ gmail.com
 */
public class Task {
    public int arg1, arg2;
    public String result = null;
    public char operator;

    @Override
    public String toString() {
        return arg1 + operator + arg2 + "=" + result;
    }
}
