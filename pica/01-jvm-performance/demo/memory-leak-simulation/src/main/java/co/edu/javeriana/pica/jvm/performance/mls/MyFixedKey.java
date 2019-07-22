package co.edu.javeriana.pica.jvm.performance.mls;

public class MyFixedKey extends MyKey {

    public MyFixedKey(String key) {
        super(key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyFixedKey) {
            MyFixedKey other = (MyFixedKey) obj;
            return this.key.equals(other.key);
        }
        return false;
    }
}
