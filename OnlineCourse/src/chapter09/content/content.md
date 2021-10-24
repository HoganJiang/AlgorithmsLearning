#### 1. 贪心算法
    （1）概念：贪心算法指的是按照人类最自然（每一步都是局部最优）的智慧得到全局最优解。
    （2）练习题1：给定一个由字符串组成的数组strs，必须把所有的字符串拼接起来，返回所有可能的拼接结果中，字典序最小的结果    --Exercise01.java
    （3）练习题2：一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
         给你每一个项目开始的时间和结束的时间,你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。返回最多的宣讲场次。      --Exercise02.java
    （4）练习题3：给定一个字符串str，只由‘X’和‘.’两种字符构成。‘X’表示墙，不能放灯，也不需要点亮‘.’表示居民点，可以
         放灯，需要点亮如果灯放在i位置，可以让i-1，i和i+1三个位置被点亮返回如果点亮str中所有需要点亮的位置，至少需要几盏灯  --Exercise03.java
    （5）练习题4：一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的金条，不管怎么切，都要花费20个铜板。 
        一群人想整分整块金条，怎么分最省铜板? 例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为60，金条要分成10，
        20，30三个部分。如果先把长度60的金条分成10和50，花费60; 再把长度50的金条分成20和30，花费50;一共花费110铜板。
        但如果先把长度60的金条分成30和30，花费60;再把长度30金条分成10和20， 花费30;一共花费90铜板。输入一个数组，返回分割
        的最小代价。                                                                                                   --Exercise04.java
    （6）练习题5：输入: 正数数组costs、正数数组profits、正数K、正数Mcosts[i]表示i号项目的花费profits[i]表示i号项目在扣除
        花费之后还能挣到的钱(利润)K表示你只能串行的最多做k个项目M表示你初始的资金说明: 每做完一个项目，马上获得的收益，可以
        支持你去做下一个项目。不能并行的做项目。输出：你最后获得的最大钱数。                                               --Exercise05.java