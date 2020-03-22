package factory;

import helper.FileHelper;

import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author gengyukun
 * @version 1.0
 * @date 2020/3/22
 */
public interface ThreadFactory {

    /**
     * 创建线程方法
     *
     * @param printValue
     * @param position
     * @param semaphoreList
     * @param file
     * @return
     */
     Thread createThread(final String printValue, final Integer position, final List<Semaphore> semaphoreList, final String file);
}
