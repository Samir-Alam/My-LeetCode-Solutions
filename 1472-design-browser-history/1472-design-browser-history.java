class BrowserHistory {

    List<String> history = new ArrayList<>(); 
    int end, cur;
    public BrowserHistory(String homepage) {
        history.add(homepage);
    }
    
    public void visit(String url) {
        if(history.size() >= end) history.add("");
        history.set(end = cur = cur + 1, url);
    }
    
    public String back(int steps) {
        return history.get(cur = Math.max(0, cur - steps));
    }
    
    public String forward(int steps) {
        return history.get(cur = Math.min(cur + steps, end));
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */