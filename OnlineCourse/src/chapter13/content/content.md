#### 动态规划之技巧篇
    1. 数组压缩技巧
        1.1 练习题1：给定一个二维数组matrix，一个人必须从左上角出发，最后到达右下角沿途只可以向下或者向右走，沿途的数字都累加就是距离累加和返回最小距离累加和     --Exercise01.java
        推而广之：
        1. 动态规划中，某一普遍位置的值无论依赖于左上，左上左斜，都可以用数组压缩技巧的方法，从而节省空间
        2. 当列的长度很大，行的长度很小，则按行的长度申请数组的长度；当列的长度很小，行的长度很大时，则按照列的长度申请数组的长度
    
    2. 从左往右模型
        之：每个元素要或不要
        2.2 练习题2：arr是货币数组，其中的值都是正数。再给定一个正数aim。每个值都认为是一张货币，即便是值相同的货币也认为每一张都是不同的，
                    返回组成aim的方法数例如：arr = {1,1,1}，aim = 2 第0个和第1个能组成2，第1个和第2个能组成2，第0个和第2个能组成2一共就3种方法，所以返回3        --Exercise02.java
        之：每个元素用0次~最大次的枚举行为）
        2.2 练习题3：arr是面值数组，其中的值都是正数且没有重复。再给定一个正数aim。每个值都认为是一种面值，且认为张数是无限的。返回组成aim的方法数
                    例如：arr = {1,2}，aim = 4 方法如下：1+1+1+1、1+1+2、2+2一共就3种方法，所以返回3          --Exercise03.java
        2.2 练习题4：arr是货币数组，其中的值都是正数。再给定一个正数aim。每个值都认为是一张货币，认为值相同的货币没有任何不同，返回组成aim的方法数
                    例如：arr = {1,2,1,1,2,1,2}，aim = 4方法：1+1+1+1、1+1+2、2+2一共就3种方法，所以返回3    --Exercise04.java
        2.3 练习题5：给定5个参数，N，M，row，col，k表示在N*M的区域上，醉汉Bob初始在(row,col)位置Bob一共要迈出k步，且每步都会等概率向上下左右四个方向走
                    一个单位任何时候Bob只要离开N*M的区域，就直接死亡返回k步之后，Bob还在N*M的区域的概率   --Exercise05.java