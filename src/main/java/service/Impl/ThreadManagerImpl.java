package service.Impl;

import factory.PrintThreadFactory;
import factory.ThreadFactory;
import service.ThreadManager;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author gengyukun
 * @version 1.0
 * @date 2020/3/22
 */
public class ThreadManagerImpl implements ThreadManager {

    ThreadFactory threadFactory = new PrintThreadFactory();
    /**
     * 启动打印
     * @param values
     */
    public void start(List<String> values, String file) {
        if(values == null && values.size() != 0) {
            throw new RuntimeException("打印内容队列不符合规范");
        }

        final Semaphore A = new Semaphore(1);
        final Semaphore B = new Semaphore(1);
        final Semaphore C = new Semaphore(1);

        final List<Semaphore> semaphoreList = Arrays.asList(A, B, C);

        final String aPrintValue = values.get(0);
        final String bPrintValue = values.get(1);
        final String cPrintValue = values.get(2);

        Thread threadA = threadFactory.createThread(aPrintValue, 0, semaphoreList, file);
        Thread threadB = threadFactory.createThread(bPrintValue, 1, semaphoreList, file);
        Thread threadC = threadFactory.createThread(cPrintValue, 2, semaphoreList, file);

        try {
            B.acquire();
            C.acquire();
            threadA.start();
            threadB.start();
            threadC.start();
        } catch (InterruptedException e) {
            // 异常可记录在日志系统
            e.printStackTrace();
        }
    }
}
