# multi-thread-print
### 解决问题：
- 设计三个线程，一个线程只能输出1 一个线程只能输出2 一个线程只能输出3 。
  - 要求1 ：输出三个文件，内容分别是 123123123123.... 321321321... 312312312... 每个文件输出各自规范的数字 10 组
  - 要求2 ：按工具思路做。不要局限于题目内容本身
### 实现
  - 运行方法：
    - 1 controller.MainController 为主类
    - 2 在主类中使用service.ThreadManager#start(List<String> printValues, String file) 方法文件打印方法；参数printValues为打印的内容队列（分先后顺序），file为指定的文件路径；
      - ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200322221330436.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzI1MTg4MjU1,size_16,color_FFFFFF,t_70)
    - 运行结果：
      - ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200322221427623.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzI1MTg4MjU1,size_16,color_FFFFFF,t_70)
    
    
