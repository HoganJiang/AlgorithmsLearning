package chapter05.exericse;

import java.util.HashMap;

public class Exercise01 {
    public static void main(String[] args) {
        int arrLen = 100;
        int strLen = 20;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            String[] arr = Verifier01.generateRandomStringArray(arrLen, strLen);
            PrefixTree1 trie1 = new PrefixTree1();
            PrefixTree2 trie2 = new PrefixTree2();
            PrefixTree3 trie3 = new PrefixTree3();
            for (int j = 0; j < arr.length; j++) {
                double decide = Math.random();
                if (decide < 0.25) {
                    trie1.insert(arr[j]);
                    trie2.insert(arr[j]);
                    trie3.insert(arr[j]);
                } else if (decide < 0.5) {
                    trie1.delete(arr[j]);
                    trie2.delete(arr[j]);
                    trie3.delete(arr[j]);
                } else if (decide < 0.75) {
                    int ans1 = trie1.search(arr[j]);
                    int ans2 = trie2.search(arr[j]);
                    int ans3 = trie3.search(arr[j]);
                    if (ans1 != ans2 || ans2 != ans3) {
                        System.out.println("Search failed, Oops!");
                    }
                } else {
                    int ans1 = trie1.prefixCounts(arr[j]);
                    int ans2 = trie2.prefixCounts(arr[j]);
                    int ans3 = trie3.prefixCounts(arr[j]);
                    if (ans1 != ans2 || ans2 != ans3) {
                        System.out.println("PrefixCount failed, Oops! ans1 = " + ans1 + " ,ans2=" + ans2 + " ,ans3=" + ans3);
                    }
                }
            }
        }
        System.out.println("finish!");
    }
}

class PrefixTree1 {

    private Node root;

    public PrefixTree1() {
        this.root = new Node();
    }

    private class Node {
        private int pass;
        private int end;
        private Node[] child;

        public Node() {
            this.child = new Node[26];
        }
    }

    public void insert(String str){
        if(str == null) return;
        char[] word = str.toCharArray();
        int path = 0;
        Node node = root;
        node.pass++;
        for (int i = 0; i < word.length; i++){
            path = word[i] - 'a';
            if(node.child[path]  == null){
                node.child[path] = new Node();
            }
            node = node.child[path];
            node.pass++;
        }
        node.end++;
    }

    public int search(String str){
        if(str == null) return 0;
        char[] word = str.toCharArray();
        int path = 0;
        Node node = root;
        for (int i = 0; i < word.length; i++){
            path = word[i] - 'a';
            if(node.child[path]  == null){
                return 0;
            }
            node = node.child[path];
        }
        return node.end;
    }

    public void delete(String str){
        if(search(str) != 0){
            char[] word = str.toCharArray();
            Node node = root;
            node.pass--;
            int path = 0;
            for(int i = 0; i < word.length;i++){
                path = word[i] - 'a';
                if(--node.child[path].pass == 0){
                    node.child[path] = null;
                    return;
                }
                node = node.child[path];
            }
            node.end--;
        }
    }
    public int prefixCounts(String str){
        if(str == null) return 0;
        Node node = root;
        int path = 0;
        char[] word = str.toCharArray();
        for (int i = 0; i < word.length; i++){
            path = word[i] - 'a';
            if(node.child[path] == null){
                return 0;
            }
            node = node.child[path];
        }
        return node.pass;
    }
}

class PrefixTree2 {

    private Node root;
    private static class Node {
        private int pass;
        private int end;
        private HashMap<Integer,Node> child;

        public Node() {
            this.pass = 0;
            this.end =0;
            this.child = new HashMap<>();
        }
    }

    public PrefixTree2() {
        this.root = new Node();
    }

    public void insert(String str){
        if(str == null) return;

        Node node = root;
        node.pass++;
        int path = 0;
        char[] word = str.toCharArray();
        for(int i = 0; i < word.length; i++){
            path = (int) word[i];
            if(!node.child.containsKey(path)){
                node.child.put(path,new Node());
            }
            node = node.child.get(path);
            node.pass++;
        }
        node.end++;
    }
    public void delete(String str){
        if(search(str) != 0){
            Node node = root;
            node.pass--;
            int path = 0;
            char[] word = str.toCharArray();
            for(int i = 0; i < word.length; i++){
                path = (int)word[i];
                if(--node.child.get(path).pass == 0){
                    node.child.remove(path);
                    return;
                }
                node = node.child.get(path);
            }
            node.end--;
        }
    }

    public int search(String str){
        if(str == null) return 0;
        Node node = root;
        int path = 0;
        char[] word = str.toCharArray();
        for(int i = 0; i < word.length; i++){
            path = (int)word[i];
            if(!node.child.containsKey(path)){
                return 0;
            }
            node = node.child.get(path);
        }
        return node.end;
    }
    public int prefixCounts(String str){
        if(str == null) return 0;

        Node node = root;
        int path = 0;
        char[] word = str.toCharArray();
        for(int i = 0; i < word.length; i++){
            path = (int) word[i];
            if(!node.child.containsKey(path)){
                return 0;
            }
            node = node.child.get(path);
        }
        return node.pass;
    };
}

class PrefixTree3 {
    private HashMap<String, Integer> container;

    public PrefixTree3() {
        this.container = new HashMap<>();
    }

    public void insert(String str){
        if(!container.containsKey(str)){
            container.put(str,1);
        } else {
            container.put(str,container.get(str) + 1);
        }
    }

    public void delete(String str){
        if(container.containsKey(str)){
            if(container.get(str) == 1){
                container.remove(str);
            } else {
                container.put(str,container.get(str) - 1);
            }
        }
    }

    public int search(String str){
        if(!container.containsKey(str)){
            return 0;
        } else {
            return container.get(str);
        }
    }

    public int prefixCounts(String str){
        int count = 0;
        for(String word : container.keySet()){
            if(word.startsWith(str)){
                count += container.get(word);
            }
        }
        return count;
    }
}

class Verifier01 {

    public static String generateRandomString(int strLen) {
        char[] ans = new char[(int) (Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 6);
            ans[i] = (char) (97 + value);
        }
        return String.valueOf(ans);
    }

    public static String[] generateRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[(int) (Math.random() * arrLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }
}