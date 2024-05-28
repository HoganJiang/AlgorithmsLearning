package chapter12.exercise;

/**
 * 练习题：给定一个字符串str，给定一个字符串类型的数组arr，出现的字符都是小写英文arr每一个字符串，代表一张贴纸，
 *         你可以把单个字符剪开使用，目的是拼出str来返回需要至少多少张贴纸可以完成这个任务。
 *         例子：str= "babac"，arr = {"ba","c","abcd"} ba + ba + c  3  abcd + abcd 2  abcd+ba 2
 *         所以返回2
 * @Auther: jiangyi
 * @Date: 2021-12-09
 * @Description:
 */
public class Exercise05 {

    public static int getMinStickers(String s, String[] stickers){
        if(s == null || s.length() == 0 || stickers == null || stickers.length == 0){
            return -1;
        }

        return 0;
//        return process(s,stickers,0);
    }

//    public static int process(String str, String[] stickers, int index){
//
//    }

}
