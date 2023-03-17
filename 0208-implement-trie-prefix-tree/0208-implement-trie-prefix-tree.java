class Trie {

    HashSet<String> hs;
    public Trie() {
        hs = new HashSet<>();
    }
    public void insert(String word) {
        hs.add(word);
    }
    public boolean search(String word) {
       return hs.contains(word) ? true : false;
    }
    public boolean startsWith(String prefix) {
        return hs.stream().filter(s -> s.startsWith(prefix)).findAny().isPresent();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */