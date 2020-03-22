package controller;

import service.Impl.ThreadManagerImpl;
import service.ThreadManager;

import java.util.Arrays;
import java.util.List;

/**
 * @author gengyukun
 * @version 1.0
 * @date 2020/3/22
 */
public class MainController {

    public static void main(String[] args) {
        ThreadManager threadManager = new ThreadManagerImpl();
        List<String> printValues = Arrays.asList("1", "2", "3");

        // 输出第一个文件
        threadManager.start(printValues, "/Users/gengyukun/tmp/test1");

        // 输出第二个文件
        printValues = Arrays.asList("3", "2", "1");
        threadManager.start(printValues, "/Users/gengyukun/tmp/test2");

        // 输出第三个文件
        printValues = Arrays.asList("3", "1", "2");
        threadManager.start(printValues, "/Users/gengyukun/tmp/test3");
    }
}
