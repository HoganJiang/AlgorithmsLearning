package chapter08.exercise;

import java.util.List;

/**
 * 题目：派对的最大快乐值
 * 公司的每个员工都符合 Employee 类的描述。整个公司的人员结构可以看作是一棵标准的、 没有环的多叉树。
 * 树的头节点是公司唯一的老板。除老板之外的每个员工都有唯一的直接上级。 叶节点是没有任何下属的基层员工(subordinates列表为空)，
 * 除基层员工外，每个员工都有一个或多个直接下级
 *
 * 员工信息的定义如下:
 * class Employee {
 *     public int happy; // 这名员工可以带来的快乐值
 *     List<Employee> subordinates; // 这名员工有哪些直接下级
 * }
 *
 */
public class Exercise09 {

    public static class Employee{
        public int happy;
        public List<Employee> nexts;

        public Employee(int happy, List<Employee> nexts){
            this.happy = happy;
            this.nexts = nexts;
        }
    }

    public static class Info {
        public int yes; //员工来的时候的最大快乐值
        public int no;  //员工不来的时候最大快乐值

        public Info(int yes, int no){
            this.yes = yes;
            this.no = no;
        }
    }

    public static int getMostHappy(Employee e){
        if(e == null){return 0;}
        Info allValue = process(e);
        return Math.max(allValue.yes,allValue.no);
    }

    public static Info process(Employee e){
        if(e.nexts.isEmpty()){
            return new Info(e.happy,0);
        }
        int yes = e.happy;
        int no = 0;
        for(Employee employee : e.nexts){
            Info nextInfo = process(employee);
            yes += nextInfo.no;
            no += Math.max(nextInfo.yes,nextInfo.no);
        }
        return new Info(yes,no);
    }
}
