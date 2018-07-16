package starter.service;

public interface MarkService {
    String write(String name,String content);

    String read(String name);

    String  delete(String name);

    String renew(String name,String content);

}
