package factory;

import helper.FileHelper;

import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author gengyukun
 * @version 1.0
 * @date 2020/3/22
 */
public class PrintThreadFactory implements ThreadFactory{

    public Thread createThread(final String printValue, final Integer position, final List<Semaphore> semaphoreList, final String file) {
        final Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        Semaphore semaphore = semaphoreList.get(position);
                        Semaphore nextSemaphore = semaphoreList.size() <= position + 1 ? semaphoreList.get(0) : semaphoreList.get(position + 1);
                        semaphore.acquire();
                        FileHelper.print2File(printValue, file);
                        nextSemaphore.release();
                    }
                } catch (InterruptedException e) {
                    // 用日志系统记录
                    e.printStackTrace();
                } catch (Exception ioE) {
                    // 用日志系统记录
                    ioE.printStackTrace();
                    throw new RuntimeException("打印文件异常");
                }
            }
        });

        return thread;
    }
}
