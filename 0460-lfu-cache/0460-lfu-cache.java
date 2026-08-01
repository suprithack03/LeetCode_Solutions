class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {

        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void add(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0)
                return null;

            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    int capacity;
    int minFreq;

    HashMap<Integer, Node> nodeMap;
    HashMap<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {

        this.capacity = capacity;
        this.minFreq = 0;

        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {

        if (!nodeMap.containsKey(key))
            return -1;

        Node node = nodeMap.get(key);

        update(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0)
            return;

        if (nodeMap.containsKey(key)) {

            Node node = nodeMap.get(key);

            node.value = value;

            update(node);

            return;
        }

        if (nodeMap.size() == capacity) {

            DoublyLinkedList list = freqMap.get(minFreq);

            Node nodeToRemove = list.removeLast();

            nodeMap.remove(nodeToRemove.key);
        }

        Node newNode = new Node(key, value);

        minFreq = 1;

        DoublyLinkedList list =
                freqMap.getOrDefault(1, new DoublyLinkedList());

        list.add(newNode);

        freqMap.put(1, list);

        nodeMap.put(key, newNode);
    }

    private void update(Node node) {

        int freq = node.freq;

        DoublyLinkedList oldList = freqMap.get(freq);

        oldList.remove(node);

        if (freq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        DoublyLinkedList newList =
                freqMap.getOrDefault(node.freq, new DoublyLinkedList());

        newList.add(node);

        freqMap.put(node.freq, newList);
    }
}