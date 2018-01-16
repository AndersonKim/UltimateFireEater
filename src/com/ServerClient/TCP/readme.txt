在实际开发中，基于Socket编程，一般传递的并非字符串，很多情况下是对象，我们可以使用ObjectOutputStream将输出流对象序列化。
1             OutputStream outputStream = socket.getOutputStream();
2             ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
3             User user=new User("admin","123456");
4             objectOutputStream.writeObject(user);