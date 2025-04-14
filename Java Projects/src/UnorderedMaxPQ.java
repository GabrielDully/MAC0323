public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;
    protected int capacity;

    @SuppressWarnings("unchecked")
    public UnorderedMaxPQ(int capacity) {
        this.capacity = capacity;
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty()
    {   return N    == 0;  }

    public void insert(Key element) {
        if (N == capacity) {
            throw new IllegalStateException("Exception: Priority Queue limit exceeded");
        } else {
            pq[N++] = element;
        }
    }

    public Key delMax() {
        int maxI = 0;
        for (int i = 1; i < N; i++) {
            if (pq[i].compareTo(pq[maxI]) > 0) maxI = i;
        }
        Key maxE = pq[maxI];

        for (int i = maxI; i < N - 1; i++) {
            pq[i] = pq[i+1];
        }
        N--;
        return maxE;
    }

    public Key max() {
        int maxI = 0;
        for (int i = 0; i < N; i++) {
            if (pq[i].compareTo(pq[maxI]) > 0) maxI = i;
        }
        return pq[maxI];
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        UnorderedMaxPQ<Integer> pq = new UnorderedMaxPQ<>(10);
        pq.insert(1);
        pq.insert(200);
        pq.insert(3);
        pq.insert(120);
        pq.insert(12);
        pq.insert(80);
        pq.insert(930);
        pq.insert(91);
        pq.insert(1101);
        pq.insert(200);

        for (int i = 0; i < 10; i++) System.out.println(pq.delMax());
    }
}
