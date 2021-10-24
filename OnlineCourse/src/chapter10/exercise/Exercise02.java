package chapter10.exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Exercise02 {

    public static class Node<V> {
        V value;
        public Node(V v){
            this.value = v;
        }
    }

    public static class UnionSet<V> {

        private HashMap<V, Node<V>> nodesMap;
        private HashMap<Node<V>, Node<V>> parentMap;
        private HashMap<Node<V>,Integer> sizeMap;

        public UnionSet (List<V> list){
            this.nodesMap = new HashMap<>();
            this.parentMap = new HashMap<>();
            this.sizeMap = new HashMap<>();
            for(V value : list){
                Node<V> node = new Node<>(value);
                nodesMap.put(value,node);
                parentMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        public boolean isSameSet(V a, V b){
            if(!nodesMap.containsKey(a) || !nodesMap.containsKey(b)) return false;
            return findFather(nodesMap.get(a)) == findFather(nodesMap.get(b));
        }

        public void union(V a, V b){
            if(!nodesMap.containsKey(a) || !nodesMap.containsKey(b)) return;
            Node<V> aHead = findFather(nodesMap.get(a));
            Node<V> bHead = findFather(nodesMap.get(b));
            if(aHead != bHead){
                Integer aHeadSize = sizeMap.get(aHead);
                Integer bHeadSize = sizeMap.get(bHead);
                Node<V> big = aHeadSize >= bHeadSize? aHead : bHead;
                Node<V> small = bHead == aHead? bHead : aHead;
                parentMap.put(small,big);
                sizeMap.put(big,aHeadSize + bHeadSize);
                sizeMap.remove(small);
            }
        }

        public Node<V> findFather(Node<V> cur){
            Stack<Node<V>> stack = new Stack<>();
            while(cur != parentMap.get(cur)){
                stack.push(cur);
                cur = parentMap.get(cur);
            }
            while(!stack.isEmpty()){
                parentMap.put(stack.pop(), cur);
            }
            return cur;
        }

        public Integer getCounts(){
            return sizeMap.size();
        }
    }

    public static class Student{
        private Integer stuID;
        private Integer bID;
        private Integer gitHubID;

        public Student(Integer stuID, Integer bID,Integer gitHubID){
            this.stuID = stuID;
            this.bID = bID;
            this.gitHubID = gitHubID;
        }

        public static Integer getStudentCounts(List<Student> studentLists){
            UnionSet<Student> unionSet = new UnionSet<>(studentLists);
            HashMap<Integer,Student> mapStuID = new HashMap<>();
            HashMap<Integer,Student> mapBID = new HashMap<>();
            HashMap<Integer,Student> gitHubID = new HashMap<>();

            for(Student student : studentLists){
                if(mapStuID.containsKey(student.stuID)){
                    unionSet.union(student, mapStuID.get(student.stuID));
                } else {
                    mapStuID.put(student.stuID,student);
                }
                if(mapBID.containsKey(student.bID)){
                    unionSet.union(student, mapBID.get(student.bID));
                } else {
                    mapBID.put(student.bID,student);
                }
                if(gitHubID.containsKey(student.gitHubID)){
                    unionSet.union(student, gitHubID.get(student.gitHubID));
                } else {
                    gitHubID.put(student.gitHubID,student);
                }
            }
            return unionSet.getCounts();
        }
    }


}
