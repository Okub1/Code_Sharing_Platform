import java.util.*;

class AsciiCharSequence implements CharSequence {

    private byte[] array;

    public AsciiCharSequence(byte[] array) {
        this.array = array;
    }

    @Override
    public int length() {
        return this.array.length;
    }

    @Override
    public char charAt(int i) {
        return (char) this.array[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        byte[] temp = new byte[i1 - i];

        int it = 0;

        for (;i < i1; i++) {
            temp[it] = this.array[i];
            it++;
        }

        return new AsciiCharSequence(temp);
    }

    @Override
    public String toString() {
        return new String(this.array);
    }
}