package service;

import java.util.List;

/**
 * @author gengyukun
 * @version 1.0
 * @date 2020/3/22
 */
public interface ThreadManager {
    /**
     * 启动打印
     * @param values
     */
    void start(List<String> values, String file);
}
