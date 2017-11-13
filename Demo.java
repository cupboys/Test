/**
 * 
 */
package demo;

import com.jcraft.jsch.JSchException;

/**
 * @author zhangchunfeng
 * 
 * 远程创建文件夹
 * 
 * */
public class Demo {

    public static void main(String[] args) {
        String USER = "";
        String PASSWORD = "";
        String HOST = "";
        int DEFAULT_SSH_PORT = 22;
        String PATH = "";
        try {
            if (args.length == 3) {
                USER = args[0].substring(0, args[0].indexOf('@')).trim();
                HOST = args[0].substring(args[0].indexOf('@') + 1).trim();
                PASSWORD = args[1].trim();
                PATH = args[2].trim();
            }
            int result = ShellUtils.execCmd("mkdir -p " + PATH, USER, PASSWORD, HOST, DEFAULT_SSH_PORT);

            if (result == 0) {
                System.out.println("create folder " + PATH + " success.");
            } else {
                System.out.println("create folder " + PATH + " falure.");
            }
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

}
