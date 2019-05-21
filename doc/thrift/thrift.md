# thrift

thrift传输格式（协议）

- TBinaryProtocol 二进制格式
- **TCompactProtocol** 压缩格式
- TJSONProtocol JSON格式
- TSimpleJSONProtocol 提供JSON只写协议，生成的文件很容易通过脚本语言解析。
- TDebugProtocol 使用易懂的可读的文本格式，以便于debug

thrift传输方式（应用层）

- TSocket 阻塞式socket
- **TFramedTransport** 以frame为单位进行传输，非阻塞式服务中使用
- TFileTransport 文件形式传输
- TMemoryTransport 将内存用于I/O.java实现时内部实际使用了简单的ByteArrayOutputSteam。
- TZlibTransport 使用zlib进行压缩，与其他传输方式联合使用。当前无Java实现。

thrift支持的服务模型

- TSimpleServer 简单的单线程服务模型，常用于测试
- TThreadPoolServer 多线程服务模型，使用标准的阻塞式IO
- TNonblockingServer 多线程服务模型，使用非阻塞式IO（需要使用）
- **THsHaServer** THsHa引入了线程池去处理，其模型把读写任务放到线程池去处理；
Half-sync/Half-async的处理模式，Half-async是在处理IO事件上(accept/read/write io)，
Half-sync用于handler对rpc的同步处理。
