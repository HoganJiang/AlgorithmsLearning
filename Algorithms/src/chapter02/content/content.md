#### 1. 单向链表与双向链表  
>- 练习题1：单向链表反转 --见Exercise01.java  
>- 练习题2：双向链表的反转 --见Exercise02.java    
>- 练习题3：删除单向链表指定的值 --见Exercise03.java  
>- 练习题4：删除双向链表指定的值 --见Exercise04.java
>- Java的内存泄露问题

#### 2. 栈，队列  
>- 练习题5：数组实现栈 --见Exercise05.java 
>- 练习题6：双向链表实现栈    
>- 练习题7：链表实现队列  
>- 练习题8：添加一个获取栈中最小值的方法，且算法的复杂度为O(1)  
>- 练习题9：用栈结构实现队列结构  
>- 练习题10：用队列结构实现栈结构  
>- 练习题11：数组实现环形队列

#### 3. 递归  
>-   从思想上理解递归：把一件事情分解成两个大的步骤，一个是寻找基础值的步骤，一个是递归步骤，最后由基础值递归到最后的结果。    
>-   从实际应用上理解递归：系统栈调用    
>-   练习题12：用递归实现寻找数组中的最大值  
   ~~~
   满足Master公式的递归可以计算时间复杂度
   形如T(N) = a * T(N/b) + O(N^d)(其中的a、b、d都是常数)
   的递归函数，可以直接通过Master公式来确定时间复杂度
   如果 log(b,a) < d，复杂度为O(N^d)
   如果 log(b,a) > d，复杂度为O(N^log(b,a))
   如果 log(b,a) == d，复杂度为O(N^d  * logN)
   ~~~

#### 4. 哈希表  
>-   了解Java中有序表（TreeMap）与无序表（HashMap,HashSet）的应用  
>-   Java的值拷贝与引用拷贝的区别  
>-   Java的HashMap与TreeMap对于基础类型都是值拷贝，非基础类型的Key引用传递  
>-   Java的Integer在（-128-127）是值拷贝，>127或者<-128是引用拷贝  
   