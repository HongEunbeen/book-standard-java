package ch08;

import java.io.File;

public class ExceptionEx16 {
    public static void main(String[] args) {
        try{
            File f = createFile(args[0]);
            System.out.println("파일이 성공적으로 생성되었습니다.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    static File createFile(String fileName) throws Exception{
        if(fileName == null || fileName.equals(""))
            throw new Exception("파일이름이 유효하지 않습니다.");
        File f = new File(fileName);
        f.createNewFile();
        return f;
    }
}
